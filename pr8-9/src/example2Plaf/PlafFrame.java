package example2Plaf;

import javax.swing.*;

public class PlafFrame extends JFrame {
    private JPanel buttonPanel;
    public PlafFrame(){
        buttonPanel = new JPanel();

        UIManager.LookAndFeelInfo[] lookAndFeelInfos = UIManager.getInstalledLookAndFeels();
        for (UIManager.LookAndFeelInfo lookAndFeelInfo : lookAndFeelInfos)
            makeButton(lookAndFeelInfo.getName(), lookAndFeelInfo.getClassName());
        add(buttonPanel);
        pack();
    }
    public void makeButton(String name, String className){
        JButton button = new JButton(name);
        buttonPanel.add(button);
        button.addActionListener(e -> {
            try {
                UIManager.setLookAndFeel(className);
                SwingUtilities.updateComponentTreeUI(this);
                pack();
            } catch (Exception ex){
                ex.printStackTrace();
            }
        });
    }
}
