/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package day03arraylistownimpl;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author user
 */
public class CustomArrayOfIntsTest {
    
    public CustomArrayOfIntsTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of size method, of class CustomArrayOfInts.
     */
    @Test
    public void testSize() {
        System.out.println("size");
        CustomArrayOfInts instance = new CustomArrayOfInts();
        int expResult = 0;
        int result = instance.size();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
      //  fail("The test case is a prototype.");
    }

    /**
     * Test of add method, of class CustomArrayOfInts.
     */
    @Test
    public void testAdd() {
        System.out.println("add");
        int value = 0;
        CustomArrayOfInts instance = new CustomArrayOfInts();
        instance.add(value);
        // TODO review the generated test code and remove the default call to fail.
      //  fail("The test case is a prototype.");
    }

    /**
     * Test of deleteByIndex method, of class CustomArrayOfInts.
     */
    @Test
    public void testDeleteByIndex() {
        System.out.println("deleteByIndex");
        int index = 0;
        CustomArrayOfInts instance = new CustomArrayOfInts();
        instance.deleteByIndex(index);
        // TODO review the generated test code and remove the default call to fail.
      //  fail("The test case is a prototype.");
    }

    /**
     * Test of deleteByValue method, of class CustomArrayOfInts.
     */
    @Test
    public void testDeleteByValue() {
        System.out.println("deleteByValue");
        int value = 0;
        CustomArrayOfInts instance = new CustomArrayOfInts();
        boolean expResult = false;
        boolean result = instance.deleteByValue(value);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
      //  fail("The test case is a prototype.");
    }

    /**
     * Test of insertValueAtIndex method, of class CustomArrayOfInts.
     */
    @Test
    public void testInsertValueAtIndex() {
        System.out.println("insertValueAtIndex");
        int value = 0;
        int index = 0;
        CustomArrayOfInts instance = new CustomArrayOfInts();
        instance.insertValueAtIndex(value, index);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    /**
     * Test of clear method, of class CustomArrayOfInts.
     */
    @Test
    public void testClear() {
        System.out.println("clear");
        CustomArrayOfInts instance = new CustomArrayOfInts();
        instance.clear();
        // TODO review the generated test code and remove the default call to fail.
      //  fail("The test case is a prototype.");
    }

    /**
     * Test of get method, of class CustomArrayOfInts.
     */
    @Test
    public void testGet() {
        System.out.println("get");
        int index = 0;
        CustomArrayOfInts instance = new CustomArrayOfInts();
        int expResult = 0;
        int result = instance.get(index);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
      //  fail("The test case is a prototype.");
    }

    /**
     * Test of getSlice method, of class CustomArrayOfInts.
     */
    @Test
    public void testGetSlice() {
        System.out.println("getSlice");
        int startIdx = 0;
        int length = 0;
        CustomArrayOfInts instance = new CustomArrayOfInts();
        int[] expResult = null;
        int[] result = instance.getSlice(startIdx, length);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
      //  fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class CustomArrayOfInts.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        CustomArrayOfInts instance = new CustomArrayOfInts();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
      //  fail("The test case is a prototype.");
    }
    
}
