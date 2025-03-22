package org.example;

public class Cylinder extends Shape{
    private double h;
    private double r;
    public Cylinder(double h, double r) {
        super();
        this.h = h;
        this.r = r;
    }

    @Override
    public double getVolume() {
        return Math.PI*getR()*getR()*getH();
    }

    public double getH() {
        return h;
    }

    public double getR() {
        return r;
    }
    @Override
    public String toString() {
        return "Cylinder volume:  " + getVolume() + "\n";
    }
}
