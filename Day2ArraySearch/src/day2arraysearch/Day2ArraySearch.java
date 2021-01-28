
package day2arraysearch;


public class Day2ArraySearch {

public static int[][] data = {{3,5,7},{3,6}};


    static int getIfExists(int[][] data, int row, int col) {
	     // If exists, return the element, otherwise return 0
             if((row >= 0 && row < data.length) && (col >= 0 && col < data[row].length))
             {
                 return data[row][col];
             }
             else
             {
                 return 0;
             }        
    }
    
    static int sumOfCross(int[][] data, int row, int col) {
        int sum = 0;
       
       return sum = getIfExists(data, row, col) + getIfExists(data,row-1,col) + getIfExists(data,row+1,col)
                     + getIfExists(data,row,col+1) + getIfExists(data,row,col-1);
            
	    // return sum of the element at row/col
        // plus (if they exist) element above, below, to the left and right of it
    }
    
    static void print2D(int[][] data) { 
        String comma = "";
        for(int i =0; i < data.length; i++)
        {
            for(int j = 0; j < data[i].length; j++)
            {
                System.out.print(comma + data[i][j]);
                comma = ",";
            }
            System.out.println();
        }
    }
    
    // duplicate a jagged array
	static int[][] duplicateEmptyArray2D(int[][] orig2d) { 
            int [][] array = new int[orig2d.length][];
            for(int i =0; i < orig2d.length; i++)
            {
                array[i] = new int[orig2d[i].length];
            }
            return array;
        }
        
        static int[][] createDuplicateCrossArray(int[][] orig2d) { 
            int [][] array = duplicateEmptyArray2D(data);
            for(int i =0; i < orig2d.length; i++)
            {
                array[i] = new int[orig2d[i].length];
            }
            for(int i = 0; i < array.length; i ++)
            {
                for(int j= 0; j < array[i].length; j++)
                {
                    array[i][j] = sumOfCross(orig2d, i, j);
                }
            }
            return array;
        }
        
    public static String smallestSum(int[][] data2d){
        int sum = 0;
        int minSum = Integer.MAX_VALUE;
        String num = "";
        for(int i = 0; i < data2d.length; i++)
        {
            for(int j = 0; j < data2d[i].length; j++)
            {
                sum = sumOfCross(data2d, i, j);
                
                if(minSum > sum)
                {
                    minSum = sum;
                    num = "Element at row " + i + " column " + j + " has the smallest sum " + minSum;
                }
            }
        }
        
        return num;
        
    }
        
    public static void main(String[] args) {
       
        print2D(data);
        
        System.out.println(smallestSum(data));
        
        print2D(createDuplicateCrossArray(data));
    }
    
}
