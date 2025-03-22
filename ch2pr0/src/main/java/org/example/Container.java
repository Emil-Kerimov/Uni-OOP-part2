package org.example;

import java.util.ArrayList;

public class Container {
    private double capacity; // the amount of a liquid that a tank can hold
    private double volume; // the amount of a liquid that we have in a tank right now
    private ArrayList<Shape> figures;
    public Container(double capacity){
        this.capacity = capacity;
        this.volume = 0;
        figures = new ArrayList<>();
    }

    public double getCapacity() {
        return capacity;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) throws OutOfTankVolumeLimitException {
        if(volume <= getCapacity()){
            this.volume = volume;
        } else throw new OutOfTankVolumeLimitException("volume cant be greater than capacity");
    }

    public void fit(Shape f) throws OutOfTankVolumeLimitException {
        if((f.getVolume() + getVolume()) <= getCapacity()){
            figures.add(f);
            setVolume(f.getVolume() + getVolume());
            System.out.println("success");
        }
        else throw new OutOfTankVolumeLimitException("the figure will not fit into the tank");
    }
    public void display(){
        System.out.println("container info:");
        for( Shape f : figures){
            System.out.println("figure: "+ f.toString());
        }
    }
}
