package ksb2hwk4vaadin;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CarManager {

    private List<Car> carList;

    public CarManager() {
        carList = new ArrayList<>();
        carList.add(new Car("1", "Fiat", "Bravo", "gray"));
        carList.add(new Car("2", "Ford", "Focus", "white"));
        carList.add(new Car("3", "Opel", "Astra", "red"));
    }

    public List<Car> getCarList() {
        return carList;
    }

    public void addCar(Car car) {
        carList.add(car);
    }

    public void setCarList(List<Car> carList) {
        this.carList = carList;
    }
}
