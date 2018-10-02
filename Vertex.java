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
public class Vertex {

    int value;
    LinkedList list;
    boolean weighted;
    int weight;
    
    
     public Vertex() {
         this.weight = -1;
    }

    public Vertex(int value, LinkedList list) {
        this.value = value;
        this.list = list;
    }


    public boolean isWeighted() {
        return weighted;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public LinkedList getList() {
        return list;
    }

    public void setList(LinkedList list) {
        this.list = list;
    }

    
     public boolean getweighted() {
        return weighted;
    }

    public void setweighted(boolean weighted) {
        this.weighted = weighted;
    }
   
    
     public int getweight() {
        return weight;
    }

    public void setweight(int weight) {
        this.weight = weight;
    }
}
