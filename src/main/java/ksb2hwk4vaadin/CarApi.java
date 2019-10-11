//package ksb2hwk4vaadin;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//import java.util.Optional;
//
//@RestController
//@RequestMapping("/car")
//public class CarApi {
//
//    private CarService carService;
//    private CarManager carManager;
//    private Optional<Car> carList;
//
//    @Autowired
//    public CarApi(CarService carService) {
//        this.carService = carService;
//    }
//
//    @GetMapping(produces = {
//            MediaType.APPLICATION_JSON_VALUE,
//            MediaType.APPLICATION_XML_VALUE})
//    public ResponseEntity<List<Car>> getCars() {
//        List<Car> carList = carService.getCars();
//        return new ResponseEntity<>(carList, HttpStatus.ACCEPTED.OK);
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<Car> getCarById(@PathVariable String id) {
//        Optional<Car> first = carService.getCarById(id);
//        if (first.isPresent()) {
//            return new ResponseEntity<>(first.get(), HttpStatus.OK);
//        }
//        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//    }
//
//    @GetMapping("/color")
//    public ResponseEntity<List<Car>> getCarByColor(@RequestParam String color) {
//        List<Car> carColorList = carService.getCarsByColor(color);
//        if (!carColorList.isEmpty()) {
//            return new ResponseEntity<>(carColorList, HttpStatus.OK);
//        }
//        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//    }
//
//    @PutMapping("/modifiedCars")
//    public ResponseEntity<Car> modifyCarByOneField(@RequestBody Car modifyCarByField) {
//        boolean modifiedCarByFieldList = carService.modifyCarByField(modifyCarByField);
//        if (modifiedCarByFieldList) {
//            return new ResponseEntity("Created", HttpStatus.OK);
//        }
//        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//    }
//
//
//    @PostMapping
//    public ResponseEntity addNewCar(@RequestBody Car newCar) {
//        boolean isAdded = carService.addNewCar(newCar);
//        if (isAdded) {
//            return new ResponseEntity("New car added.", HttpStatus.CREATED);
//        }
//        return new ResponseEntity("Internal server error.", HttpStatus.INTERNAL_SERVER_ERROR);
//    }
//
//
//    @PutMapping
//    public ResponseEntity modifyCar(@RequestBody Car modCar) {
//        boolean isChanged = carService.modifyCar(modCar);
//        if (isChanged) {
//            return new ResponseEntity("Modified.", HttpStatus.OK);
//        }
//        return new ResponseEntity("Not found.", HttpStatus.NOT_FOUND);
//    }
//
//
//    //    @DeleteMapping("/{id}")
////    public ResponseEntity removeCar(@PathVariable String id) {
////        boolean isDeleted = carService.removeCar(id);
////        if (isDeleted) {
////            return new ResponseEntity("It was deleted.", HttpStatus.OK);
////        }
////        return new ResponseEntity("Not found. Nothing was deleted.",HttpStatus.NOT_FOUND);
////    }
//    @DeleteMapping("/{id}")
//    public ResponseEntity removeCar(@PathVariable String id) {
//        Optional<Car> first = carList.stream().filter(car -> car.getId() == id).findFirst();
//        if (first.isPresent()) {
//            carList.remove(first.get());
//            return new ResponseEntity<>(first.get(), HttpStatus.OK);
//        }
//        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//
//    }
//}
