

/**
 * Write a recursive method String reverse(String text) that reverses a string. 
 * 
 * @author axchen
 * @version 06 March 2017
 */
public class StringReverse
{
    public static String reverse(String text)
    {
        // Requirement #1: Terminating Condition
        if(text.length() <= 1)
        {
            return text;
        }
        
        // Requirement #2: Recurse on a simpler version of the problem
        char c = text.charAt(0);
        String rest = text.substring(1);
        String reverseText = reverse(rest) + c;
        return reverseText;
    }
    
    public static String reverseIter(String text)
    {
        if(text.length() <= 1)
        {
            return text;
        }
        
        String reverseText = "";
        for(int i = text.length()-1; i >= 0; i--)
        {
            char c = text.charAt(i);
            reverseText += c;
        }
        
        return reverseText;
    }
}
