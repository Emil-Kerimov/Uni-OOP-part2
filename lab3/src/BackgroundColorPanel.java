import javax.swing.*;
import java.awt.*;

public class BackgroundColorPanel extends JPanel {
    private JFrame parentFrame;
    public BackgroundColorPanel(JFrame parentFrame){
        this.parentFrame = parentFrame;

        setLayout(new GridLayout(3,1));

        JCheckBox redBox = new JCheckBox("Red");
        JCheckBox greenBox = new JCheckBox("Green");
        JCheckBox blueBox = new JCheckBox("Blue");

        redBox.addItemListener(e -> changeBackground(redBox,greenBox,blueBox));
        greenBox.addItemListener(e -> changeBackground(redBox,greenBox,blueBox));
        blueBox.addItemListener(e -> changeBackground(redBox,greenBox,blueBox));

        redBox.setOpaque(false);
        greenBox.setOpaque(false);
        blueBox.setOpaque(false);

        add(redBox);
        add(greenBox);
        add(blueBox);
    }

    public void changeBackground(JCheckBox redBox, JCheckBox greenBox, JCheckBox blueBox){
        int r = redBox.isSelected() ? 255 : 0;
        int g = greenBox.isSelected() ? 255 : 0;
        int b = blueBox.isSelected() ? 255 : 0;

        for(Component c : parentFrame.getContentPane().getComponents()){
            c.setBackground(new Color(r,g,b));
        }
    }

}
