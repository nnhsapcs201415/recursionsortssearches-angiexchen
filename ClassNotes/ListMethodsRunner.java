
import java.util.ArrayList;

public class ListMethodsRunner
{
   public static void main(String[] args)
   {
      ArrayList<Integer> tempList = ListMethods.makeList(10);
      if (tempList.size() == 0)
      {
          System.out.println("The list is empty");
      }
      else
      {
         for (Integer i : tempList)
         {
            System.out.println(i);
         }
      }
      
      ArrayList<Integer> reversedList = ListMethods.reverseList(tempList);
      if (reversedList.size() == 0)
      {
          System.out.println("The list is empty");
      }
      else
      {
         for (Integer i : reversedList)
         {
            System.out.println(i);
         }
      }
   }
}