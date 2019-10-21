package ksb2_cars_Vaadin_hwk4_v2;


import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.HasComponents;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import com.vaadin.flow.router.RouterLayout;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.HashSet;

@Route(value="mod-car-field", layout = MainLayout.class )
//@RouteAlias(value = "", layout = MainLayout.class)

public class CarFieldModGui extends Composite<VerticalLayout> implements buttonReturn, HasComponents, RouterLayout {

    private CarService carService;

    public CarFieldModGui() {
        add(new H2("Modify menu"));
    }

    @Autowired
    public CarFieldModGui(CarService carService) {
        this.carService = carService;

        HashSet<Long> ids = new HashSet<>();
        for (Car car : carService.getCarList()){
            ids.add(car.getId());
        }

        ComboBox<Long> comboBoxId = new ComboBox<>("Id");
        comboBoxId.setItems(ids);

        ComboBox<CarMark> comboBoxMark = new ComboBox<>("Mark");
        comboBoxMark.setItems(CarMark.values());
        TextField textFieldModel = new TextField("Model");
        ComboBox<CarColour> comboBoxColour = new ComboBox<>("Colour");
        comboBoxColour.setItems(CarColour.values());

        Dialog dialogCar = new Dialog();
        dialogCar.setWidth("400px");
        dialogCar.setHeight("150px");

        Button buttonMod = new Button("Modify field");
        buttonMod.addClickListener(buttonClick -> {
            dialogCar.removeAll();
            if (carService.changeField(comboBoxId.getValue(), comboBoxMark.getValue(),
                    textFieldModel.getValue(), comboBoxColour.getValue())) {
                dialogCar.add(new Label("Modification successful"));
            } else {
                dialogCar.add(new Label("Error"));
            }
            dialogCar.open();
        });

        add(comboBoxId, comboBoxMark, textFieldModel, comboBoxColour, buttonMod, addButtonReturn());
    }
}
