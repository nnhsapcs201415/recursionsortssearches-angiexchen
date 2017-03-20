import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Write a description of class TreeViewer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TreeViewer
{
    private final int WIDTH = 400;
    private final int HEIGHT = 500;

    private final int MIN = 1, MAX = 9;
    
    private TreePanel drawing;
    //private JPanel panel; 
    private JFrame frame;

    public static void main(String[] args)
    {
        TreeViewer viewer = new TreeViewer();
    }
    
    /**
     * Default constructor for objects of class TreeViewer
     */
    public TreeViewer()
    {
        drawing = new TreePanel();
        frame = new JFrame();
        frame.add(drawing);
        frame.setVisible(true);
    }
}
