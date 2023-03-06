package task3;

public class Transmission {
    @Save
    private String type;
    @Save
    private int amountOfSpeed;

    public Transmission(String type, int amountOfSpeed) {
        this.type = type;
        this.amountOfSpeed = amountOfSpeed;
    }

    public Transmission() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getAmountOfSpeed() {
        return amountOfSpeed;
    }

    public void setAmountOfSpeed(int amountOfSpeed) {
        this.amountOfSpeed = amountOfSpeed;
    }
}
