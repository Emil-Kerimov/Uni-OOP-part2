import javax.swing.*;
import java.awt.*;

public class TextColorPanel extends JPanel {
    private NorthPanel textPanel;
    public TextColorPanel(NorthPanel textPanel){
        this.textPanel = textPanel;

        JRadioButton red = new JRadioButton("Red");
        JRadioButton green = new JRadioButton("Green");
        JRadioButton black = new JRadioButton("Black");

        ButtonGroup buttonGroup = new ButtonGroup();

        buttonGroup.add(red);
        buttonGroup.add(green);
        buttonGroup.add(black);

        red.addActionListener(e -> textPanel.setTextColor(Color.RED));
        green.addActionListener(e -> textPanel.setTextColor(Color.GREEN));
        black.addActionListener(e -> textPanel.setTextColor(Color.BLACK));

        red.setOpaque(false);
        green.setOpaque(false);
        black.setOpaque(false);


        setLayout(new GridLayout(3, 1));
        add(red);
        add(green);
        add(black);

    }
}
