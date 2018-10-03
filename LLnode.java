/*
ADDDD NAAAAMMMMEEESSSS!!!!!!!!!!!!!!!!!!!!!
 */
package project1;

/**
 *
 * @author Lenovo-Hanaa
 */
public class LLnode {
    // declare 
    private int data;
    private int weight;
    private LLnode next;
    LinkedList list =null;
    
    
   // create constructors:
    // empty constructor:
    public LLnode() {
        // initialize
        data = 0;
        weight=-1;
        next = null;
    }
    // create constructor for unweighted nodes
    public LLnode(int data, LLnode next) {
        // initialize
        this.data = data;
        this.next = next;
    }
    // create constructor for weighted nodes
      public LLnode(int data, int weight ,LLnode next) {
        // initialize
        this.data = data;
        this.weight= weight;
        this.next = next;
    }
    // getters + setters:
    public int getData() {
        return data;
    }

    public LLnode getNext() {
        return next;
    }

    public void setData(int data) {
        this.data = data;
    }

    public void setNext(LLnode next) {
        this.next = next;
    }
    
     public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
    
    
}// class 
