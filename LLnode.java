/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project1;

/**
 *
 * @author Lenovo-Hanaa
 */
public class LLnode {
    private int data;
    private int weight;
    private LLnode next;
     LinkedList list =null;
    
   
    public LLnode() {
        data = 0;
        weight=-1;
        next = null;
    }
    
    public LLnode(int data) {
        this.data = data;
        next = null;
    }
    
    public LLnode(int data, LLnode next) {
        this.data = data;
        this.next = next;
    }
      public LLnode(int data, int weight ,LLnode next) {
        this.data = data;
        this.weight= weight;
        this.next = next;
    }

   
    public int getData() {
        return data;
    }

    public LLnode getNext() {
        return next;
    }


    // MUTATORS
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
