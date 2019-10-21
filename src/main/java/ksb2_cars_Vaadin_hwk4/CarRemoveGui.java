package ksb2_cars_Vaadin_hwk4;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

@Route("remove-car")
public class CarRemoveGui extends VerticalLayout implements buttonReturn {

   private CarService carService;

@Autowired

    public CarRemoveGui(CarService carService) {
    this.carService = carService;



        Grid<Car> grid = new Grid<>(Car.class);
        grid.setItems(carService.getCarList());
    NumberField numberFieldId = new NumberField("Id");
    Button buttonRemove = new Button("Remove car");

    buttonRemove.addClickListener(buttonClick -> {
        Car car = new Car();
      //  carManager.deleteCar(d);
    });


        add(grid,numberFieldId,buttonRemove,addButtonReturn());


/*
    Button buttonAdd = new Button("Add new car");
        buttonAdd.addClickListener(clickEvent -> {
                Car car = new Car(numberFieldId.getValue(), textFieldMark.getValue(), textFieldModel.getValue(), textFieldColor.getValue());
                carManager.addCar(car);
                carManager.getCarList().forEach(System.out::println);
                });

                add(numberFieldId, textFieldMark, textFieldModel, textFieldColor, buttonAdd, addButtonReturn());
                Grid<Car> grid = new Grid<>(Car.class);
        grid.setItems(carManager.getCarList());

        add(grid);*/
}}
