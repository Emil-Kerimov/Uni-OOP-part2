package example6slider;

import javax.swing.*;
import java.awt.*;

public class SliderTest
{
    public static void main(String[] args)
    {
        EventQueue.invokeLater(() -> {
            SliderFrame frame = new SliderFrame();
            frame.setTitle("SliderTest");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}