package cars;

import java.util.ArrayList;

public class Showroom {
    //creating a lIST OF CARS from the auto stored in the Car class
    public ArrayList<Car> cars = new ArrayList<Car>();

    //addCar
    public String addCar(Car car) { //adding (declaring a variable) a car from the Car class
        this.cars.add(car);
        return car.name + " added successfully";
    }
    //getAllCars
    public ArrayList<Car> getAllCars() { //create a list of all cars
        return cars;
    }
    //getSingleCar
//    public Car getSingleCar(int carId){
//        return this.cars.get(carId);
    public String getSingleCar(int carID) {
        try {
            Car car = this.cars.get(carID);
            return "Car Number: " + car.id + "\nCar Name " + car.name + "\nCar Manufacturer " + car.manufacturer + "\nCar Type " + car.type;
        } catch (Exception ex) {
            return "Unable to find car. Please try again with  valid car index";
        }

    }
    //removeCar
    public String removeCar(int carId) {
        try {
            cars.remove(carId);
        } catch (Exception ex) {
            return "Unable to remove specified car";
        }
        return "car removed successfully";
    }
    //Find car by name
    public Car findByName(String name) {
        //Loop over the cars in the showroom and check each name equals to the specified name
        //Return the desired car is true
        for (Car car: cars) {
            if(car.name.equals(name)) {
                return car;
            }
        }
        return null;
    }
    //Find car by manufacturer
    //!!! create array list of cars of the same manufacturer
    //change loop to add each car that equals the name to the new array list created
    //when loop is done, return new array list (change the return value of the method to an array list of cars
    public Car findByManuf(String manufacturer) {
        for (Car car: cars) {
            if(car.manufacturer.equals(manufacturer)) {
                return car;
            }
        }
        return null;
    }
    //Find car by type
    public Car findByType(String type) {
        for (Car car: cars) {
            if(car.type.equals(type)) {
                return car;
            }
        }
        return null;
    }
    //update car
    public Car updateCar(int carIndex, Car car) {
        return cars.set(carIndex, car);
    }
}
