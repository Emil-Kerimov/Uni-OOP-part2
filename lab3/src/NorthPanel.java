import javax.swing.*;
import java.awt.*;

public class NorthPanel extends JPanel {
    private JLabel lab;
    public NorthPanel() {
        lab = new JLabel("Hello world!", JLabel.CENTER);
        lab.setFont(new Font("Arial", Font.BOLD, 20));
        add(lab);
    }

    public void setText(String text){
        lab.setText(text);
    }

    public void setTextColor(Color color){
        lab.setForeground(color);
    }
}
