package task3;

public class Car {
    @Save
    private String brand;
    @Save
    private String model;
    private String engineType;

    private int price;
    @Save
    private Transmission transmission;
    @Save
    private boolean isAvailable;

    public Car(Transmission transmission) {
        this.brand = "Audi";
        this.model = "Q8";
        this.transmission = transmission;
    }
    public Car(){

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

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public Transmission getTransmission() {
        return transmission;
    }

    public void setTransmission(Transmission transmission) {
        this.transmission = transmission;
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", engineType='" + engineType + '\'' +
                ", price=" + price +
                ", transmission=" + transmission +
                ", isAvailable=" + isAvailable +
                '}';
    }
}
