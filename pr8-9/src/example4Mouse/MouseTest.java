package example4Mouse;

import javax.swing.*;
import java.awt.*;

public class MouseTest {
    public static void main(String[] args){
        EventQueue.invokeLater(() -> {
            JFrame frame = new MouseFrame();
            frame.setTitle("MouseTest");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}
