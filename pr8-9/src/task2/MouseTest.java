package task2;

import javax.swing.*;
import java.awt.*;

public class MouseTest {
    public static void main(String[] args){
        EventQueue.invokeLater(() -> {
            JFrame frame = new MouseAdvFrame();
            frame.setTitle("MouseTestAdvanced");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}
