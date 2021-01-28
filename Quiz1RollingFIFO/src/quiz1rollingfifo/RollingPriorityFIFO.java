
package quiz1rollingfifo;

import java.util.Arrays;

/**
 *
 * @author Ksenia Studilina
 */

public class RollingPriorityFIFO {
    
    private class Item {
      // add constructor of your choice
      public Item(){}
      Item next;
      boolean priority;
      String value;
    }

   private Item tail, head; // enqueue at tail, dequeue at head
   int itemsTotal, itemsCurrUsed;

   /* Parameter itemsTotal must be 5 or more, otherwise IllegalArgumentException
    * is thrown. Items are allocated and connected via next pointer only
    * once - here, in the constructor. After that they are re-used.
    */
   public RollingPriorityFIFO(int itemsTotal) {
       this.itemsTotal = itemsTotal;
       if(itemsTotal < 5)
       {
           throw new IllegalArgumentException ("Total items cannot be less than 5");
       }
   }

   // Places value in the next available Item. If FIFO is full throws exception.
   public void enqueue(String value, boolean priority) throws FIFOFullException {
       if(itemsTotal == itemsCurrUsed)
       {
           throw new FIFOFullException ("The FIFO is full, new item cannot be enqueued");
       }
       if(itemsCurrUsed == 0)
       {   Item newItem = new Item();
           tail = newItem;
           tail.value = value;
           tail.priority = priority;
           head = newItem;
           head.value = value;
           head.priority = priority;
           itemsCurrUsed++;
       }
       else
       {
           Item newItem = new Item();
           newItem.value = value;
           newItem.priority = priority;
           tail.next = newItem;
            tail = tail.next;
            itemsCurrUsed++;
       }
   }

   /* returns null if fifo is empty, if it is not empty then
    * priority=true items are sarched first
    * if none is found then non-priority item is returned
    */

   public String dequeue() {
       if(itemsCurrUsed == 0)
       {
           return null;
       }
       //check for priority items
       Item before = null;
       Item currItem = head;
       for(int i =0; i < itemsCurrUsed; i++)
       {
           if(currItem.priority == true)
           {
               //remove this item
               String dequeued = currItem.value;
               
               if(currItem == head)
               {
                    head.value = null;
                    head.priority = false;
                    head = head.next;
                    itemsCurrUsed--;
                    return dequeued;
               }
               else if(currItem == tail)
               {
                   head.value = null;
                   head.priority = false;
                   tail = before;
                   itemsCurrUsed--;
                   return dequeued;
               }
               else
               {
                currItem.value = null;
                currItem.priority = false;
                before.next = currItem.next;
                currItem.next = tail.next;
                tail.next = currItem;
                itemsCurrUsed--;
                return dequeued;
                }
           }
           before = currItem;
           currItem = currItem.next;
       }
      
      //if no priority items
      String dequeued = head.value;
      head.value = null;
      head.priority = false;
      head = head.next;
      itemsCurrUsed--;
      return dequeued;  
   }

   public int size() { return itemsCurrUsed; } // current FIFO size
   public int sizeMax() { return itemsTotal; } // maximum FIFO size

   // Returns array of Strings of all items in FIFO (following next references).
   public String[] toArray() {
       Item currItem = head;
       String [] array = new String[size()];
       for(int i =0; i < size(); i++)
       {
           array[i] = currItem.value;
           currItem = currItem.next;
       }
       return array;
   }
   
   // Returns array of String only of priority items in FIFO.
   public String[] toArrayOnlyPriority() { 
       Item currItem = head;
       int numOfItems = 0;
       String [] array = new String[size()];
       
       for(int i =0; i < size(); i++)
       {
           if(currItem.priority == true)
           {
               numOfItems++;
               array[i] = currItem.value; 
           }
           currItem = currItem.next;
          
       }
       
       String [] arr = new String[numOfItems];
       int j= 0;
       for(int i = 0; i < arr.length; i++)
       {
           
           if(array[i] != null)
           {
              arr[j] = array[i];
              j++;
           }
               
                   
               
         
         
       }
       
       return arr;
   }

   // Items with priority=true have "*" appended, e.g. "[Jerry*,Maria,Tom*];
   // Items with priority=true have "*" appended, e.g. "[Jerry*,Maria,Tom*];
   // Items about to be dequeue()'d are listed first, items recently enqueue()'d last
   @Override
   public String toString() { 
       StringBuilder sb = new StringBuilder();
       sb.append("[");
       Item currItem = head;
       int items = 0;
       for(int i =0; i < size(); i++)
       {
           if(currItem.value != null)
           {
                String comma = (items == 0) ? "" : ",";
                String prior = (currItem.priority == true) ? "*" : "";
                sb.append(comma);
                sb.append(currItem.value);
                sb.append(prior);
                items++;
           }
           currItem = currItem.next;
       }
       
       sb.append("]");
       return sb.toString();
   }

    
}
