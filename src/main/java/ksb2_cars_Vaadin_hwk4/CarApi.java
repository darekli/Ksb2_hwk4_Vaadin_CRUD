//package ksb2_cars_Vaadin_hwk4;
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
//    @RestController
//    @RequestMapping(value ="/cars",
//produces = {
//            MediaType.APPLICATION_XML_VALUE,
//            MediaType.APPLICATION_JSON_VALUE})
//
//
//    public class CarApi {
//        private CarService carService;
//
//        @Autowired
//        public CarApi(CarService carService) {
//            this.carService = carService;
//        }
//
//
//        public ResponseEntity<List<Car>> getCar() {
//            return new ResponseEntity<>(carList, HttpStatus.OK);
//        }
//
//        @GetMapping("{id}")
//        public ResponseEntity<Car> getCarById(@PathVariable String id) {
//            Optional<Car> first = carList.stream().filter(car -> car.getId() == id).findFirst();
//            if (first.isPresent()) {
//                return new ResponseEntity<>(first.get(), HttpStatus.OK);
//            }
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//
//        @PatchMapping("/{id}/{color}")
//        public ResponseEntity modCarElement(@PathVariable String id, @PathVariable String color) {
//            Optional<Car> firstCar = carList.stream().filter(carFromList -> carFromList.getId() == id).findFirst();
//            if (firstCar.isPresent()) {
//                firstCar.get().setColor(color);
//                return new ResponseEntity(HttpStatus.OK);
//            }
//            return new ResponseEntity(HttpStatus.NOT_FOUND);
//        }
//
//        @PostMapping
//        public ResponseEntity addCar(@RequestBody Car car) {
//            boolean add = carList.add(car);
//            if (add) {
//                return new ResponseEntity(HttpStatus.CREATED);
//            }
//            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//
//        public ResponseEntity modCar(@RequestBody Car newCar) {
//            Optional<Car> first = carList.stream().filter(car -> car.getId() == newCar.getId()).findFirst();
//            if (first.isPresent()) {
//                carList.remove(first.get());
//                carList.add(newCar);
//
//                return new ResponseEntity(HttpStatus.OK);
//            }
//
//            return new ResponseEntity(HttpStatus.NOT_FOUND);
//        }
//
//        @DeleteMapping("/{id}")
//        public ResponseEntity removeCar(@PathVariable String id) {
//            Optional<Car> first = carList.stream().filter(car -> car.getId() == id).findFirst();
//            if (first.isPresent()) {
//                carList.remove(first.get());
//                return new ResponseEntity<>(first.get(), HttpStatus.OK);
//            }
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//
//        }
//
//    }





