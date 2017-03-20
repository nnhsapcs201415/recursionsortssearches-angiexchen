import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * Demonstrates the use of nested while loops.
 * 
 * @author Lewis/Loftus/Cocking
 */
public class PalindromeTester
{
    /**
     * Tests strings to see if they are palindromes.
     *
     */
    public static void main (String[] args) throws FileNotFoundException
    {
        String str = "";
        String fileName = "palindrome.txt"; //default file
        
        //read from the specified file
        if(args.length > 0)
        {
            fileName = args[0];
        }
        
        //open the specified file for reading; throws exception if not found
        File inputFile = new File(fileName);
        Scanner s = new Scanner(inputFile);
        s.useDelimiter("[^A-Za-z]+");
        //read every token(word) in the file and concatenate them
        while (s.hasNext())
        {
            str += s.next();
        }

        //close the Scanner object to indicate we are done reading from file.
        s.close();
        
        str = str.toLowerCase();
        
        System.out.println(str);
        
        if (isPalindrome(str))
        {
            System.out.println("That string IS a palindrome.");
        }
        else
        {
            System.out.println("that string is NOT a paldindrome.");
        }

    }
    
    public static boolean isPalindrome(String str)
    {
        //requirement 1: terminating condition
        if (str.length() <= 1)
        {
            return true;
        }

        //requirement 2: recurse with a simpler problem
        if(str.charAt(0) == str.charAt(str.length()-1))
        {
            return isPalindrome(str.substring(1, str.length()-1));
        }
        else
        {
            return false;
        }
    }
}
