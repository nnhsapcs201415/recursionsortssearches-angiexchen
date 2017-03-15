import java.util.*;

public class ListMethods
{
    public static ArrayList<Integer> makeList(int n)
    {
        ArrayList<Integer> tempList = null;
        if (n <= 0)  // The smallest list we can make
        {
            return new ArrayList<Integer>();
        }
        else        // All other size lists are created here
        {
            tempList = new ArrayList<Integer>();
            tempList = makeList(n-1);
            tempList.add(n);
        }
        return tempList;
    }

    public static ArrayList<Integer> deepClone(ArrayList<Integer> tList)
    {
        ArrayList<Integer> list = new ArrayList<Integer>(); 
        for (Integer i : tList)
        {
            list.add(new Integer(i));
        }
        return list;
    }

    public static ArrayList<Integer> reverseList(ArrayList<Integer> list)
    {
        ArrayList<Integer> clonedList = ListMethods.deepClone(list);
        if (list.size() == 1 || list.size() == 0)
        {
            return clonedList;
        }
        else
        {
            int a = clonedList.remove(0);
            clonedList = reverseList(clonedList);
            clonedList.add(a);
        }
        return clonedList;
    }
}
