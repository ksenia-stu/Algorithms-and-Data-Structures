
package day03customhashmap;

/**
 *
 * @author Ksenia Studilina
 */
public class Day03CustomHashMap {

    public static void main(String[] args) {
        
        CustomHashMapStringString hashMap = new CustomHashMapStringString();
        hashMap.putValue("k1", "hello");
        

       System.out.println(hashMap.hasKey("k1"));
       System.out.println(hashMap.getValue("k1"));
       hashMap.deleteByKey("k1");
       System.out.println(hashMap.hasKey("k1"));
       
       try
       {
           hashMap.getValue("k1");
       }
       catch(KeyNotFoundException ex)
       {
           System.out.println(ex.getMessage());
           
       }
       hashMap.putValue("k1", "ola");
       hashMap.putValue("k2", "hi");
       System.out.println(hashMap.getValue("k1"));
       System.out.println(hashMap.getValue("k2"));
       hashMap.putValue("k1", "oi");
       System.out.println(hashMap.getValue("k1"));
       hashMap.putValue("k3", "bye");
       hashMap.putValue("k4", "bonjour");
       System.out.println(hashMap.getValue("k3"));
       hashMap.deleteByKey("k3");
      // System.out.println(hashMap.getValue("k3"));
      String [] array = hashMap.getAllKeys();
      
      for(int i =0; i < array.length; i++)
      {
          System.out.print(array[i] + ",");
      }
      
      System.out.println(hashMap.getSize());
      hashMap.printDebug();
      System.out.println(hashMap.toString());
    }
    
}
