package ksb2_cars_Vaadin_hwk4_v2;

import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.HasComponents;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLayout;
import org.springframework.beans.factory.annotation.Autowired;

@Route(value="show-colour", layout = MainLayout.class )
public class CarsColourShowGui extends Composite<VerticalLayout> implements buttonReturn, HasComponents, RouterLayout {

    private CarService carService;

    @Autowired
    public CarsColourShowGui(CarService carService) {
        this.carService = carService;

        Grid<Car> gridCars = new Grid<>(Car.class);
        gridCars.setColumns("id", "mark", "model", "colour");

        ComboBox<CarColour> comboBoxColours = new ComboBox<>("Colours");
        comboBoxColours.setItems(CarColour.values());
        comboBoxColours.addValueChangeListener(event -> {
            if (event.getSource().isEmpty()) {
                add(new Label("No colour selected"));
            } else {
                gridCars.setItems(carService.getCarListColored(comboBoxColours.getValue()));
                add(gridCars);
            }
        });

        add(comboBoxColours, addButtonReturn());
    }
}
