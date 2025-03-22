import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class ButtonPanel extends JPanel {
    private NorthPanel textPanel;
    private ImagePanel imagePanel;
    public ButtonPanel(NorthPanel textPanel, ImagePanel imagePanel){
        this.textPanel = textPanel;
        this.imagePanel = imagePanel;

        setLayout(new GridLayout(1,4));

        JButton morningButton = new JButton("Morning");
        JButton dayButton = new JButton("Day");
        JButton eveningButton = new JButton("Evening");
        JButton nightButton = new JButton("Night");

        morningButton.addActionListener(e -> {
            textPanel.setText("Good morning");
            try{
                imagePanel.setImage(ImageIO.read(getClass().getResourceAsStream("/morning.jpg")));
            } catch (IOException ex){
                ex.printStackTrace();
            }
        });

        dayButton.addActionListener(e -> {
            textPanel.setText("Good afternoon");
            try{
                imagePanel.setImage(ImageIO.read(getClass().getResourceAsStream("/afternoon.jpg")));
            } catch (IOException ex){
                ex.printStackTrace();
            }
        });

        eveningButton.addActionListener(e -> {
            textPanel.setText("Good evening");
            try{
                imagePanel.setImage(ImageIO.read(getClass().getResourceAsStream("/evening.jpg")));
            } catch (IOException ex){
                ex.printStackTrace();
            }
        });

        nightButton.addActionListener(e -> {
            textPanel.setText("Good night");
            try{
                imagePanel.setImage(ImageIO.read(getClass().getResourceAsStream("/night.jpg")));
            } catch (IOException ex){
                ex.printStackTrace();
            }
        });

        add(morningButton);
        add(dayButton);
        add(eveningButton);
        add(nightButton);
    }
}
