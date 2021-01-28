
package numericstringtoint;

/**
 *
 * @author Ksenia Studilina
 */
public class NumericStringToInt {

    public static int stringToInt(String s)
    {
        int num = 0;
        try
        {
            num = Integer.parseInt(s);
        }
        catch(NumberFormatException ex)
        {
            num = 0;
        }
        return num;
    }
    
    public static void main(String[] args) {
       
        String s = "0000081";
        System.out.println(stringToInt(s));
    }
    
}
