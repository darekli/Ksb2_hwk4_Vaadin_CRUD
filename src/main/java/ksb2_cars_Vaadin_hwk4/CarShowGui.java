package ksb2_cars_Vaadin_hwk4;


import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

@Route ("show-car")
public class CarShowGui extends VerticalLayout implements buttonReturn {

    private CarService carService;


    @Autowired
    public CarShowGui(CarService carService) {
        this.carService = carService;

        Grid<Car> grid = new Grid<>(Car.class);
        grid.setItems(carService.getCarList());

        add(grid,addButtonReturn());
    }

}
