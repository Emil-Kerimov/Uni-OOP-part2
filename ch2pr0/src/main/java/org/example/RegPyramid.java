package org.example;

public class RegPyramid extends Shape {
    private double s;
    private double h;

    public RegPyramid(double s, double h) {
        super();
        this.s = s;
        this.h = h;
    }

    @Override
    public double getVolume() {
        return (double) 1 /3*getS()*getH();
    }

    public double getS() {
        return s;
    }

    public double getH() {
        return h;
    }

    @Override
    public String toString() {
        return "RegPyramid volume:  " + getVolume() + "\n";
    }
}
