
package arraymissingnum;

import java.util.Arrays;
import java.util.BitSet;

/**
 *
 * @author Ksenia Studilina
 */
public class ArrayMissingNum {

   public static void findMissingNum(int[] array)
   {
       Arrays.sort(array);
       
       BitSet bs = new BitSet(array.length);
       for(int i : array)
       {
           bs.set(i-1);
       }
       for(int i = 0; i <= bs.length(); i++)
       {
           if(bs.get(i) == false)
           {
               System.out.println(i+1);
           }
       }
       
   }
   
   
    
    public static void main(String[] args) {
        int[] array = new int[]{3,4,5,6,8,9};
        findMissingNum(array);
        
    }
    
}
