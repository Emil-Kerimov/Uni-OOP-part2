package example1Calculator;

import javax.swing.*;
import java.awt.*;

public class CalculatorApp {
    public static void main(String[] args){
        EventQueue.invokeLater(() -> {
            JFrame frame = new CalculatorFrame();
            frame.setTitle("Calculator");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}
