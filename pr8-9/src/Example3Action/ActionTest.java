package Example3Action;

import javax.swing.*;
import java.awt.*;

public class ActionTest {
    public static void main(String[] args){
        EventQueue.invokeLater(() -> {
            JFrame frame = new ActionFrame();
            frame.setTitle("ActionFrame");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}
