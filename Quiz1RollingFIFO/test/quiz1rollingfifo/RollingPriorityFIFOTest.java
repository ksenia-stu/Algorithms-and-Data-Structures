
package quiz1rollingfifo;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Ksenia Studilina
 */
public class RollingPriorityFIFOTest {
    
    public RollingPriorityFIFOTest() {
    }
    
    
    @Test
    public void RollingPriorityFIFOEnqueueTest() {
        RollingPriorityFIFO instance = new RollingPriorityFIFO(5);
        try
        {
            instance.enqueue("A", false);
            instance.enqueue("B", true);
            instance.enqueue("C", false);
        }
        catch(FIFOFullException ex)
        {
            System.out.println(ex.getMessage());
        }
        
        assertEquals(3,instance.itemsCurrUsed);
        assertEquals("[A,B*,C]", instance.toString());
    }
    
    @Test (expected = FIFOFullException.class)
    public void RollingPriorityFIFOEnqueueFullFIFOTest() throws FIFOFullException {
        RollingPriorityFIFO instance = new RollingPriorityFIFO(5);

            instance.enqueue("A", false);
            instance.enqueue("B", true);
            instance.enqueue("C", false);
            instance.enqueue("D", false);
            instance.enqueue("E", true);
            instance.enqueue("F", false);   
    }
    
    @Test
    public void RollingPriorityFIFODenqueueItemTest() throws FIFOFullException{
        RollingPriorityFIFO instance = new RollingPriorityFIFO(5);
       
            instance.enqueue("A", false);
            instance.enqueue("B", false);
            instance.enqueue("C", false);
        
        assertEquals("A",instance.dequeue());
        assertEquals("[B,C]", instance.toString());
    }
    
    
    @Test
    public void RollingPriorityFIFODenqueuePriorityItemTest() throws FIFOFullException{
        RollingPriorityFIFO instance = new RollingPriorityFIFO(5);
       
            instance.enqueue("A", false);
            instance.enqueue("B", true);
            instance.enqueue("C", false);
        
        assertEquals("B",instance.dequeue());
        assertEquals("[A,C]", instance.toString());
    }
    
    @Test
    public void RollingPriorityFIFODenqueueEmptyFIFOTest(){
        RollingPriorityFIFO instance = new RollingPriorityFIFO(5);
        
        assertEquals(null,instance.dequeue());
        assertEquals("[]", instance.toString());
    }
    
    @Test
    public void RollingPriorityFIFODenqueueFIFOWithSingleItemTest() throws FIFOFullException{
        RollingPriorityFIFO instance = new RollingPriorityFIFO(5);
        
        instance.enqueue("A", false);
        
        assertEquals("A",instance.dequeue());
        assertEquals("[]", instance.toString());
        assertEquals(0,instance.size());
        assertEquals(5,instance.sizeMax());
    }
    
    
    
}
