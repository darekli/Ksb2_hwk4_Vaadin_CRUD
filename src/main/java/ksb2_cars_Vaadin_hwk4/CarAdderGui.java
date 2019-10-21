//package ksb2_cars_Vaadin_hwk4;
//
//import com.vaadin.flow.component.button.Button;
//import com.vaadin.flow.component.grid.Grid;
//import com.vaadin.flow.component.orderedlayout.VerticalLayout;
//import com.vaadin.flow.component.textfield.NumberField;
//import com.vaadin.flow.component.textfield.TextField;
//import com.vaadin.flow.router.Route;
//import org.springframework.beans.factory.annotation.Autowired;
//
//@Route ("add-car")
//public class CarAdderGui extends VerticalLayout implements buttonReturn{
//
//    private CarService carService;
//
//    @Autowired
//    public CarAdderGui(CarService carService) {
//        this.carService = carService;
//
//        NumberField numberFieldId = new NumberField("Id");
//        TextField textFieldMark = new TextField("Mark");
//        TextField textFieldModel = new TextField("Model");
//        TextField textFieldColor = new TextField("Color");
//
//
//        //add car
//        Button buttonAdd = new Button("Add new car");
//        buttonAdd.addClickListener(clickEvent -> {
//           Car car = new Car(numberFieldId.getValue(),textFieldMark.getValue(),textFieldModel.getValue(), textFieldColor.getValue());
//            carService.addCar(car);
//            carService.getCarList().forEach(System.out::println);
//        });
//
//        add(numberFieldId, textFieldMark, textFieldModel, textFieldColor, buttonAdd, addButtonReturn());
//        Grid<Car> grid = new Grid<>(Car.class);
//        grid.setItems(carService.getCarList());
//
//        add(grid);
//
//
//    }
//}
