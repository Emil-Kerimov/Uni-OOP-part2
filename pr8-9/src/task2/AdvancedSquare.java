package task2;

import java.awt.*;
import java.awt.geom.Rectangle2D;

public class AdvancedSquare extends Rectangle2D.Double {
    enum Phase{FIRST,SECOND }
    private Phase phase;
    public AdvancedSquare(double x, double y, double side){
        super(x, y, side, side);
        phase= Phase.FIRST;
    }
    public Phase getPhase(){
        return phase;
    }
    public void switchPhase(){
        if (getPhase() == Phase.FIRST){
            phase = Phase.SECOND;
            setFrame(getX(),getY(),12,12);
        }
        else {
            phase = null;
        }
    }
    public boolean isNearDeath(){
        return phase == null;
    }
    public Color getColor(){
        return (phase == Phase.FIRST) ? Color.BLUE : Color.RED;
    }
}
