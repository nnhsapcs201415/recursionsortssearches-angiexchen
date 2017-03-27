import java.awt.*;
import javax.swing.JPanel;
import java.awt.geom.Line2D;

/**
 * Write a description of class TreePanel here.
 * 
 * @angie chen
 * @26 march 2017
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
    private final double TOPX = 500, TOPY = 500;
    
    /**branching angle*/
    double branchingAngle = Math.PI/18;
    
    /**starting length*/
    private final double LENGTH = 120;
    
    /**starting color of tree*/
    private Color COLOR1 = new Color(155, 244, 65);
    
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
                Color newColor = new Color(color.getRed()+3, color.getGreen()-5, color.getBlue()+10);
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
        drawFractal (COLOR1, LENGTH, TOPX, TOPY, 0, g2);
        drawFractal (COLOR1, LENGTH/1.5, TOPX, TOPY, Math.PI*(2.0/3), g2);
        drawFractal (COLOR1, LENGTH/2.5, TOPX, TOPY, Math.PI*(4.0/3), g2);
        drawFractal (COLOR1, LENGTH/6, TOPX, TOPY, Math.PI/2.5, g2);
    }

}
