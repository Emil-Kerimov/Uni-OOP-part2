import javax.swing.*;
import java.awt.*;

public class SliderFrame extends JFrame {
    public SliderFrame(){
        NorthPanel northPanel = new NorthPanel();
        TextColorPanel textColorPanel = new TextColorPanel(northPanel);
        ImagePanel imagePanel = new ImagePanel();
        ButtonPanel buttonPanel = new ButtonPanel(northPanel, imagePanel);
        BackgroundColorPanel backgroundColorPanel = new BackgroundColorPanel(this);

        setSize(600, 600);
        setLayout(new BorderLayout());

        add(northPanel, BorderLayout.NORTH);
        add(textColorPanel,BorderLayout.EAST);
        add(imagePanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
        add(backgroundColorPanel,BorderLayout.WEST);
    }
}
