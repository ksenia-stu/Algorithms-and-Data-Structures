
package day03arraylistownimpl;


public class CustomArrayOfInts {
    
        public int [] data = new int[1]; // only grows by doubling size, never shrinks
	private int size = 0; // how many items do you really have

	public int size() { return size; }
        
	public void add(int value) { 
            if(size == data.length)
            {
                int []dataTemp = new int[data.length*2];
                for(int i = 0; i < data.length; i++)
                {
                    dataTemp[i] = data[i];
                }
                data = dataTemp;
                
            }
                
                data[size] = value;
                size++;  
        }
 	public void deleteByIndex(int index) { 
            if(index < 0 || index > size -1)
            {
                System.out.println("This index does not exist, item was not deleted");
            }
            for(int i = index+1; i < data.length-1; i++)
            {
                data[i-1] = data[i];
            }
            size--;
        }
	public boolean deleteByValue(int value) { 
            for(int i = 0; i <= size; i++)
            {
                if(data[i] == value)
                {
                    deleteByIndex(i);
                    return true;
                    
                }
            }
            return false;
        } // delete first value matching, true if value found, false otherwise
        
	public void insertValueAtIndex(int value, int index) { 
            if(index < 0 || index > size)
            {
                System.out.println("This index does not exist");
            }
            else
            {
                if(size == data.length)
                {
                    int []dataTemp = new int[data.length*2];
                    for(int i = 0; i < data.length; i++)
                    {
                        dataTemp[i] = data[i];
                    }
                    data = dataTemp;
                }
                for(int i = size; i >= index; i--)
                {
                    data[i+1] = data[i];
                }
                data[index] = value;
                size++;
            }
                    
        }
	public void clear() { size = 0; }
	public int get(int index) { 
            if(index < 0 || index >= size)
            {
                throw new IndexOutOfBoundsException("This index does not exist");
            }
            return data[index];
            
        } // may throw IndexOutOfBoundsException
	public int[] getSlice(int startIdx, int length) { 
            if(startIdx < 0 || startIdx >= size || (startIdx + length) >= size)
            {
                throw new IndexOutOfBoundsException("This slice does not exist");
            }
            int[] array = new int[startIdx+length];
            for(int i = startIdx; i < startIdx+length; i++ )
            {
               array[i-startIdx] = data[i]; 
            }
            return array;
            
        } // may throw IndexOutOfBoundsException
	
	@Override
	public String toString() {
            String comma = "";
          //  String arrayStr = "";
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            for(int i =0; i < size; i++)
            {
                sb.append(comma+ data[i]);
               // arrayStr = arrayStr +(comma+ data[i]);
                comma = ",";
            }
            sb.append("]");
            return sb.toString();
        } // returns String similar to: [3, 5, 6, -23] */
}
