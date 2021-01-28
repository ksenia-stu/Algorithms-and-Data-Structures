
package anagramstrings;

import java.util.Arrays;

/**
 *
 * @author Ksenia Studilina
 */
public class AnagramStrings {

    public static boolean isAnagram(String s1, String s2)
    {
        if(s1.length() != s2.length()) { return false;}
        String[] array1 = s1.split("");
        String[] array2 = s2.split("");
        Arrays.sort(array1);
        Arrays.sort(array2);
        System.out.println(Arrays.toString(array1));
        System.out.println(Arrays.toString(array2));
        
        
        return Arrays.equals(array1, array2);
    }
    
    public static void main(String[] args) {
        
        String s1 = "mam";
        String s2 = "amam";
        
        System.out.println(isAnagram(s1, s2));
    }
    
}
