
package arrayremovedups;

import java.util.Arrays;
import java.util.HashSet;

/**
 *
 * @author Ksenia Studilina
 */
public class ArrayRemoveDups {
    
    public static int[] array = new int[]{8,1,2,2,3,3,5,6,7,3};

    public static int[] removeDups(int[] array)
    {
        HashSet<Integer> hs = new HashSet<Integer>();
        for(int i =0; i < array.length; i++)
        {
            hs.add(array[i]);
        }
        int[] arr = new int[hs.size()];
        
        int j= 0;
        for(var i : hs)
        {
            arr[j] = i;
            j++;
        }
        return arr;
    }
    
    public static int[] removeDuplicates(int[] array)
    {
        int[] arr = new int[array.length];
        
        int num =0;
        for(int i =0; i < array.length; i++)
        {
            boolean notUnique = false;
            for(int j =0; j < arr.length; j++)
            {
                if(array[i] == arr[j])
                {
                    notUnique = true;
                }
            }
            if(!notUnique)
            {
                arr[num] = array[i];
                num++;
            }
        }
        int [] a = new int[num];
        for(int i=0; i< num; i++)
        {
            a[i] = arr[i];
        }
        return a;
    }
    
    public static void main(String[] args) {
        
        System.out.println(Arrays.toString(removeDups(array)));
        System.out.println(Arrays.toString(removeDuplicates(array)));
    }
    
}
