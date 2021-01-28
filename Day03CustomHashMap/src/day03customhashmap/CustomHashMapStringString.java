package day03customhashmap;

import java.util.Arrays;



/**
 *
 * @author Ksenia Studilina
 */
public class CustomHashMapStringString {

    private class Container {

        Container next;
        String key;
        String value;
    }

    //Global
    // size must be a prime number always
    private Container[] hashTable = new Container[5];

    private int totalItems; //in hashTable

    private int computeHashValue(String key) {
        int hash = 0;
        for (int i = 0; i < key.length(); i++) {
            hash <<= 1;  // same as: hash *= 2
            char c = key.charAt(i);
            hash += c;
        }
        return hash;
    }

    // throw custom unchecked KeyNotFoundException
    String getValue(String key) {
        if (hasKey(key) == true) {
            for (int i = 0; i < hashTable.length; i++) {
                if (hashTable[i] != null)
                {
                    Container currentCont = hashTable[i];
                    if(currentCont.key == key) //if it is first and only item in bucket
                    {
                        return currentCont.value;
                    }
                    while (currentCont.next != null) {
                        if (currentCont.key == key) {
                            return currentCont.value;
                        }
                        currentCont = currentCont.next;
                    }
                }
            }
        }
        throw new KeyNotFoundException("Key " + key + " is not found");

    }

    void expandHashTable() {
        Container[] tempTable = new Container[11];
        for (int i = 0; i < hashTable.length; i++) {
            tempTable[i] = hashTable[i];
        }
        hashTable = tempTable;
    }

    void putValue(String key, String value) {
        if (totalItems > 3 * hashTable.length) {
            expandHashTable();
        }

        int hashValue = computeHashValue(key);
        int index = hashValue % hashTable.length;

        Container newCont = new Container();
        newCont.key = key;
        newCont.value = value;

        //check if key already exists
        if (hasKey(key) == true) {
            Container currentCont = hashTable[index];
            if(currentCont.key == key) //if it is first and only item in bucket
            {
                currentCont.value = value;
                return;
            }
            while (currentCont.next != null) {
                if (currentCont.key == key) {
                    currentCont.value = value;
                    return;
                }
                currentCont = currentCont.next;
            }
        }

        //if key does not exist
        //check if bucket is empty
        if (hashTable[index] == null) {
            newCont.next = null;
            hashTable[index] = newCont;
            totalItems++;
        } else //if not empty
        {

            newCont.next = hashTable[index];
            hashTable[index] = newCont;
            totalItems++;

        }
    }
    // LATER: expand hashTable by about *2 when totalItems > 3*hashTable.length

    boolean hasKey(String key) {
        for (int i = 0; i < hashTable.length; i++) {
            if(hashTable[i] != null)
            {
                Container currentCont = hashTable[i];
                if(currentCont.key == key)
                {
                    return true;
                }
                while (currentCont.next != null) {
                    if (currentCont.key == key) {
                         return true;
                    }
                    currentCont = currentCont.next;
                }
            }
        }
        return false;
    }

    // throw custom unchecked KeyNotFoundException
    void deleteByKey(String key) {
        if (hasKey(key) == true) {
            for (int i = 0; i < hashTable.length; i++) {
                if (hashTable[i] != null) {
                    for (Container currentCont = hashTable[i]; currentCont.next == null; currentCont = currentCont.next) {
                        //if it is the first item of hashTable
                        if (hashTable[i] == currentCont && hashTable[i].key == key) {
                            hashTable[i] = null;
                            totalItems--;
                            return;
                        }
                        // if not first
                        if (currentCont.next.key == key) {
                            currentCont.next = currentCont.next.next;
                            totalItems--;
                            return;
                        }
                    }
                }
            }
        } else {
            throw new KeyNotFoundException("This key " + key + " does not exist");
        }
    }

    	public String[] getAllKeys() { 
            String[] array = new String[totalItems];
            int arrIndex =0;
            for (int i = 0; i < hashTable.length; i++) {
                if(hashTable[i] != null)
                {
                    Container currentCont = hashTable[i];
                    array[arrIndex] = currentCont.key;
                    arrIndex++;

                    while (currentCont.next != null) {
                        array[arrIndex] = currentCont.key;
                        currentCont = currentCont.next;
                        arrIndex++;
                    }
                }
            }
            return array;
        }
        
    
    int getSize() { 
        return totalItems;
    }

    public void printDebug() { 
         for (int i = 0; i < hashTable.length; i++) {
             System.out.println("Entry" + i);
            if(hashTable[i] != null)
            {
                Container currentCont = hashTable[i];
                System.out.println("- Key " + currentCont.key + ", Value: " + currentCont.value);
                while (currentCont.next != null) {
                    System.out.println("- Key " + currentCont.key + ", Value: " + currentCont.value);
                    currentCont = currentCont.next;
                }
            }
        }
        
    } // print hashTable content, see example below

	@Override
	public String toString() {
            String [] array = getAllKeys();
            Arrays.sort(array);
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            for(int i = 0; i < array.length; i++)
            {
                String comma = (i == 0) ? "" : ",";
                sb.append(comma);
                sb.append(array[i] + " => " + getValue(array[i]));
            }
            sb.append("]");
            return sb.toString();
        } // comma-separated values->key pair list
	// to be able to use this as validation in Unit tests keys must be sorted
	// e.g. [ Key1 => Val1, Key2 => Val2, ... ]
}
