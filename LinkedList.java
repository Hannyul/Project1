
/*
ADDDD NNAAAAAMMMMMEEEEEESSSS!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

*/
package project1;

/**
 *
 * @author Lenovo-Hanaa
 */
public class LinkedList {

    // declare
    private LLnode head;
    int neighbor;
    int length;

    // create constructor
    public LinkedList() {

        // initialize
        this.head = null;
        this.length = 0;
    }

    // getters + setters
    public LLnode getHead() {
        return head;
    }

    public void setHead(LLnode head) {
        this.head = head;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    // this method inserts a node to the list (unweighted graph) 
    public void insert(int data) {
        head = insert(head, data);
    }

    private LLnode insert(LLnode head, int data) {

        // if the list is empty OR if the node value is less than the head
        // we insert in the beginning
        if (head == null || head.getData() > data) {
            head = new LLnode(data, head);
            return head;
        } else {

            // create a help pointer to traverse down the list
            LLnode helpPtr = head;
            while (helpPtr.getNext() != null) {
                // if the value is less than the node's value, 
                // then exit the while loop because we will insert at the end 
                if (helpPtr.getNext().getData() > data) {
                    break;
                }

                helpPtr = helpPtr.getNext();
            }
            // create new node and insert it at the end of the list
            LLnode newNode = new LLnode(data, helpPtr.getNext());
            helpPtr.setNext(newNode);
        }
        // Return head
        return head;
    }
    // this method inserts a node and its weight to the list (weighted graph) 
    public void insertWeighted(int data, int weight) {
        head = insertWeighted(head, data, weight);
    }

    private LLnode insertWeighted(LLnode head, int data, int weight) {

        // if the list is empty OR if the node value is less than the head
        // we insert in the beginning
        if (head == null || head.getData() > data) {
            head = new LLnode(data, weight, head);
            return head;
        } else {
            // create a help pointer to traverse down the list

            LLnode helpPtr = head;

            while (helpPtr.getNext() != null) {
                // if the value is less than the node's value, 
                // then exit the while loop because we will insert at the end 
                if (helpPtr.getNext().getData() > data) {
                    break;
                }
                helpPtr = helpPtr.getNext();
            }
               // create new node and insert it at the end of the list
            LLnode newNode = new LLnode(data, helpPtr.getNext());
            newNode.setWeight(weight);
            helpPtr.setNext(newNode);
        }
        // Return head
        return head;
    }

    // this method prints the list
    public void PrintList() {
        PrintList(head);
    }

    private void PrintList(LLnode head) {

        LLnode helpPtr = head;

        while (helpPtr != null) {
            // print the data of the helpPtr
            System.out.print(helpPtr.getData() + " ");
            // Step one node over
            helpPtr = helpPtr.getNext();
        }
        System.out.println("");

    }


}// class
