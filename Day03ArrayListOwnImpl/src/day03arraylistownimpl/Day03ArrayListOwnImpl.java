
package day03arraylistownimpl;

public class Day03ArrayListOwnImpl {

    
    public static void main(String[] args) {
        CustomArrayOfInts arr = new CustomArrayOfInts();
        arr.add(5);
        arr.add(6);
        arr.add(9);
        arr.add(20);
        arr.insertValueAtIndex(600, 4);
        arr.insertValueAtIndex(600, 5);
        arr.insertValueAtIndex(600, 7);
       
      /*  arr.add(10);
        arr.add(30);
        arr.deleteByIndex(2);
        arr.add(90);
        arr.deleteByIndex(0);
        arr.add(890); */
     /*   arr.insertValueAtIndex(500, 0);
        
        int[] array = null;
        try
        {
            array = arr.getSlice(0, 2);
        }
        catch(IndexOutOfBoundsException ex)
        {
            System.out.println("hello" + ex.getMessage());
        } */
        
       
        
     //   System.out.println(arr.deleteByValue(90));
     //   System.out.println(arr.deleteByValue(20));
        
        
      /*  String comma = "";
        for(int i : arr.data)
        {
            System.out.print(comma +i);
            comma = ",";
        } */
        
      /*  if(array != null)
        {
            System.out.println("Slice: ");
            for(int i : array)
            {
                System.out.print("," +i);
            }
        } */
        
        System.out.println(arr.toString()); 
    }
    
}
