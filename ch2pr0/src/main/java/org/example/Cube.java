package org.example;

public class Cube extends Shape{
    private double a;
    public Cube(double a){
        super();
        this.a = a;
    }
    @Override
    public double getVolume() {
        return Math.pow(getA(), 3);
    }

    public double getA() {
        return a;
    }

    @Override
    public String toString() {
        return "Cube volume:  " + getVolume() + "\n";
    }
}
