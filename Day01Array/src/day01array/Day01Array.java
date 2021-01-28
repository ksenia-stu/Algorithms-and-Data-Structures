/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package day01array;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author user
 */
public class Day01Array {

    /**
     * @param args the command line arguments
     */
    public static Scanner scan = new Scanner(System.in);
    
    public static boolean isPrime(int number)
    {
        if(number <= 1)
        {
            return false;
        }
        
            for(int i=2;i<number/2;i++)
            {
                if(number%i == 0)
                {
                    return false;
                }
            }
            return true;
        
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        
        int arraySize = 0;
        System.out.print("Please enter a number greater than 0 for array size: ");
        try
        {
        arraySize = scan.nextInt();
        }
        catch(InputMismatchException ex)
        {
            System.out.print("Input must be numerical");
            return;
        }
        
        if(arraySize <= 0)
        {
            System.out.println("Invalid array size");
            return;
        }
        
        int [] array = new int[arraySize];
        
        //random nums
        for (int i=0; i<array.length; i++ )
        {
            int randomNum = (int)(Math.random()*(101-1))+1;
            array[i] = randomNum;
        }
        
        //display all nums in array
        System.out.println("All numbers in array:");
        for(int i : array)
        {
            System.out.print(i + ",");
        }
        
        //display only prime nums in array
        System.out.println("");
        System.out.println("Prime numbers in array:");
        for(int i : array)
        {
            if(isPrime(i) == true)
            {
                System.out.print(i + ",");
            }
        }
        
    }
    
}
