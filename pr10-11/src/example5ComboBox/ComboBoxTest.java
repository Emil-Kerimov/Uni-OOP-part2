package example5ComboBox;

import javax.swing.*;
import java.awt.*;

public class ComboBoxTest {
    public static void main(String[] args){
        EventQueue.invokeLater(() ->{
            JFrame frame = new ComboBoxFrame();
            frame.setTitle("ComboBox");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}
