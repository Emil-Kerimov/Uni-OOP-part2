package example4RadioButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class RadioButtonFrame extends JFrame {
    private JPanel buttonPanel;
    private ButtonGroup group;
    private JLabel label;
    private static final int DEFAULT_SIZE = 36;

    public RadioButtonFrame(){
        label = new JLabel("Font");
        label.setFont(new Font("Serif", Font.PLAIN, DEFAULT_SIZE));
        add(label,BorderLayout.CENTER);

        buttonPanel = new JPanel();
        group = new ButtonGroup();

        addRadioButton("small", 8);
        addRadioButton("medium", 12);
        addRadioButton("large", 18);
        addRadioButton("extra large", 36);

        add(buttonPanel, BorderLayout.SOUTH);
        pack();

    }
    public void addRadioButton(String name, int size){
        boolean selected = size == DEFAULT_SIZE;
        JRadioButton button = new JRadioButton(name,selected);
        group.add(button);
        buttonPanel.add(button);
        ActionListener listener = event -> {
            label.setFont(new Font("Serif", Font.PLAIN, size));
        };
        button.addActionListener(listener);
    }
}
