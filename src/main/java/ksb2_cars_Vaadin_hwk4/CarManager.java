package ksb2_cars_Vaadin_hwk4;

import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarManager {

    List<Car> carList;

    public CarManager() {

        carList = new ArrayList<>();
        carList.add(new Car("1", "Fiat", "Bravo", "gray"));
        carList.add(new Car("2", "Ford", "Focus", "white"));
        carList.add(new Car("3", "Opel", "Astra", "red"));
    }

    public List<Car> getCarList() {
        return carList;     //pobieranie nowej listy
    }

    public void addCar(Car car) {
        carList.add(car);   //dodawanie nowych elementów
    }

    public void setCarList(List<Car> carList) {
        this.carList = carList;         //zapisywanie nowej listy
    }

    public void removeCar(Car car) {
        carList.remove(car);   //usuwanie elementów
    }
//**************
    public void deleteCar(Car id) {
        carList.remove(id);
    }

}
