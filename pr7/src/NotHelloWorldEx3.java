import javax.swing.*;
import java.awt.*;

public class NotHelloWorldEx3 {
    public static void main(String[] args){
        EventQueue.invokeLater(() -> {
            JFrame frame = new NotHelloWorldFrame();
            frame.setTitle("Not a hello world");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}
class NotHelloWorldFrame extends JFrame{
    public NotHelloWorldFrame(){
        add(new NotHelloWorldComponent());
        pack();
    }
}
class NotHelloWorldComponent extends JComponent{
    public static final int MSG_X = 75;
    public static final int MSG_Y = 75;

    public static final int DEFAULT_WIDTH = 300;
    public static final int DEFAULT_HEIGHT = 200;

    public void paintComponent(Graphics g){
        g.drawString("Not a hello, world program",MSG_X, MSG_Y);
    }
    public Dimension getPreferredSize(){
        return new Dimension(DEFAULT_WIDTH,DEFAULT_HEIGHT);
    }

}