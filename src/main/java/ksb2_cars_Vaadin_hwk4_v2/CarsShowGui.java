package ksb2_cars_Vaadin_hwk4_v2;

import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.HasComponents;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLayout;
import org.springframework.beans.factory.annotation.Autowired;

@Route(value = "show-cars", layout = MainLayout.class)
public class CarsShowGui extends Composite<VerticalLayout> implements buttonReturn, HasComponents, RouterLayout {


    private CarService carService;

    @Autowired
    public CarsShowGui(CarService carService) {
        this.carService = carService;

        Grid<Car> gridCars = new Grid<>(Car.class);
        gridCars.setColumns("id", "mark", "model", "colour");
        gridCars.setItems(carService.getCarList());

        add(gridCars, addButtonReturn());
    }

}
