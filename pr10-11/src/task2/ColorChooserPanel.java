package task2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ColorChooserPanel extends JPanel {
    private JButton modelessButton;
    private JButton immediate;
    public ColorChooserPanel(){
        JButton modalButton = new JButton("Modal");
        modalButton.addActionListener(new ModalListener());
        add(modalButton);

        modelessButton = new JButton("Modeless button");
        modelessButton.addActionListener(new ModelessListener());
        add(modelessButton);

        immediate = new JButton("Immediate font");
        immediate.addActionListener(new ImmediateListener());
        add(immediate);
    }

    private class ModalListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            Color defaultColor = getBackground();
            Color selected = JColorChooser.showDialog(ColorChooserPanel.this, "set background", defaultColor);
            if(selected != null) setBackground(selected);
        }
    }

    private class ModelessListener implements ActionListener{
        private JDialog dialog;
        private JColorChooser chooser;
        public ModelessListener(){
            chooser = new JColorChooser();
            dialog = JColorChooser.createDialog(ColorChooserPanel.this, "Background color", false,
                    chooser, e -> modelessButton.setBackground(chooser.getColor()), null);
        }

        public void actionPerformed(ActionEvent e){
            chooser.setColor(getBackground());
            dialog.setVisible(true);
        }
    }

    private class ImmediateListener implements ActionListener{
        private JDialog dialog;
        private JColorChooser chooser;
        public ImmediateListener(){
            chooser = new JColorChooser();
            chooser.getSelectionModel().addChangeListener(e -> immediate.setForeground(chooser.getColor()));

            dialog = new JDialog((Frame) null, false);
            dialog.add(chooser);
            dialog.pack();
        }

        public void actionPerformed(ActionEvent e){
            chooser.setColor(getBackground());
            dialog.setVisible(true);
        }
    }
}
