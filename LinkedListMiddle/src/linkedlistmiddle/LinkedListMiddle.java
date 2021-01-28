
package linkedlistmiddle;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Ksenia Studilina
 */
public class LinkedListMiddle {

    public static void returnMiddle(LinkedList<Integer> list)
    {
        System.out.println(list.get(Math.round(list.size()-1)/2));
    }
    
    public static void main(String[] args) {
        
        LinkedList<Integer> list = new LinkedList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        returnMiddle(list);
    }
    
}
