import javax.swing.*;
import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

public class FontTestEx5 {
    public static void main(String[] args){
        EventQueue.invokeLater(() -> {
            JFrame frame = new FontFrame();
            frame.setTitle("FontTest");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}
class FontFrame extends JFrame{
    public FontFrame(){
        add(new FontComponent());
        pack();
    }

}
class FontComponent extends JComponent{
    public final static int DEFAULT_WIDTH = 300;
    public final static int DEFAULT_HEIGHT = 200;

    public void paintComponent(Graphics g){
        Graphics2D g2 = (Graphics2D) g;

        String msg = "Hello world";

        Font font = new Font("Serif", Font.BOLD, 36);
        g2.setFont(font);

        FontRenderContext context = g2.getFontRenderContext();
        Rectangle2D bounds = font.getStringBounds(msg, context);

        double x = (getWidth() - bounds.getWidth()) / 2;
        double y = (getHeight() - bounds.getHeight()) /2;

        double ascent = -bounds.getY();
        double baseY = y+ascent;

        g2.drawString(msg, (int) x, (int) baseY);

        g2.setPaint(Color.LIGHT_GRAY);

        g2.draw(new Line2D.Double(x, baseY, x+bounds.getWidth(), baseY));

        Rectangle2D rect = new Rectangle2D.Double(x,y, bounds.getWidth(), bounds.getHeight());
        g2.draw(rect);
    }
    public Dimension getPreferredSize(){
        return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }
}