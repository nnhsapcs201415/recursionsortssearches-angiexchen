import java.awt.*;
import javax.swing.JPanel;
import java.awt.geom.Line2D;

/**
 * Write a description of class TreePanel here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TreePanel extends JPanel
{
    private final int PANEL_WIDTH = 400;
    private final int PANEL_HEIGHT = 400;

    private final double SQ = Math.sqrt(3.0) / 2;

    private final double TOPX = 200, TOPY = 200;
    private final double BOTX = 200, BOTY = 230;
    private int current; //current order
    double branchingAngle = Math.PI/6;
    /**
     * Default constructor for objects of class TreePanel
     */
    public TreePanel()
    {
        setBackground(Color.black);
        setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
    }

    public void drawFractal(double length, double x1, double y1, double angle, Graphics2D g2)
    {
        if (length <= 5)
        {
            Line2D.Double line = new Line2D.Double(length, x1, y1, angle); 
            g2.draw(line);
        }
        else
        {
            double dX, dY, x2, y2, x3, y3;
            
            dX = Math.sin(angle)*length;
            dY = Math.cos(angle)*length;
            
            x2 = x1 + dX;
            y2 = y1 - dY;
            
            double newLength = length/10;

            drawFractal(newLength, x2, y2, angle+branchingAngle, g2);
            // draw? repaint();
            drawFractal(newLength, x2, y2, angle-branchingAngle, g2);
            // g2,draw?  repaint();
        }
    }

    public void paintComponent (Graphics page)
    {
        super.paintComponent (page);
        Graphics2D g2 = (Graphics2D) page;
        page.setColor (Color.green);

        drawFractal (50, TOPX, TOPY, Math.PI/6, g2);
        repaint();
    }

    public void setOrder (int order)
    {
        current = order;
    }

    public int getOrder ()
    {
        return current;
    }

}
