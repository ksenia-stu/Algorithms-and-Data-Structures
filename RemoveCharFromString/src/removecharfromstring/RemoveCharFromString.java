
package removecharfromstring;

/**
 *
 * @author Ksenia Studilina
 */
public class RemoveCharFromString {

    public static String removeCharacter(String s, String character)
    {
        String [] array = s.split("");
        StringBuilder sb = new StringBuilder();
        for(int i=0; i < array.length; i++)
        {
            if(array[i].equals(character) == false)
            {
                sb.append(array[i]);
            }
        }
        return sb.toString();
    }
    
    public static void main(String[] args) {
        
        String word = "hello";
        System.out.println(removeCharacter(word, "e"));
    }
    
}
