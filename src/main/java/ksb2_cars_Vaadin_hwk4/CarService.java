package ksb2_cars_Vaadin_hwk4;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CarService {

    List<Car> carList;

    public CarService() {
        this.carList = new ArrayList<>();

        carList.add(new Car(1l, "Fiat", "Bravo", "gray"));
        carList.add(new Car(2l, "Ford", "Focus", "white"));
        carList.add(new Car(3l, "Opel", "Astra", "red"));
    }

    public List<Car> getCarList() {
        return carList;     //pobieranie nowej listy
    }

    public Optional<Car> getFirstCar(long id) {
        return carList.stream().filter(car -> car.getId() == id).findFirst();
    }

    public boolean addCar(Car car) {
        if (car.getMark() != null && !car.getModel().isEmpty() && car.getColor() != null) {
            return carList.add(car);   //dodawanie nowych elementów
        }
        return false;
    }

    public void setCarList(List<Car> carList) {
        this.carList = carList;         //zapisywanie nowej listy
    }

//    public boolean removeCar(Car id) {
//        carList.remove(id);

//        carList.remove(car);   //usuwanie elementów
//    }
//**************
public boolean deleteCar(long id) {
    Optional<Car> firstCar = carList.stream().filter(car -> car.getId() == id).findFirst();
    if (firstCar.isPresent()) {
        carList.remove(firstCar.get());
        return true;
    }
    return false;
}


}
