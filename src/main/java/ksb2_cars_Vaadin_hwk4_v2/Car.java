package ksb2_cars_Vaadin_hwk4_v2;

public class Car {
    private long id;
    private CarMark mark;
    private String model;
    private CarColour colour;

    public Car(long id, CarMark mark, String model, CarColour colour) {
        this.id = id;
        this.mark = mark;
        this.model = model;
        this.colour = colour;
    }

    public Car() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public CarMark getMark() {
        return mark;
    }

    public void setMark(CarMark mark) {
        this.mark = mark;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public CarColour getColour() {
        return colour;
    }

    public void setColour(CarColour colour) {
        this.colour = colour;
    }
}
