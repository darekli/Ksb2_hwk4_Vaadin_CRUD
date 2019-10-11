//package ksb2hwk4vaadin;
//
//import com.vaadin.flow.component.button.Button;
//import com.vaadin.flow.component.grid.Grid;
//import com.vaadin.flow.component.orderedlayout.VerticalLayout;
//import com.vaadin.flow.component.textfield.TextField;
//import com.vaadin.flow.router.Route;
//import org.springframework.beans.factory.annotation.Autowired;
//
//@Route("cars")
//public class CarGui extends VerticalLayout {
//
//    private CarManager carManager;
//    private  CarService carService;
//
//    @Autowired
//    public CarGui(CarManager carManager) {
//        this.carManager = carManager;
////cars table
//        Grid<Car> grid = new Grid<>(Car.class);
//        grid.setItems(carManager.getCarList());
//
//        add(grid);
//
//        TextField textFieldId = new TextField();
//        textFieldId.setLabel("Id");
//        TextField textFieldMark = new TextField();
//        textFieldMark.setLabel("Mark");
//        TextField textFieldModel = new TextField();
//        textFieldModel.setLabel("Model");
//        TextField textFieldColor = new TextField();
//        textFieldColor.setLabel("Color");
//        //add car
//        Button buttonAdd = new Button("Add car");
//
//        buttonAdd.addClickListener(clickEvent -> {
//            Car car = new Car(textFieldId.getValue(), textFieldMark.getValue(), textFieldModel.getValue(), textFieldColor.getValue());
//            carManager.addCar(car);
//            carManager.getCarList().forEach(System.out::println);
//            grid.getDataProvider().refreshAll();
//        });
////remove car
//        Button buttonRemove = new Button("Remove car");
//
//        buttonRemove.addClickListener(clickEvent -> {
//            Car car = new Car(textFieldId.getValue(), textFieldMark.getValue(), textFieldModel.getValue(), textFieldColor.getValue());
//            carManager.removeCar(car);
//            carManager.getCarList().forEach(System.out::println);
//            //carManager.removeCar(String.valueOf(textFieldId.getValue()));
//            grid.getDataProvider().refreshAll();
//        });
//
//
//
//
//        add(textFieldId, textFieldMark, textFieldModel, textFieldColor, buttonAdd, buttonRemove);
//    }
//
//
//    public void removeCar(String id)
//    {
//        carService.removeCar(id);
//        if(carService.getCarById(id)==null)
//        {
//        }
//        else
//        {
//        }
//    }
//}
