package ksb2_cars_Vaadin_hwk4_v2;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.radiobutton.RadioButtonGroup;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.HashSet;

@Route("mod-car")
public class CarModGui extends VerticalLayout implements buttonReturn {

    private CarService carService;

    @Autowired
    public CarModGui(CarService carService) {
        this.carService = carService;

        HashSet<Long> ids = new HashSet<>();
        for (Car car : carService.getCarList()){
            ids.add(car.getId());
        }

        ComboBox<Long> comboBoxId = new ComboBox<>("Id");
        comboBoxId.setItems(ids);
        RadioButtonGroup<CarMark> groupMark = new RadioButtonGroup<>();
        groupMark.setLabel("Mark");
        groupMark.setItems(CarMark.values());
        TextField placeholderFieldModel = new TextField();
        placeholderFieldModel.setPlaceholder("Model");
        RadioButtonGroup<CarColour> groupColour = new RadioButtonGroup<>();
        groupColour.setLabel("Colour");
        groupColour.setItems(CarColour.values());

        Dialog dialogCar = new Dialog();
        dialogCar.setWidth("400px");
        dialogCar.setHeight("150px");

        Button buttonMod = new Button("Modify car");
        buttonMod.addClickListener(buttonClick -> {
            Car modCar = new Car(comboBoxId.getValue(), groupMark.getValue(),
                    placeholderFieldModel.getValue(), groupColour.getValue());
            dialogCar.removeAll();

            if (carService.changeCar(modCar)) {
                dialogCar.add(new Label("Modification successful"));
            } else {
                dialogCar.add(new Label("Error"));
            }
            dialogCar.open();
        });

        add(comboBoxId, groupMark, placeholderFieldModel, groupColour, buttonMod, addButtonReturn());
    }
}
