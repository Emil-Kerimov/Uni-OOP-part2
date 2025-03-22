package task2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

public class MouseAdvComponent extends JComponent {
    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 200;
    private static final int SIDELENGTH = 10;
    private ArrayList<AdvancedSquare> squares;
    private AdvancedSquare current; // contains mouse cursor
    public MouseAdvComponent(){
        squares = new ArrayList<>();
        current = null;

        addMouseListener(new MouseHandler());
        addMouseMotionListener(new MouseMotionHandler());
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(DEFAULT_WIDTH,DEFAULT_HEIGHT);
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        for (AdvancedSquare r : squares){
            g2.setPaint(r.getColor());
            g2.fill(r);
            g2.setPaint(Color.BLACK);
            g2.draw(r);
        }
    }
    public AdvancedSquare find(Point2D point){
        for (AdvancedSquare r : squares){
            if(r.contains(point)) return r;
        }
        return null;
    }
    public void add(Point2D p){
        double x = p.getX();
        double y = p.getY();

        current = new AdvancedSquare(x-SIDELENGTH/2, y-SIDELENGTH/2, SIDELENGTH);
        squares.add(current);
        repaint();
    }
    public void remove(Rectangle2D r){
        if(r == null) return;
        if( r == current) current=null;
        squares.remove(r);
        repaint();
    }
    private class MouseHandler extends MouseAdapter{
        public void mousePressed(MouseEvent event){
            current = find(event.getPoint());
            if(current == null) add(event.getPoint());
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            current = find(e.getPoint());
            if (current != null && e.getClickCount() >= 2) {
                current.switchPhase();
                if(current.isNearDeath()){
                    remove(current);
                }
                repaint();
            }
        }
    }
    private class MouseMotionHandler implements MouseMotionListener{
        @Override
        public void mouseDragged(MouseEvent e) {
            if (current != null){
                int x = e.getX();
                int y = e.getY();

                current.setFrame(x-SIDELENGTH/2,y-SIDELENGTH/2,SIDELENGTH,SIDELENGTH);
                repaint();
            }
        }

        @Override
        public void mouseMoved(MouseEvent e) {
            if(find(e.getPoint()) == null) setCursor(Cursor.getDefaultCursor());
            else setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
        }
    }
}
