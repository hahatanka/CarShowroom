import cars.Car;

import cars.Showroom;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;

public class Main {

    Showroom showroom = new Showroom();
    Scanner scanner = new Scanner(System.in);//if we move smth to the Main class it becomes available in every block of code

    //e.g. no need to call Scanner in every block you want to put it to, only need "scanner.nextln")
    public static void main(String[] args) {
        Main main = new Main();

        main.showMenu();

    }

    void showMenu() {
        String userInput = "";

        do {
            System.out.println("\nWelcome to the showroom, please choose an activity:");
            System.out.println("1. Add Car");
            System.out.println("2. View All Cars");
            System.out.println("3. View Single Car by ID");
            System.out.println("4. Remove Car by ID");
            System.out.println("5. Find car by chosen property");
            System.out.println("6. Remove Car");
            System.out.println("7. Update Car Info by chosen property");
//            System.out.println("8. Update Car Info by Name");
//            System.out.println("9. Update Car Info by Manufacturer");
//            System.out.println("10. Update Car Info by Type");
//            System.out.println("11. Find Car by Name");
            System.out.println("\nEnter Quit to end program...");

            System.out.println("Choose a number:");
            userInput = scanner.nextLine();

            switch (userInput) {
                case "Quit", "QUIT", "quit":
                    System.out.println("Exiting Application...");
                    break;
                case "1":
                    addCar();
                    break;
                case "2":
                    viewAllCars();
                    break;
                case "3":
                    viewSingleCar();
                    break;
                case "4":
                    removeOneCar();
                    break;
                case "5":
                    findCar();
                    break;
                case "6":
                    removeCar();
                    break;
                case "7":
                    updateCar();
                    break;
                case "8":
                    updateCarByName();
                    break;
                case "9":
                    updateCarByManuf();
                    break;
                case "10":
                   updateCarByType();
                   break;
                case "11":
                    findCarByName();
                default:
                    break;
            }
        } while (!userInput.equalsIgnoreCase("Quit")); //if NOT "quit" (!=not) the app will run all over again

        return;
    }

    void addCar() {
        System.out.println("Add Car");

        Car car = new Car();
        System.out.println("Enter Car Name: ");
        car.name = scanner.nextLine();

        System.out.println("Enter Manufacturer: ");
        car.manufacturer = scanner.nextLine();

        System.out.println("Enter Type: ");
        car.type = scanner.nextLine();

        car.id = UUID.randomUUID(); //creates a random id

        String message = showroom.addCar(car);
        System.out.println(message);
    }

    void viewAllCars() {
        ArrayList<Car> allCars = showroom.getAllCars();

        System.out.println("\nAll Available Cars");
        System.out.println("Car Name\t Manufacturer\t Car Type");
        for (Car car : allCars) {

            System.out.println("\n" + car.name + " \t" + car.manufacturer + "\t" + car.type + " \nThe ID is: " + car.id);
            //System.out.println(showroom.getAllCars());
        }
    }

    void viewSingleCar() {

        System.out.println("View Single Car");
        System.out.println("Enter Car ID: ");
        int carID = scanner.nextInt();
        //View specified car
        String message = showroom.getSingleCar(carID);
        System.out.println(message);
    }

    void removeOneCar() {
        //Create an input for User to enter car Id
        System.out.println("Enter Car ID to be Removed: ");// user should enter car id (= index in Array)
        int carIndex = scanner.nextInt();// User input is set as int variable "removeOneCar"
        String message = showroom.removeCar(carIndex);
        System.out.println(message);
        // we set a String variable "message" that returns to
        // the method showroom.removeCar() where the program uses variable "carIndex". Then we just print the "message"
        // CAN BE REPLACED BY
        //System.out.println(showroom.removeCar(carIndex));// but this is too complicated :)
    }

    void findCarByName() {
        System.out.println("Find car by name..");
        System.out.println("Enter car name: ");

        String carName = scanner.nextLine();

        Car car = showroom.findByName(carName);

        System.out.println("Car ID: " + car.id);
        System.out.println("Car name: " + car.name);
        System.out.println("Car manufacturer: " + car.manufacturer);
        System.out.println("Car type: " + car.type);
    }

    void removeCar() {
        System.out.println("Remove Car");
        System.out.println("Please choose:");
        System.out.println("a. Find car by name");
        System.out.println("b. Find car by manufacturer");
        System.out.println("c. Find car by type");

        String userInput = scanner.nextLine();
        switch (userInput) {
            case "a":
                System.out.println("Enter car name: ");
                String carName = scanner.nextLine();
                Car car = showroom.findByName(carName);
                int carIndex = showroom.getAllCars().indexOf(car);
                System.out.println(car.name + "" +  showroom.removeCar(carIndex));
                break;
            case "b":
                System.out.println("Enter car manufacturer: ");
                String carManuf= scanner.nextLine();
                Car car2 = showroom.findByManuf(carManuf);
                int carIndex2 = showroom.getAllCars().indexOf(car2);
                System.out.println(car2.name + "" + showroom.removeCar(carIndex2));
                break;
            case "c":
                System.out.println("Enter car type: ");
                String carType = scanner.nextLine();
                Car car3 = showroom.findByType(carType);
                int carIndex3 = showroom.getAllCars().indexOf(car3);
                System.out.println(car3.name + "" +  showroom.removeCar(carIndex3));
                break;
            default:
                break;
        }
    }

    void updateCarByName() {
        System.out.println("Find Car by NAME..");
        System.out.println("Enter car NAME: ");
        String carName = scanner.nextLine();

        Car car = showroom.findByName(carName);

        int carIndex = showroom.getAllCars().indexOf(car);
        System.out.println("Enter the property you wold like to change:");
        String property = scanner.nextLine();

        System.out.println("Enter the new value of: " + property);
        String value = scanner.nextLine();

        switch (property) {
            case "name":
                car.name = value;
                break;
            case "manufacturer":
                car.manufacturer = value;
                break;
            case "type":
                car.type = value;
                break;
            default:
                System.out.println("Please provide a value property");
                break;
        }
        showroom.updateCar(carIndex, car);
        System.out.println(car.name + " updated successfully, see new info below:");
        System.out.println("Car ID: " + car.id);
        System.out.println("Car name: " + car.name);
        System.out.println("Car manufacturer: " + car.manufacturer);
        System.out.println("Car type: " + car.type);

    }

//create methods to update car by manufacturer
//create method to update car by type

    //by manufacturer
    void updateCarByManuf() {
        System.out.println("Find Car by MANUFACTURER..");
        System.out.println("Enter car MANUFACTURER: ");
        String carManufacturer = scanner.nextLine();

        Car car = showroom.findByManuf(carManufacturer);

        int carIndex = showroom.getAllCars().indexOf(car);
        System.out.println("Enter the property you wold like to change:");
        String property = scanner.nextLine();

        System.out.println("Enter the new value of: " + property);
        String value = scanner.nextLine();

        switch (property) {
            case "name":
                car.name = value;
                break;
            case "manufacturer":
                car.manufacturer = value;
                break;
            case "type":
                car.type = value;
                break;
            default:
                System.out.println("Please provide a value property");
                break;
        }
        showroom.updateCar(carIndex, car);
        System.out.println(car.name + " updated successfully, see new info below:");
        System.out.println("Car ID: " + car.id);
        System.out.println("Car name: " + car.name);
        System.out.println("Car manufacturer: " + car.manufacturer);
        System.out.println("Car type: " + car.type);
    }

    void updateCarByType() {
        System.out.println("Find Car by TYPE..");
        System.out.println("Enter car TYPE: ");
        String carType = scanner.nextLine();

        Car car = showroom.findByType(carType);

        int carIndex = showroom.getAllCars().indexOf(car);
        System.out.println("Enter the property you wold like to change:");
        String property = scanner.nextLine();

        System.out.println("Enter the new value of: " + property);
        String value = scanner.nextLine();

        switch (property){
            case "name":
                car.name = value;
                break;
            case "manufacturer":
                car.manufacturer = value;
                break;
            case "type":
                car.type = value;
                break;
            default:
                System.out.println("Please provide a valid property");
                break;
        }
        showroom.updateCar(carIndex, car);
        System.out.println(car.name + " updated successfully, see new info below:");
        System.out.println("Car ID: " + car.id);
        System.out.println("Car name: " + car.name);
        System.out.println("Car manufacturer: " + car.manufacturer);
        System.out.println("Car type: " + car.type);
    }

    void updateCar() {
        System.out.println("Update car by chosen property");
        System.out.println("Please choose:");
        System.out.println("a. Update by name");
        System.out.println("b. Update by manufacturer");
        System.out.println("c. Update by type");

        String userInput = scanner.nextLine();
        switch (userInput){
            case "a":
                updateCarByName();
                break;
            case"b":
                updateCarByManuf();
            case"c":
                updateCarByType();
                break;
            default:
                break;
        }
    }

// Create search menu where user can select the property they want to search for, i.e. "manufacturer or type  or name" and ask the user to put in the property "manufacturer i.e. volvo"
// e.g. Please select the parameter for your search:
// 1. manuf
// 2. type
// 3. name
void findCar() {
    System.out.println("Find car by chosen property");
    System.out.println("Please choose:");
    System.out.println("a. Find by name");
    System.out.println("b. Find by manufacturer");
    System.out.println("c. Find by type");
    String userInput = scanner.nextLine();
    switch (userInput) {
        case "a":
            System.out.println("Enter the car name:");
            String carName = scanner.nextLine();
            Car car = showroom.findByName(carName);

            System.out.println("Car ID: " + car.id);
            System.out.println("Car name: " + car.name);
            System.out.println("Car manufacturer: " + car.manufacturer);
            System.out.println("Car type: " + car.type);
            break;
        case "b":
            System.out.println("Enter the car manufacturer:");
            String carManuf = scanner.nextLine();
            Car car2 = showroom.findByManuf(carManuf);

            System.out.println("Car ID: " + car2.id);
            System.out.println("Car name: " + car2.name);
            System.out.println("Car manufacturer: " + car2.manufacturer);
            System.out.println("Car type: " + car2.type);
            break;
        case "c":
            System.out.println("Enter the car type:");
            String carType = scanner.nextLine();
            Car car3 = showroom.findByType(carType);

            System.out.println("Car ID: " + car3.id);
            System.out.println("Car name: " + car3.name);
            System.out.println("Car manufacturer: " + car3.manufacturer);
            System.out.println("Car type: " + car3.type);
            break;
        default:
            break;
    }
}
}




