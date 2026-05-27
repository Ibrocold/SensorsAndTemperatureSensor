
package application;


public class StandardSensor implements Sensor{
    
    private int sensor;
    
    public StandardSensor(int sensor){
       this.sensor = sensor;
       
    }
    @Override
    public boolean isOn(){
        return true;
    }
    @Override
    public void setOn(){
    }
    @Override
    public void setOff(){
    }
    @Override
    public int read(){
        if(!this.isOn()){
            throw new IllegalStateException();
        }
       return this.sensor;     
    }
}
