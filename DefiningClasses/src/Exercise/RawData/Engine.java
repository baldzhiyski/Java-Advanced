package Exercise.RawData;

public class Engine {
    private int power;
    private int speed;

    public Engine(int speed,int power) {
        setPower(power);
        setSpeed(speed);
    }

    public int getPower() {
        return power;
    }

    public int getSpeed() {
        return speed;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
}
