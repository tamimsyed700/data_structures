package com.ts7.app;

import static org.junit.Assert.assertEquals;

import org.apache.log4j.PropertyConfigurator;
import org.junit.Before;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {

    private LinkedList linkedList = new LinkedList();

    static {
        PropertyConfigurator.configure("log4j.properties");
    }

    /**
     * Rigorous Test :-)
     */

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void test_ArrayIndexExceptionForMinusOne() {
        linkedList.get(-1);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void test_ArrayIndexExceptionForThousand() {
        linkedList.get(1000);
    }

    @Test
    public void test_UpdateTextNode() {
        Node updateNode = linkedList.update(2, "Afrin v2");
        assertEquals(updateNode.data, "Afrin v2");
    }

    @Test
    public void checkLinkedListLength() {
        assertEquals(linkedList.length(), 9);
    }

    @Before
    public void setupData() {
        linkedList.insert("Tamim Syed");
        linkedList.insert("Afrin");
        linkedList.insert("Inara");

        linkedList.insert("Siraj Akthar");
        linkedList.insert("Parveen");
        linkedList.insert("Muzammil");

        linkedList.insert("Yusra");
        linkedList.insert("Samrin");
        linkedList.insert("Shakira Amin");
    }

    @Test
    public void test_getElementsByIndex() {
        Node node = linkedList.get(4);
        assertEquals(node.data, "Parveen");
    }

    @Test
    public void test_deleteElementsAtHead() {
        linkedList.delete(0);
        assertEquals(linkedList.length(), 8);
    }

    @Test
    public void test_deleteAllElementsAtHead() {
        linkedList.delete(0);
        linkedList.delete(0);
        linkedList.delete(0);

        linkedList.delete(0);
        linkedList.delete(0);
        linkedList.delete(0);

        linkedList.delete(0);
        linkedList.delete(0);
        linkedList.delete(0);
        
        assertEquals(linkedList.length(), 0);
    }
    
    @Test
    public void test_deleteElementsByIndex() {
        linkedList.delete(1);        
        linkedList.delete(1);  
        linkedList.delete(1);  
        linkedList.delete(1);  
        linkedList.delete(1);  
        linkedList.delete(1);  
        linkedList.delete(1);  
        linkedList.delete(1);  
        assertEquals(linkedList.length(), 1);
    }

    @Test
    public void test_deleteOneByIndex() {
        linkedList.delete(8);        
        assertEquals(linkedList.length(), 8);
    }
}
