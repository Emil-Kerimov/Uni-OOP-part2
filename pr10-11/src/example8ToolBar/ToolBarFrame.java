package example8ToolBar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class ToolBarFrame extends JFrame {
    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 200;
    private JPanel panel;
    public ToolBarFrame(){
        setSize(DEFAULT_WIDTH,DEFAULT_HEIGHT);

        panel = new JPanel();
        add(panel, BorderLayout.CENTER);
        Action blueAction = new ColorAction("blue", new ImageIcon("blue-ball.gif"),Color.BLUE);
        Action yellowAction = new ColorAction("Yellow", new ImageIcon("yellow-ball.gif"),
                Color.YELLOW);
        Action redAction = new ColorAction("Red", new ImageIcon("red-ball.gif"), Color.RED);

        Action exitAction = new AbstractAction("Exit", new ImageIcon("exit.gif")) {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        };
        exitAction.putValue(Action.SHORT_DESCRIPTION, "Exit");

        JToolBar jToolBar = new JToolBar();
        jToolBar.add(blueAction);
        jToolBar.add(yellowAction);
        jToolBar.add(redAction);
        jToolBar.addSeparator();
        jToolBar.add(exitAction);
        add(jToolBar, BorderLayout.NORTH);

        JMenu menu = new JMenu("Color");
        menu.add(yellowAction);
        menu.add(blueAction);
        menu.add(redAction);
        menu.add(exitAction);
        JMenuBar menuBar = new JMenuBar();
        menuBar.add(menu);
        setJMenuBar(menuBar);
    }
    class ColorAction extends AbstractAction{
        public ColorAction(String name, Icon icon, Color c){
           putValue(Action.NAME, name);
           putValue(Action.SMALL_ICON, icon);
           putValue(Action.SHORT_DESCRIPTION,name + " background");
           putValue("Color", c);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            Color c = (Color) getValue("Color");
            panel.setBackground(c);
        }
    }
}
