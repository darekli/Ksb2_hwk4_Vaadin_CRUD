package ksb2hwk4vaadin;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

@Route("add-car")
public class CarAdderGui extends VerticalLayout {

    private CarManager carManager;

    @Autowired
    public CarAdderGui(CarManager carManager) {
        this.carManager = carManager;

        TextField textFieldId = new TextField();
        textFieldId.setLabel("Id");
        TextField textFieldMark = new TextField();
        textFieldMark.setLabel("Mark");
      //  TextField textFieldModel = new TextField("Model");
        TextField textFieldModel = new TextField();
        textFieldModel.setLabel("Model");
        TextField textFieldColor = new TextField();
        textFieldColor.setLabel("Color");
        Button buttonAdd = new Button("Add car");

        buttonAdd.addClickListener(clickEvent -> {
            Car car = new Car(textFieldId.getValue(),textFieldMark.getValue(),textFieldModel.getValue(),textFieldColor.getValue());
            carManager.addCar(car);
            carManager.getCarList().forEach(System.out::println);
        });

        add(textFieldId, textFieldMark, textFieldModel,textFieldColor, buttonAdd);
    }
}