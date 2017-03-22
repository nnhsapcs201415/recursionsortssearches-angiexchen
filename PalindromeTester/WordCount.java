import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * Write a description of class WordCount here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WordCount
{
    public static void main(String[] args) throws FileNotFoundException
    {
        String fileName = "palindrome.txt";
        File inputFile = new File(fileName);
        Scanner s = new Scanner(inputFile);
        int wc = 0;
        
        while (s.hasNext())
        {
            wc ++;
        }
        s.close();
        
        System.out.println("Word Count: " + wc);
    }

}
