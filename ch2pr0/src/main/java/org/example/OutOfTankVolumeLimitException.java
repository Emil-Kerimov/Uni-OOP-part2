package org.example;

public class OutOfTankVolumeLimitException extends Exception{
    public OutOfTankVolumeLimitException(String message) {
        super(message);
    }
}
