import javax.swing.*;
import java.awt.*;

public class SizedFrameTestEx2 {
    public static void main(String[] args){
        EventQueue.invokeLater(() -> {
            JFrame frame = new SizedFrame();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}
class SizedFrame extends JFrame{
    public SizedFrame(){
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int screenHeight = screenSize.height;
        int screenWidth = screenSize.width;

        setSize(screenWidth/2, screenHeight/2);
        setLocationByPlatform(true);

        Image img = new ImageIcon("icon.gif").getImage();
        setIconImage(img);
    }
}