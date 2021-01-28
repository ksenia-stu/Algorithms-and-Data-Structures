
package day2twodimarray;

import java.util.InputMismatchException;
import java.util.Scanner;


public class Day2TwoDimArray {

    public static int rows;
    public static int cols;
    public static int [][] array;
    public static Scanner scan = new Scanner(System.in);
    
    public static int[] calculateWidth(int [][] array)
    {
        int [] lengths = new int[array[0].length];
        for(int i =0; i < array.length; i ++)
        {
            for(int j = 0; j < array[i].length; j++)
            {
                
                String len = (array[i][j])+ "";
                int leng = len.length();
                if(leng > lengths[j])
                {
                    lengths[j] = leng;
                }
            }
        }
        return lengths;
    }
    
    static void printArray(int [][] array)
    {
         String comma = "";
        for(int i =0; i < array.length; i++)
            {
                for(int j=0; j < array[i].length; j++)
                {
            System.out.print(comma);
                    int [] widths = calculateWidth(array);
                    String word = array[i][j] +"";
                    int length = word.length();
                    for(int a =0; a < (widths[j] -length); a++)
                    {
                        System.out.print(" ");
                    }
                    System.out.print(array[i][j]);
                    comma = ",";
                }
                System.out.println();
                comma = "";
            }
    }
    
    public static int sumOfAllNums(int [][] array)
    {
        int sum = 0;
        for(int i =0; i < array.length; i++)
            {
                for(int j=0; j < array[i].length; j++)
                {
                    sum = sum + array[i][j];
                }
            }
        return sum;
    }
    
    public static int [] sumOfEachRow(int [][] array)
    {
        
        int[] sums = new int[array.length];
        for(int i =0; i < array.length; i++)
            {
                int sum = 0;
                for(int j=0; j < array[i].length; j++)
                {
                    sum = sum + array[i][j];
                }
               sums[i] = sum; 
            }
        return sums;
    }
    
    public static int [] sumOfEachCol(int [][] array)
    {
        
        int[] sums = new int[array[0].length];
        for(int i =0; i < array.length; i++)
            {
                
                for(int j=0; j < array[i].length; j++)
                {
                    sums[j] = sums[j] + array[i][j];
                }
            }
        return sums;
    }
    
    public static boolean isPrime(int num)
   {
       if(num <= 1)
       {
           return false;
       }
       
       for(int i = 2; i <= num/2; i++)
       {
           if(num%i == 0)
           {
               return false;
           }
       }
       return true;
   }
    
    public static double standDev(int[][] array)
    {
        //find mean
        int numberofNums = 0;
        int sum = 0;
        for(int i =0; i < array.length; i++)
            {
                
                for(int j=0; j < array[i].length; j++)
                {
                    sum = sum + array[i][j];
                    numberofNums ++;
                }
            }
        double mean = sum/numberofNums;
        
        double[][] deviations = new double[array.length][array[0].length];
        double newSum = 0;
        for(int i =0; i < array.length; i++)
            {
                
                for(int j=0; j < array[i].length; j++)
                {
                    deviations[i][j] = Math.pow(array[i][j] - mean, 2);
                    newSum = newSum + deviations[i][j];
                }
            }
        
        newSum = newSum/numberofNums;
        
        return Math.sqrt(newSum);
    }
    
    public static void pairOfPrimeSum(int [][] array)
    {
         for(int i =0; i < array.length; i++)
         {
                
            for(int j=0; j < array[i].length; j++)
            {
                for(int k =0; k < array.length; k++)
                {
                
                    for(int n=0; n< array[i].length; n++)
                    {
                        if((isPrime(array[i][j]+ array[k][n])) == true && (i != k && j != n) && (k >i && n > j))
                        {
                            System.out.println("Pair: " + array[i][j] + " and " + array[k][n] +
                                    " have prime number sum of " + (array[i][j]+ array[k][n]));
                        }
                    }
                }
            }
         }
    }
    
    public static void main(String[] args) {
        
        try
        {
            System.out.println("Enter numbers of rows: ");
            rows = scan.nextInt();
            System.out.println("Enter number of columns");
            cols = scan.nextInt();
            
            if(rows < 1 || cols < 1)
            {
                System.out.println("Value must be 1 or greater");
                return;
            }
            
            array = new int[rows][cols];
           
            for(int i =0; i < array.length; i++)
            {
                for(int j=0; j < array[i].length; j++)
                {
                    array[i][j] = (int)(Math.random()*199)-99;
                
                }
                
            }
            
            System.out.println("\nArray:\n");
            printArray(array);
            
            System.out.println("\n Widths:\n");
            int [] arr = calculateWidth(array);
            for(int i = 0; i < arr.length; i ++)
            {
                System.out.print(arr[i]+",");
            }
            
            System.out.println("\nSum of all numbers:\n");
            System.out.println(sumOfAllNums(array));
            
            System.out.println("\n sum of each row:\n");
            int [] sums = sumOfEachRow(array);
            
            String comma = "";
            for(int i = 0; i < sums.length; i ++)
            {
                System.out.print(comma + sums[i]);
                comma = ",";
            }
            
            System.out.println("\n sum of each column:\n");
            int [] sum = sumOfEachCol(array);
            
            String comm = "";
            for(int i = 0; i < sum.length; i ++)
            {
                System.out.print(comma + sum[i]);
                comm = ",";
            }
            
            System.out.println();
            System.out.println(standDev(array));
            
            pairOfPrimeSum(array);
            
        }
        catch(InputMismatchException ex)
        {
            System.out.println("Value must be an integer");
            return;
        }
    }
    
}
