package com.ts7.app;

import org.apache.log4j.Logger;
/**
 * This class is the custom implementation of the Linked List data structure.
 * @author Tamim Syed
 * 
 */
class LinkedList {
    
    private Logger LOG = Logger.getLogger(LinkedList.class);
    private int length;

    private Node head;

    private Node currentNode;

    /**
     * This API will inser the node into the Node data structure.
     * 
     * @param data
     */
    public void insert(final String data) {
        LOG.trace("******************************************************************************");
        LOG.trace("Adding the Data to the Linked List "+data);
        if (head==null){
            head = new Node();
            head.data=data;
            currentNode = head;
            head.next = currentNode.next;
            length++;
        }
        else{
            if (currentNode!=null)
            {
                Node insertNode = new Node();
                insertNode.data=data;
                currentNode.next=insertNode;
                currentNode=insertNode;
                length++;
            }
        }
        LOG.trace("\n\n******************************************************************************");
    }

    /**
     * This API will get the element based on the index.
     * 
     * @param index
     * @return
     */
    public Node get(final int index) throws ArrayIndexOutOfBoundsException {
        Node currentNode = head;
        int count=0;
        if (index>length || index<0) 
        throw new ArrayIndexOutOfBoundsException("Index should be always less then the length of the Linked List and above zero");
      
        if (index==0){
            currentNode=head;
        }
        else{
            while(currentNode!=null){
                count++;
                currentNode=currentNode.next;
                if (count==index)
                break;
            }
        }
        return currentNode;
    }

    public void delete(final int index) {
        Node currentNode = head;
        Node previousNode = null;
        int count=0;
        if (index>length || index<0) 
        throw new ArrayIndexOutOfBoundsException("Index should be always less then the length of the Linked List and above zero");
      
        if (index==0){
            head=head.next;
            length--;
        }
        else{
            while(currentNode!=null){
                count++;
                previousNode = currentNode;
                currentNode=currentNode.next;
                LOG.info("Previous node "+previousNode.data+" current node "+currentNode.data);
                if (count==index){
                    previousNode.next=currentNode.next;
                    length--;
                }
                break;
            }
        }
    }

    public Node update(final int index, String data){
        if (index>length || index<0) 
            throw new ArrayIndexOutOfBoundsException("Index should be always less then the length of the Linked List and above zero");
    
       Node node = get(index);
       if (node!=null)
           node.data=data;
        return node;
    }

    public void display() {
        Node currentNode = head;
        if (head.next==null){
            LOG.trace("Element is "+head.data);
        }
        else{
            while(currentNode!=null){
                LOG.trace(currentNode.data+" --> ");
                currentNode=currentNode.next;
            }
        }
    }

    public int search(final String data) {
        return 0;
    }

    /**
     * This Node will get whether the linked list is empty or not.
     * @return
     */
    public boolean isEmpty() {
        return (head==null);
    }

    /**
     * This API will return the length of the Linked List.
     * 
     * @return
     */
    public int length(){
        return this.length;
    }
}

class Node {
    String data;
    Node next;

    @Override
    public String toString() {
        return "Node [data=" + data + ", next=" + next + "]";
    }

}