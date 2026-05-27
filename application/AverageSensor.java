package application;

import java.util.ArrayList;
import java.util.Random;
import java.util.List;

public class AverageSensor implements Sensor {

    private List<Sensor> sensors;
    private List<Integer> reading;

    public AverageSensor() {
        this.sensors = new ArrayList<>();
        this.reading =  new ArrayList<>();
    }

    public void addSensor(Sensor toAdd) {
        this.sensors.add(toAdd);
    }
    @Override
    public boolean isOn() {
        boolean ison = true;
        for (Sensor sensor : sensors) {
            if (!sensor.isOn()) {
                ison = false;
            }
        }
        return ison;
    }
    @Override
    public void setOn() {
        for (Sensor sensor : sensors) {
            sensor.setOn();
        }
    }
    @Override
    public void setOff() {
        for (Sensor sensor : sensors) {
            sensor.setOff();
        }
    }
    @Override
    public int read() {
        int average = 0;
        if (sensors.isEmpty() || this.isOn() == false) {
            throw new IllegalStateException();
        } else {
            int sum = 0;
            int total = 0;
            for (Sensor sensor : sensors) {
                sum++;
                total += sensor.read();
                average = total / sum;
            }
        }
        this.reading.add(average);
        return average;
    }
    public List<Integer> readings(){
        return this.reading;
    }
}
