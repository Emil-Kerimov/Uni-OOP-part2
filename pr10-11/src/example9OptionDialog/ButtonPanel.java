package example9OptionDialog;

import javax.swing.*;

public class ButtonPanel extends JPanel {
    private ButtonGroup buttonGroup;
    public ButtonPanel(String title, String... options){
        setBorder(BorderFactory.createTitledBorder(BorderFactory.createEmptyBorder(),title));
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        buttonGroup = new ButtonGroup();

        for(String option : options){
            JRadioButton button = new JRadioButton(option);
            button.setActionCommand(option);
            add(button);
            buttonGroup.add(button);
            button.setSelected(option == options[0]);
        }
    }
    public String getSelection(){
        return buttonGroup.getSelection().getActionCommand();
    }
}
