
package arraynthhighestnum;

import java.util.Arrays;

/**
 *
 * @author Ksenia Studilina
 */
public class ArrayNthHighestNum {

    public static int[] array = new int[]{1,8,5,7,0,6};
    
    public static int nThHighestNum(int[] array, int n)
    {
        if(n < 1 || n > array.length)
        {
            throw new ArrayIndexOutOfBoundsException("This number is greater/lower than number of items in array");
        }
        Arrays.sort(array);
        
        return array[array.length-n];
    }
    
    
    
    public static void main(String[] args) {
        System.out.println(nThHighestNum(array, 4));
        
    }
    
}
