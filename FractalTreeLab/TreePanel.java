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

    private final double TOPX = 500, TOPY = 500;
    private int current = 0; //current order
    double branchingAngle = Math.PI/10;
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
        while(current == 0)
        {
            Line2D.Double first = new Line2D.Double(TOPX, TOPY, TOPX, TOPY+length);
            g2.draw(first);
            repaint();
            current ++; 
        }
        
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
            
            double newLength = length*0.75;
            Line2D.Double line = new Line2D.Double(x1, y1, x2, y2);
            g2.draw(line);
            
            drawFractal(newLength, x2, y2, angle+branchingAngle, g2);
            drawFractal(newLength, x2, y2, angle-branchingAngle, g2);
            
            repaint();
        }
    }

    public void paintComponent (Graphics page)
    {
        super.paintComponent (page);
        Graphics2D g2 = (Graphics2D) page;
        page.setColor (Color.blue);
        drawFractal (100, TOPX, TOPY, Math.PI/6, g2);
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
