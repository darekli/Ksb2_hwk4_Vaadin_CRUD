package ksb2hwk4vaadin;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CarComponent {

    private List<Car> carList;

    public CarComponent() {
        carList = new ArrayList<>();
        carList.add(new Car(1L, "Fiat", "Bravo", "gray"));
        carList.add(new Car(2L, "Ford", "Focus", "white"));
        carList.add(new Car(3L, "Opel", "Astra", "red"));
    }

    public List<Car> getCarList() {
        return carList;
    }
}
