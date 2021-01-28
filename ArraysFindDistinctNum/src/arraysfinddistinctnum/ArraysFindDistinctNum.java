
package arraysfinddistinctnum;

/**
 *
 * @author Ksenia Studilina
 */
public class ArraysFindDistinctNum {

    
    public static void findDistinctNums(int[] array1, int[] array2)
    {
       
        for(int i = 0; i < array1.length; i++)
        {
            boolean isPresent = false;
            for(int j = 0; j < array2.length; j++)
            {
                if(array1[i] == array2[j])
                {
                    isPresent = true;
                }
            }
            if(isPresent == false)
            {
                System.out.println(array1[i]);
            }
            
            
        }
    }
    
    public static void main(String[] args) {
        int [] array1 = new int[]{1,2,3,4,5,6,7};
        int [] array2 = new int[]{2,3,1,0,5};
        findDistinctNums(array1, array2);
    }
    
}
