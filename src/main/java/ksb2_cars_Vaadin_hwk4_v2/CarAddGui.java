package ksb2_cars_Vaadin_hwk4_v2;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.HasComponents;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLayout;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.Optional;

@Route(value="add-cars", layout = MainLayout.class )
public class CarAddGui extends Composite<VerticalLayout> implements buttonReturn, HasComponents, RouterLayout {

    private CarService carService;

    @Autowired
    public CarAddGui(CarService carService) {
        this.carService = carService;

        NumberField numberFieldId = new NumberField("Id");
        ComboBox<CarMark> comboBoxMark = new ComboBox<>("Mark");
        comboBoxMark.setItems(CarMark.values());
        TextField textFieldModel = new TextField("Model");
        ComboBox<CarColour> comboBoxColour = new ComboBox<>("Colour");
        comboBoxColour.setItems(CarColour.values());

        Dialog dialogCar = new Dialog();
        dialogCar.setWidth("400px");
        dialogCar.setHeight("50px");

        Button buttonAdd = new Button("Add car");
        buttonAdd.addClickListener(buttonClick -> {
            Optional<Car> firstCar = carService.getFirstCar(numberFieldId.getValue().longValue());
            dialogCar.removeAll();
            if (firstCar.isPresent()) {
                dialogCar.add(new Label("There is already a car with this id"));
            } else {
                Car newCar = new Car(numberFieldId.getValue().longValue(), comboBoxMark.getValue(),
                        textFieldModel.getValue(), comboBoxColour.getValue());
                if (carService.addNewCar(newCar)) {
                    dialogCar.add(new Label("Adding completed successfully"));
                } else {
                    dialogCar.add(new Label("Not all car values"));
                }
            }
            dialogCar.open();
        });

        add(numberFieldId, comboBoxMark, textFieldModel, comboBoxColour, buttonAdd, addButtonReturn());
    }
}
