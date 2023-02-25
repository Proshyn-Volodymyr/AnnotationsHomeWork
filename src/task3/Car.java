package task3;

public class Car {
    @Save
    private String brand;
    @Save
    private String model;
    private String engineType;
    @Save
    private int price;
    @Save
    private boolean isAvailable;

    public Car() {
        this.brand = "Audi";
        this.model = "Q8";
        this.engineType = "V6";
        this.price = 80000;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getEngineType() {
        return engineType;
    }

    public void setEngineType(String engineType) {
        this.engineType = engineType;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
