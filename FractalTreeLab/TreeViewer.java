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
    /**width of frame*/
    private final int WIDTH = 400;
    /**height of frame*/
    private final int HEIGHT = 500;
    /**declares instance of tree*/
    private TreePanel drawing;
    /**declares frame*/
    private JFrame frame;

    /**
     * Executes the TreeViewer class. 
     */
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
        frame.setSize(WIDTH, HEIGHT);
        frame.setVisible(true);
    }
}
