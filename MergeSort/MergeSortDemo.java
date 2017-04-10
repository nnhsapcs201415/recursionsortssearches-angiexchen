import java.util.Arrays;

/**
   This program demonstrates the merge sort algorithm by
   sorting an array that is filled with random numbers.
*/
public class MergeSortDemo
{  
   public static void main(String[] args)
   {  
      //print array of integers
       
      int[] a = ArrayUtil.randomIntArray(20, 100);
      System.out.println(Arrays.toString(a));
      MergeSorter.sort(a);
      System.out.println(Arrays.toString(a));
      
      //print array of strings
      String[] s = ArrayUtil.randomStringArray(20,3);
      for (int i = 0; i < 20; i++)
      {
          System.out.print(s[i] + " ");
      }
      MergeSorter.sortString(s);
      System.out.println("");
      for (int i = 0; i < 20; i++)
      {
          System.out.print(s[i] + " ");
        }
   }
}

