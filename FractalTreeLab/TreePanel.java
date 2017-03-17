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

    private final int TOPX = 200, TOPY = 200;
    private final int BOTX = 200, BOTY = 230;
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

    public void drawFractal(double length, double x1, double y1, double angle)
    {
        if (length <= 5)
        {
            Line2D.Double line = new Line2D.Double(length, x1, y1, angle); 
        }
        else
        {
            double dX, dY, x2, y2;
            
            dX = Math.sin(angle)*length;
            dY = Math.cos(angle)*length;
            
            x2 = x1 + dX;
            y2 = y1 - dY;

            x2 = x1 - dX;
            y2 = y1 - dY;

            double newLength = length/10;
            double newAngle = angle+branchingAngle;
        }
    }

    public void paintComponent (Graphics page)
    {
        super.paintComponent (page);

        page.setColor (Color.green);

        drawFractal (TOPX, TOPY);
     
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
