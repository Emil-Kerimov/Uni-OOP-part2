package example12FileChooser;

import javax.swing.*;
import java.awt.*;

public class FileChooserTest {
    public static void main(String[] args)
    {
        EventQueue.invokeLater(() -> {
            JFrame frame = new ImageViewerFrame();
            frame.setTitle("FileChooserTest");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}