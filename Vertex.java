/*
N A  M E S !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
 */
package project1;

/**
 *
 * @author Lenovo-Hanaa
 */
public class Vertex {
// declare
    int value;
    LinkedList list;
    boolean weighted;
    int weight;
    
    // empty constructor
     public Vertex() {
         // initialize
         this.weight = -1;
    }

    // this method determines whether the graph is weighted or not
    public boolean isWeighted() {
        return weighted;
    }
    // getters + setters
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
    // this method determines whether the graph is weighted or not (true or false)
     public boolean getweighted() {
        return weighted;
    }

    // this method sets whether the graph is weighted or not (true or false)
    public void setweighted(boolean weighted) {
        this.weighted = weighted;
    }
   
    // this method returns the weight
     public int getweight() {
        return weight;
    }

    // this method sets the weight
    public void setweight(int weight) {
        this.weight = weight;
    }
}
