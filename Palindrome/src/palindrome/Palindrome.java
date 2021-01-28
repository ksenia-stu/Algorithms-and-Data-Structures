
package palindrome;

/**
 *
 * @author Ksenia Studilina
 */
public class Palindrome {

    public static boolean isPalindrome(String s)
    {
        if(s == null || s.isEmpty()) { return false;}
        StringBuilder sb = new StringBuilder();
        char [] array = s.toCharArray();
        for(int i = array.length-1; i >= 0; i--)
        {
            sb.append(array[i]);
        }
        return sb.toString().equals(s);
    }
    
    public static boolean isPalindrome1(String s)
    {
        StringBuffer sbf = new StringBuffer(s);
        sbf.reverse();
        return sbf.toString().equals(s);
    }
    
    public static boolean isPalindrome2(String s)
    {
        if(s == null || s.isEmpty()) { return false;}
        StringBuilder sb = new StringBuilder();
        for(int i = s.length()-1; i >= 0; i--)
        {
            sb.append(s.charAt(i));
        }
        return sb.toString().equals(s);
    }
    
    public static void main(String[] args) {
        String word = "nn";
        System.out.println(isPalindrome(word));
        System.out.println(isPalindrome1(word));
        System.out.println(isPalindrome2(word));
        
    }
    
}
