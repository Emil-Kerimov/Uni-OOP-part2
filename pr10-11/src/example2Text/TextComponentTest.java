package example2Text;

import javax.swing.*;
import java.awt.*;

public class TextComponentTest {
    public static void main(String[] args){
        EventQueue.invokeLater(() ->{
            JFrame frame = new TextComponentFrame();
            frame.setTitle("TextComponents");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}
