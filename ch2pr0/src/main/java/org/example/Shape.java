package org.example;

abstract class Shape {
    private String name;
    public Shape(){}
    public String getName(){
        return name;
    }
    public abstract double getVolume();

}