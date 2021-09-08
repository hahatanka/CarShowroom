import cars.Car;
import cars.Showroom;
import jdk.swing.interop.SwingInterOpUtils;

import javax.print.DocFlavor;
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
            System.out.println("3. View Single Car");
            System.out.println("4. Remove Car");
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
                case  "4":
                    removeOneCar();

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
        for (Car car: allCars) {

            System.out.println("\n" + car.name + " \t" + car.manufacturer+ "\t" + car.type + " \nThe ID is: " + car.id);
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
//        System.out.println("Car Number: " + car.id);
//        System.out.println("Car Name: " + car.name);
//        System.out.println("Car Manufacturer: " + car.manufacturer);
//        System.out.println("Car Type: " + car.type);
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
}


//            switch (carEntered) {
//                case "Toyota", "TOYOTA", "toyota":
//                    System.out.println("You have chosen " + "Toyota ID" + showroom.getSingleCar(0));
//                    break;
//                case "Audi", "AUDI", "audi":
//                    System.out.println("You have chosen " + "Audi ID" + showroom.getSingleCar(1));
//                    break;
//                case "BMW", "bmw":
//                    System.out.println("You have chosen " + " BMW ID" + showroom.getSingleCar(2));
//                    break;
//                default:
//                    System.out.println("Your car is unavailable");
//            }
//    }

//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Enter Car Name to be Removed: ");
//        String removeCar = scanner.next();
//        switch (removeCar) {
//            case "Toyota", "toyota", "TOYOTA":
//                System.out.println(showroom.removeCar(0));
//                break;
//            case "Audi", "audi", "AUDI":
//                System.out.println(showroom.removeCar(1));
//                break;
//            case "BMW", "bmw":
//                System.out.println(showroom.removeCar(2));
//                break;

