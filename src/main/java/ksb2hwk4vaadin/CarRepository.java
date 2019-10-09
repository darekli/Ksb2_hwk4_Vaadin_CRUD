package ksb2hwk4vaadin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CarRepository {

    private CarComponent carComponent;

    private List<Car> carList;

    @Autowired
    public CarRepository(CarComponent carComponent) {
        this.carComponent = carComponent;
    }

    public List<Car> getCarList() {
        return carList = carComponent.getCarList();
    }
}
