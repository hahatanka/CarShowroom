package cars;

import java.util.ArrayList;

public class Showroom {
    //creating a lIST OF CARS from the auto stored in the Car class
    private ArrayList<Car> cars = new ArrayList<Car>();

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



}
