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
    /**panel width*/
    final int PANEL_WIDTH = 1000;
    
    /**panel height*/
    private final int PANEL_HEIGHT = 1000;
    
    /**scaling size*/
    private final double SCALE = 0.75;
    
    /**coordinates of first point*/
    private final double TOPX = 750, TOPY = 850;
    
    /**branching angle*/
    double branchingAngle = Math.PI/18;
    
    /**starting length*/
    private final double LENGTH = 200;
    
    /**starting color*/
    private Color COLOR = new Color(25, 33, 45);
    
    /**
     * Default constructor for objects of class TreePanel
     */
    public TreePanel()
    {
        setBackground(Color.black);
        setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
    }

    /**
     * Draws the fractal tree until the length of the branch is 2. 
     */
    public void drawFractal(Color color, double length, double x1, double y1, double angle, Graphics2D g2)
    {
            if (length <= 2)
            {}
            else
            {
                double dX, dY, x2, y2, x3, y3;

                dX = Math.sin(angle)*length;
                dY = Math.cos(angle)*length;

                x2 = x1 + dX;
                y2 = y1 - dY;
                
                x3 = x1 - dX;
                y3 = y1 - dY;

                double newLength = length*SCALE;
                Color newColor = new Color(color.getRed()+10, color.getGreen()+3, color.getBlue()+10);
                g2.setColor(newColor);
                Line2D.Double line = new Line2D.Double(x1, y1, x2, y2);
                g2.draw(line);
                
                
                drawFractal(newColor, newLength, x2, y2, angle+branchingAngle+Math.PI/10, g2);
                drawFractal(newColor, newLength, x2, y2, angle-branchingAngle-Math.PI/6, g2);
        }
    }

    /**
     * Paints the tree. 
     */
    public void paintComponent (Graphics page)
    {
        super.paintComponent (page);
        Graphics2D g2 = (Graphics2D) page;
        page.setColor (Color.green);
        drawFractal (COLOR, LENGTH, TOPX, TOPY, 0, g2);
    }

}
