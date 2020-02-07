package Java新特性.reflect反射;

import java.io.Serializable;

public class Car extends 反射 implements Serializable,Cloneable {
    private String color;
    public String desc;
    public Car(){

    }
    public Car(String color){
        this.color=color;
    }
    private Car(String a,String b){

    }
    public void run(){
        System.out.println("汽车跑！滴滴");
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    private String getDesc() {
        return desc;
    }
}
