package ksb2_cars_Vaadin_hwk4_v2;


import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.HasComponents;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.dependency.StyleSheet;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLayout;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.HashSet;
@Route(value="remove-car", layout = MainLayout.class )

public class CarRemoveGui extends Composite<VerticalLayout> implements buttonReturn, HasComponents, RouterLayout {

    private CarService carService;

    @Autowired
    public CarRemoveGui(CarService carService) {
        this.carService = carService;

        HashSet<Long> ids = new HashSet<>();
        for (Car car : carService.getCarList()){
            ids.add(car.getId());
        }

        ComboBox<Long> comboBoxId = new ComboBox<>("Id");
        comboBoxId.setItems(ids);

        Dialog dialogCar = new Dialog();
        dialogCar.setWidth("400px");
        dialogCar.setHeight("150px");

        Button buttonRemove = new Button("Remove car");
        buttonRemove.addClickListener(buttonClick -> {
            dialogCar.removeAll();
            if (carService.deleteCar(comboBoxId.getValue())) {
                dialogCar.add(new Label("Car removed"));
            } else {
                dialogCar.add(new Label("No car with this id"));
            }
            dialogCar.open();
        });

        add(comboBoxId, buttonRemove, addButtonReturn());
    }
}
