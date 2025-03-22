import javax.swing.*;
import java.awt.*;

public class ImagePanel extends JPanel {
    private JLabel imageLabel;
    public ImagePanel(){
        imageLabel = new JLabel();
        add(imageLabel);
    }

    public void setImage(String path){
        imageLabel.setIcon(new ImageIcon(path));
    }

    public void setImage(Image read) {
        imageLabel.setIcon(new ImageIcon(read));
    }
}
