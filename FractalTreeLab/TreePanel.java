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
    final int PANEL_WIDTH = 1000;
    private final int PANEL_HEIGHT = 1000;
    private final double SCALE = 0.75;

    private final double TOPX = 750, TOPY = 650;
    private int current = 0; 
    double branchingAngle = Math.PI/10;
    private final double LENGTH = 250;
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
                repaint();
                Line2D.Double stem = new Line2D.Double(TOPX, TOPY, TOPX, TOPY+LENGTH);
                g2.draw(stem);
                repaint();
            }
            else
            {
                double dX, dY, x2, y2;

                dX = Math.sin(angle)*length;
                dY = Math.cos(angle)*length;

                x2 = x1 + dX;
                y2 = y1 - dY;

                double newLength = length*SCALE;
                Line2D.Double line = new Line2D.Double(x1, y1, x2, y2);
                g2.draw(line);
                repaint();
                
                drawFractal(newLength, x2, y2, angle+branchingAngle, g2);
                drawFractal(newLength, x2, y2, angle-branchingAngle, g2); //ok
        }
    }

    public void paintComponent (Graphics page)
    {
        super.paintComponent (page);
        Graphics2D g2 = (Graphics2D) page;
        page.setColor (Color.blue);
        drawFractal (LENGTH, TOPX, TOPY, branchingAngle, g2);
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
