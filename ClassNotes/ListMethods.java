import java.util.*;

public class ListMethods
{
   public static ArrayList<Integer> makeList(int n)
   {
      ArrayList<Integer> tempList = null;
      if (n <= 0)  // The smallest list we can make
      {
          return tempList;
      }
      else        // All other size lists are created here
      {
          tempList = new ArrayList<Integer>();
          tempList.add(n);
          int m = n-1;
          makeList(m);
      }
      return tempList;
   }
 
}
