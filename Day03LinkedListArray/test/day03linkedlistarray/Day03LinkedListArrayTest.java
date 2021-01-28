
package day03linkedlistarray;


import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Rule;
import org.junit.rules.Timeout;

/**
 *
 * @author Ksenia Studilina
 */
public class Day03LinkedListArrayTest {
    
    @Rule
    public Timeout globalTimeout = new Timeout(10 * 1000); // 10s max for any single test
    
    @Test(timeout = 5000) // 5 seconds timeout for this particular test
    public void LinkedListArrayAddMany() {
        Day03LinkedListArray instance = new Day03LinkedListArray();
        instance.add("Jerry");
        instance.add("Terry");
        instance.add("Barry");
        instance.add("Larry");
        assertEquals(4, instance.getSize());
        assertArrayEquals(new String[]{"Jerry", "Terry", "Barry", "Larry"}, instance.toArray());
    }
    
    @Test
    public void LinkedListArrayDeleteByIndex() {
        Day03LinkedListArray instance = new Day03LinkedListArray();
        instance.add("a");
        instance.add("b");
        instance.add("c");
        instance.add("d");
        instance.deleteByIndex(0);
        assertEquals(3, instance.getSize());
        assertArrayEquals(new String[]{"b", "c", "d"}, instance.toArray());
    }
    
    @Test
    public void LinkedListArrayDeleteByValue() {
        Day03LinkedListArray instance = new Day03LinkedListArray();
        instance.add("a");
        instance.add("b");
        instance.add("c");
        instance.add("d");
        instance.deleteByValue("b");
        assertEquals(3, instance.getSize());
        assertArrayEquals(new String[]{"a", "c", "d"}, instance.toArray());
    }
    
    @Test
    public void LinkedListArrayGetItem() {
        Day03LinkedListArray instance = new Day03LinkedListArray();
        instance.add("a");
        instance.add("b");
        instance.add("c");
        assertEquals("b", instance.get(1));
        
    }
    
    @Test(expected = IndexOutOfBoundsException.class)
    public void LinkedListArrayDeleteByIndexOutOfBounds() {
        Day03LinkedListArray instance = new Day03LinkedListArray();
        instance.add("a");
        instance.add("b");
        instance.add("c");
        instance.deleteByIndex(5);
        
    }
    
    
}
