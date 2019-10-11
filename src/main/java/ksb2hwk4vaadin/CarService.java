//package ksb2hwk4vaadin;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//import java.util.stream.Collectors;
//
//@Service
//public class CarService {
//
//    private CarRepository carRepository;
//
//    @Autowired
//    public CarService(CarRepository carRepository) {
//        this.carRepository = carRepository;
//    }
//
//    public List<Car> getCars() {
//        List<Car> carList = carRepository.getCarList();
//        return carList;
//    }
//
//    public Optional<Car> getCarById(String id) {
//        List<Car> carList = getCars();
//        Optional<Car> first = carList.stream().filter(car -> car.getId() == id).findFirst();
//        return first;
//    }
//
//    public List<Car> getCarsByColor(String color) {
//        List<Car> carColorList = getCars().stream().filter(car -> car.getColor().equals(color)).collect(Collectors.toList());
//        return carColorList;
//    }
//
//    public boolean addNewCar(Car newCar) {
//        boolean isAdded = getCars().add(newCar);
//        return isAdded;
//    }
//
//    public boolean modifyCar(Car modCar) {
//        Optional<Car> optionalCarById = getCarById(modCar.getId());
//        if (optionalCarById.isPresent()) {
//            getCars().remove(optionalCarById.get());
//            return true;
//        }
//        return false;
//    }
//
//    public boolean modifyCarByField(Car car) {
//        Optional<Car> optionalCarById = getCarById(car.getId());
//        if (optionalCarById.isPresent()) {
//            Car carById = optionalCarById.get();
//            if (null != car.getMark()) {
//                carById.setMark(car.getMark());
//            }
//            if (null != car.getColor()) {
//                carById.setColor(car.getColor());
//            }
//            if (null != car.getModel()) {
//                carById.setModel(car.getModel());
//            }
//            return true;
//        }
//        return false;
//    }
//
//    public boolean removeCar(String id) {
//        Optional<Car> first = getCarById(id);
//        if (first.isPresent()) {
//            boolean isDeleted = getCars().remove(first.get());
//            return isDeleted;
//        }
//        return false;
//    }
////public boolean removeCar(String id) {
////    removeCar(id);
////    return true;
////}
//}
