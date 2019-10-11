package ksb2_cars_Vaadin_hwk4;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

@Route ("add-car")
public class CarAdderGui extends VerticalLayout {

    private CarManager carManager;

    @Autowired
    public CarAdderGui(CarManager carManager) {
        this.carManager = carManager;

        TextField textFieldId = new TextField("Id");
        TextField textFieldMark = new TextField("Mark");
        TextField textFieldModel = new TextField("Model");
        TextField textFieldColor = new TextField("Color");

        Button buttonAdd = new Button("Add new car");
//add car
        buttonAdd.addClickListener(clickEvent -> {
            Car car = new Car(textFieldId.getValue(), textFieldMark.getValue(), textFieldModel.getValue(), textFieldColor.getValue());
            carManager.addCar(car);
            carManager.getCarList().forEach(System.out::println);
        });
//remove car
        TextField textFieldByIdToRemove = new TextField("Car by Id to remove");
        Button buttonRemove = new Button("Remove car");

        buttonRemove.addClickListener(clickEvent -> {
            Car car = new Car(textFieldId.getValue());
            carManager.deleteCar(car);
            carManager.getCarList().forEach(System.out::println);
//todo not working yet
        });



        add(textFieldId, textFieldMark, textFieldModel, textFieldColor, buttonAdd,textFieldByIdToRemove, buttonRemove);
        Grid<Car> grid = new Grid<>(Car.class);
        grid.setItems(carManager.getCarList());

        add(grid);


    }
}
