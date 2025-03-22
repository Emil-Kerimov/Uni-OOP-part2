package org.example;

public class Parallelepiped extends Shape{
    private double s;
    private double h;
    public Parallelepiped(double s, double h) {
        super();
        this.s = s;
        this.h = h;
    }

    public double getS() {
        return s;
    }

    public double getH() {
        return h;
    }

    @Override
    public double getVolume() {
        return getH()*getS();
    }

    @Override
    public String toString() {
        return "Parallelepiped volume:  " + getVolume() + "\n";
    }
}
