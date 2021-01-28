package day1universalarrays;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Day1UniversalArrays {

    public static Scanner scan = new Scanner(System.in);
    public static int[] data = new int[5];
    public static int[] data2 = new int[]{3, 5, 6, 7, 9};
    public static int[][] data2d = new int[3][3];
    public static int[][] data2d2 = new int[3][3];

    static int getInt() {
        int num;
        while (true) {
            try {
                num = scan.nextInt();
                return num;
            } catch (InputMismatchException ex) {
                scan.next(); //consume wrong input
                System.out.println("Input must be numerical");
                System.out.println("Enter an integer: ");
            }
        }
    }

    static void inputArray(int[] data) {

        for (int i = 0; i < data.length; i++) {
            System.out.print("Enter value: ");
            data[i] = getInt();
        }

    } // single dimensional
    
    static void inputArray(int [][] data2d) { 
        for(int i =0; i < data2d.length; i++)
        {
            for(int j = 0; j < data2d[i].length; j++)
            {
                System.out.printf("Enter value row %d column %d: ", i, j);
                data2d[i][j] = getInt();
            }
        }
    } // two dimensional, could be *jagged* array
    
    static void printArray(int [] data) { 
        String comma = "";
        for(int i =0; i < data.length; i++)
        {
            System.out.print(comma + data[i]);
            comma = ",";
        }
    } // print on a single line, comma-separated
    
    static void printArray(int [][] data2d) { 
        String comma = "";
        for(int i =0; i < data2d.length; i++)
        {
            for(int j = 0; j < data2d[i].length; j++)
            {
                System.out.print(comma);
                int[] widths = calculateColWidth(data2d);
                String str = data2d[i][j] + "";
                int width = str.length();
                for(int n = 0; n < (widths[j] - width); n ++)
                {
                    System.out.print(" ");
                }
                System.out.print(data2d[i][j]);
                comma = ",";
            }
            comma = "";
            System.out.println();
            
        }
    } // could be a *jagged* array
    
    public static int[] calculateColWidth(int [][] data2d)
    {
        int [] widths = new int[data2d[0].length];
        for(int i =0; i < data2d.length; i++)
        {
            for(int j = 0; j < data2d[i].length; j++)
            {
               String str = data2d[i][j] + "";
               int width = str.length();
               if(width > widths[j])
               {
                   widths[j] = width;
               }
            }
        }
        return widths;
    }
    
    static int[] findDuplicates(int [] a1, int[]a2) {
        
        int len = (a1.length < a2.length) ? a1.length : a2.length;
        System.out.println("length of dups array: " + len);
        int[] dups = new int[len];
        int num =0;
        for(int i =0; i < a1.length; i++)
        {
            for(int j =0; j < a2.length; j++)
            {
                if(a1[i] == a2[j])
                {
                    boolean isUnique = true;
                    for(int y =0; y < num; y++)
                    {
                        if( dups[y] == a1[i])
                        {
                           isUnique = false;
                           break;
                        }
                    }
                        if(isUnique == true)
                        {
                            dups[num] = a1[i];
                            num++;
                        }  
                }
            }
        }
        
        int[] array = new int[num];
        for(int k =0; k < array.length; k++)
        { 
            array[k] = dups[k];
        }
        return array;
    }
    
    static int[] findDups(int [][] a1, int[][]a2) { 
        int number = 0;
        int[] dups = new int[a1.length * a1[0].length];
        for(int i =0; i < a1.length; i++)
        {
            for(int j = 0; j < a1[i].length; j++)
            {
                for(int n = 0; n < a2.length; n++)
                {
                    for(int m =0; m < a2[n].length; m++)
                    {
                        if(a1[i][j] == a2[n][m])
                        {
                            boolean isUnique = true;
                            for(int k = 0; k < number; k++)
                            {
                                if(dups[k] == a1[i][j])
                                {
                                    isUnique = false;
                                }
                            }
                            
                            if(isUnique == true)
                            {
                                dups[number] = a1[i][j];
                                number++;
                            }
                        }
                    }
                }
            }
        }
        int[] array = new int[number];
        for(int i =0; i < array.length; i ++)
        {
            array[i] = dups[i];
        }
        return array;
    }
    
    public static int[] join(int[] a1, int []a2) { 
        int [] array = new int[a1.length + a2.length];
        
        for(int i =0; i < a1.length; i++)
        {
            array[i] = a1[i];
        }
        int k = 0;
        for(int j= a1.length; j < array.length; j++)
        {
            array[j] = a2[k];
            k++;
        }
        return array;
    }

    public static void main(String[] args) {
        inputArray(data);
     /*   inputArray(data2d);
       // printArray(data);
        System.out.println();
        printArray(data2d);
        
        inputArray(data2d2);
        printArray(data2d2);
        
        System.out.println();
        int[]dups = findDups(data2d, data2d2);
        String comma = "";
        System.out.print("Duplicates: ");
        for(int i =0; i < dups.length; i++)
        {
            System.out.print(comma + dups[i]);
            comma = ",";
        } */
     
        int [] array = join(data, data2);
        String comma = "";
        for(int i =0; i < array.length; i++)
        {
            System.out.print(comma + array[i]);
            comma = ",";
        } 
    }

}
