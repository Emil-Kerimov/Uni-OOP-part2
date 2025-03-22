package org.example;

public class TruncCone extends Shape{
    private double r;
    private double h;

    public TruncCone(double r, double h) {
        super();
        this.r = r;
        this.h = h;
    }

    @Override
    public double getVolume() {
        return (double) 1 /3*Math.PI*Math.pow(getR(), 2)*getH();
    }

    public double getR() {
        return r;
    }

    public double getH() {
        return h;
    }
    @Override
    public String toString() {
        return "TruncCone volume:  " + getVolume() + "\n";
    }
}
