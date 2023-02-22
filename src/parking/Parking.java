package parking;

import java.util.*;

public class Parking {

    private String type;
    private int capacity;
    private Collection<Car> cars;

    public Parking(String type, int capacity) {
        this.type = type;
        this.capacity = capacity;
        this.cars = new ArrayList<>();
    }

    public void add(Car car) {
        if (cars.size() < capacity) {
            cars.add(car);
        }
    }

    public boolean remove(String manufacturer, String model) {
        for (Car car : cars) {
            if (car.getManufacturer().equals(manufacturer) && car.getModel().equals(model)) {
                cars.remove(car);
                return true;
            }
        }
        return false;
    }

    public Car getLatestCar() {
        Car car = null;
        int maxYear = 0;
        for (Car car1 : cars) {
            if (car1.getYear() > maxYear) {
                car = car1;
                maxYear = car1.getYear();
            }
        }
        if (cars.size() > 0) {
            return car;
        }
        return null;
    }

    public Car getCar(String manufacturer, String model) {
        for (Car car : cars) {
            if (car.getManufacturer().equals(manufacturer) && car.getModel().equals(model)) {
                return car;
            }
        }
        return  null;
    }

    public int getCount() {
        return cars.size();
    }

    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("The cars are parked in %s:", type)).append(System.lineSeparator());

        for (Car car : cars) {
            sb.append(car.toString()).append(System.lineSeparator());
        }
        return sb.toString().trim();
    }

}
