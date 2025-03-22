package example5ComboBox;

import example3CheckBox.CheckBoxFrame;

import javax.swing.*;
import java.awt.*;

public class ComboBoxFrame extends JFrame {
    private JComboBox<String> faceCombo;
    private JLabel label;
    private static final int DEFAULT_SIZE = 24;
    public ComboBoxFrame(){
        label = new JLabel("select");
        label.setFont(new Font("Serif", Font.PLAIN, DEFAULT_SIZE));
        add(label, BorderLayout.CENTER);

        faceCombo = new JComboBox<>();
        faceCombo.addItem("Serif");
        faceCombo.addItem("SansSerif");
        faceCombo.addItem("Monospaced");
        faceCombo.addItem("Dialog");
        faceCombo.addItem("DialogInput");
        faceCombo.addActionListener(e -> {
            label.setFont(new Font(faceCombo.getItemAt(faceCombo.getSelectedIndex()),
                    Font.PLAIN, DEFAULT_SIZE));
        });
        JPanel panel = new JPanel();
        panel.add(faceCombo);
        add(panel, BorderLayout.SOUTH);
        pack();
    }
}
