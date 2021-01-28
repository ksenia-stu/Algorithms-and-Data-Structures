
package day03linkedlistarray;

/**
 *
 * @author Ksenia Studilina
 */
public class Day03LinkedListArray {
    
    //each container
    private class Container {
		Container next; //following container
		String value; //value of current container
	}
    
        //Global
	private Container start, end;
	private int size;  //how many containers are there
        
        public void add(String value) {
            Container newCont = new Container();
            newCont.value = value;
            
            if(size == 0)
            {
               // newCont.next = null;
                start = newCont;
                end = newCont;
                size = 1;
            }
            else
            {
                end.next = newCont;
                end = newCont;
             //   newCont.next = null;
                size++;
            } 
        }
	public String get(int index) {
            if(index < 0 || index >= size)
            {
                throw new IndexOutOfBoundsException("This index does not exist");
            }
            
            Container searched = start;
         
            int i = 0;
            while(i < index)
            {
                if(index == 0)
                {
                    searched = start;
                    return start.value;
                }
               searched = searched .next;
               i++;
            }
            return searched.value;
         
        }
	public void insertValueAtIndex(int index, String value) {
            if(index <0 || index > size-1)
            {
                throw new IndexOutOfBoundsException("Index " + index + " is out of bounds");
            }
            Container newCont = new Container();
            newCont.value = value;
            size++;
            Container searched = start;
            if (index == 0)
            {
                newCont.next = start;
                start = newCont;
            }
            else
            {
                for(int i =1; i < index; i++)
                {
                    searched = searched.next;
                }
            
                 newCont.next = searched.next;
                searched.next = newCont;     //searched is the container right before newly inserted index
               
            }
            
            
        }
	public void deleteByIndex(int index) { 
            if(index <0 || index > size-1)
            {
                throw new IndexOutOfBoundsException("Index " + index + " is out of bounds");
            }
            Container beforeDeletedItem = start;
                for(int i=1; i < index; i++)
                {
                    beforeDeletedItem = beforeDeletedItem.next;
                }
            if(index == 0)
            {
                start = start.next;
            }
            
            else if(index == size-1)
            {
                
                beforeDeletedItem.next = null;
                beforeDeletedItem = end;
            }
            else
            {
                
                beforeDeletedItem.next = beforeDeletedItem.next.next;
            }
            size--;
        }
	public boolean deleteByValue(String value) {
            Container currentCont = start;
            if(start.value == value)
            {
                deleteByIndex(0);
                return true;
            }
            for(int i=1; i < size; i++)
            {
                if(currentCont.value == value)
                {
                    deleteByIndex(i-1);
                    return true;
                }
                currentCont = currentCont.next;
            }
            return false;
        } // delete first value found
	public int getSize() {
            return size;
        }
	
	@Override
	public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            Container currentCont = start;
            if(size < 2)
            {
                sb.append(start.value);
            }
            else
            {
                sb.append(start.value);
                for(int i = 1; i < size; i++)
                {
                    currentCont = currentCont.next;
                    sb.append(",");
                    sb.append(currentCont.value);
                }
            }
            sb.append("]");
            return sb.toString();
        } // comma-separated values list similar to: [5,8,11]

	public String[] toArray() {
            String[] array = new String[size];
            Container currentCont = start;
            if(size < 1)
            {
                throw new NullPointerException ("Linked list size is null");
            }
            else if(size == 1)
            {
                array[0] = start.value;
            }
            else
            {   
                array[0] = start.value;
                for(int i =1; i < size; i++)
                {
                    currentCont = currentCont.next;
                    array[i] = currentCont.value;
                }
            }
            return array;
        } // could be used for Unit testing 

    
    public static void main(String[] args) {
        Day03LinkedListArray arrayList = new Day03LinkedListArray();
       // arrayList.add("sss");
      //  arrayList.add("kkk");
      //  arrayList.add("mmm");
     /*   System.out.println(arrayList.get(0));
        System.out.println(arrayList.get(1));
        System.out.println(arrayList.get(2));
        System.out.println();
        arrayList.insertValueAtIndex(0, "Ksusha");
        System.out.println(arrayList.get(0));
        System.out.println(arrayList.get(1));
        System.out.println(arrayList.get(2));
        System.out.println(arrayList.get(3));
        System.out.println();
        arrayList.insertValueAtIndex(0, "Safa");
        System.out.println(arrayList.get(0));
        System.out.println(arrayList.get(1));
        System.out.println(arrayList.get(2));
        System.out.println(arrayList.get(3));
        System.out.println(arrayList.get(4));
        System.out.println();
        arrayList.insertValueAtIndex(2, "Fofura");
        arrayList.add("Last");
        System.out.println(arrayList.get(0));
        System.out.println(arrayList.get(1));
        System.out.println(arrayList.get(2));
        System.out.println(arrayList.get(3));
        System.out.println(arrayList.get(4));
        System.out.println(arrayList.get(5));
        System.out.println(arrayList.get(6));
        System.out.println();
        arrayList.deleteByIndex(6);
        System.out.println(arrayList.get(0));
        System.out.println(arrayList.get(1));
        System.out.println(arrayList.get(2));
        System.out.println(arrayList.get(3));
        System.out.println(arrayList.get(4));
        System.out.println(arrayList.get(5));
        System.out.println();
        arrayList.deleteByValue("Safa");
        System.out.println(arrayList.get(0));
        System.out.println(arrayList.get(1));
        System.out.println(arrayList.get(2));
        System.out.println(arrayList.get(3));
        System.out.println(arrayList.get(4));
        System.out.println(arrayList.toString()); */
     String[] array = null;
     try
     {
        array  = arrayList.toArray();
     }
     catch(NullPointerException ex)
     {
         System.out.println(ex.getMessage());
         return;
     }
        
        for(int i =0; i < array.length; i++)
        {
            String comma = (i==0) ? "" : ",";
            System.out.print(comma + array[i]);
        }
        
       
    }
    
}
