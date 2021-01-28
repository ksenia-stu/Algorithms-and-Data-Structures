
package pairsofnums;

/**
 *
 * @author Ksenia Studilina
 */
public class PairsOfNums {
    
    public static int[] array = new int[]{1,2,3,4,5,6,7,2};
    
    public static void findPairs(int[] array, int sum)
    {
        for(int i=0; i < array.length; i++)
        {
            for(int j= 0; j < array.length; j++)
            {
                if(j > i && (array[i] + array[j]== sum))
                {
                    System.out.println("Sum of " + array[i] + " and " + array[j] + " is " + sum);
                }
            }
        }
    }

    public static void main(String[] args) {
        
        findPairs(array, 8);
        
    }
    
}
