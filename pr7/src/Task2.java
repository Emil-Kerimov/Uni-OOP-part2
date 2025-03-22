import javax.swing.*;
import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

public class Task2 {
    public static void main(String[] args){
        EventQueue.invokeLater(() -> {
            JFrame frame = new hybridFrame();
            frame.setTitle("hybridFrame");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}
class hybridFrame extends JFrame{
    public hybridFrame(){
        add(new hybridComponent());
        pack();
    }

}
class hybridComponent extends JComponent{
    public final static int DEFAULT_WIDTH = 300;
    public final static int DEFAULT_HEIGHT = 200;
    private Image image;
    public hybridComponent(){
        image = new ImageIcon("blue-ball.gif").getImage();
    }

    public void paintComponent(Graphics g){
        Graphics2D g2 = (Graphics2D) g;

        String msg = "Hello world";

        Font font = new Font("Serif", Font.BOLD, 36);
        g2.setFont(font);

        FontRenderContext context = g2.getFontRenderContext();
        Rectangle2D bounds = font.getStringBounds(msg, context);

        double x = (getWidth() - bounds.getWidth()) / 2;
        double y = (getHeight() - bounds.getHeight()) / 4;

        double ascent = -bounds.getY();
        double baseY = y+ascent;

        g2.drawString(msg, (int) x, (int) baseY);

        g2.setPaint(Color.LIGHT_GRAY);

        g2.draw(new Line2D.Double(x, baseY, x+bounds.getWidth(), baseY));

        Rectangle2D rect = new Rectangle2D.Double(x,y, bounds.getWidth(), bounds.getHeight());
        g2.draw(rect);

        if (image == null) return;

        int imageWidth = image.getWidth(null);
        int imageHeight = image.getHeight(null);

        g.drawImage(image, 0, getHeight() / 2, null);

        for (int i = 0; i * imageWidth < getWidth(); i++){
            for (int j = 0; j * imageHeight < getHeight(); j++){
                if (i + j > 0) g.copyArea(0,getHeight() / 2, imageWidth, imageHeight, i*imageWidth, j*imageHeight);
            }
        }
    }
    public Dimension getPreferredSize(){
        return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }
}