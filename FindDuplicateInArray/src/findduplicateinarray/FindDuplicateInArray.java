
package findduplicateinarray;

import java.util.Arrays;
import java.util.HashMap;


/**
 *
 * @author Ksenia Studilina
 */
public class FindDuplicateInArray {
    
    public static boolean isUnique(int[] array, int num)
    {
        boolean unique = true;
        for(int i =0; i < array.length; i++)
        {
           if(array[i] == num)
           {
               unique = false;
           }
        }
        return unique;
    }
    
    
    public static int[] findDuplicates(int[] array)
    {
        int[] arr = new int[array.length/2];
        int position = 0;
        for(int i =0; i < array.length; i++)
        {
            for(int j = 0; j < array.length; j++)
            {
                if(j > i && array[i] == array[j] && isUnique(arr, array[i]))
                {
                    arr[position] = array[i];
                    position++;
                }
            }
        }
        int[] a = new int[position];
        for(int i = 0; i < a.length; i++)
        {
            a[i] = arr[i];
        }
        return a;
    }
    
    public static void findDuplicates2(int[] array)
    {
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        for(int i : array)
        {
            if(!hm.containsKey(i))
            {
                hm.put(i, 0);
            }
            if(hm.containsKey(i))
            {
                hm.put(i, hm.get(i)+1);
            }          
            
        }
        for(int i : hm.keySet())
        {
            if(hm.get(i) != 1)
            {
                System.out.println(i);
            }
        }
    }

    public static void main(String[] args) {
        
        int[] array = new int[]{1,2,2,3,4,5,2,7,6,5,7,5};
        System.out.println(Arrays.toString(findDuplicates(array)));
        findDuplicates2(array);
    }
    
}
