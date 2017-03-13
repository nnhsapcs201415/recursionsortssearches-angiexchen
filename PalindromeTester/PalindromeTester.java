import java.util.Scanner;

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
   public static void main (String[] args)
   {
      String str, another = "y";
      int left, right;
      Scanner s = new Scanner(System.in);

      do
      {
         System.out.println ("Enter a potential palindrome:");
         str = s.nextLine();

         if(isPalindrome(str))
         {
             System.out.println("That string IS a palindrome.");
         }
         else
         {
            System.out.println("that string is NOT a paldindrome.");
         }

         System.out.println();
         System.out.print ("Test another palindrome (y/n)? ");
         another = s.nextLine();
      }
      while (another.equalsIgnoreCase("y")); // allows y or Y
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
