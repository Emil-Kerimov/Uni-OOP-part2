package example1Calculator;

import javax.swing.*;

public class CalculatorFrame extends JFrame {
    public CalculatorFrame(){
        add(new CalculatorPanel());
        pack();
    }
}
