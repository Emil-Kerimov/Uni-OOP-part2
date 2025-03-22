package org.example;

public class Sphere extends Shape{
    private double r;

    public Sphere(double r) {
        super();
        this.r = r;
    }

    @Override
    public double getVolume() {
        return (double) 4 /3 *Math.PI*Math.pow(getR(), 3);
    }

    public double getR() {
        return r;
    }
    @Override
    public String toString() {
        return "Sphere volume:  " + getVolume() + "\n";
    }
}
