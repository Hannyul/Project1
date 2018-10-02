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
public class LinkedList {

    private LLnode head;
    int neighbor;
    int length;

    public LinkedList() {

        this.head = null;
        this.length = 0;
    }

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

    public boolean isEmpty() {
        return head == null;
    }

    public int getNeighbors(int data) {
        return getNeighbors(head, data);
    }

    private int getNeighbors(LLnode p, int data) {
        LLnode helpPtr = p;
        while (helpPtr != null) {
            if (helpPtr.getData() == data) {
                return helpPtr.getData();
            }
            helpPtr = helpPtr.getNext();
        }
        return 0;
    }

    public void insert(int data) {
        head = insert(head, data);
    }

    private LLnode insert(LLnode head, int data) {

        if (head == null || head.getData() > data) {
            head = new LLnode(data, head);
            return head;
        } else {

            LLnode helpPtr = head;

            while (helpPtr.getNext() != null) {

                if (helpPtr.getNext().getData() > data) {
                    break;
                }

                helpPtr = helpPtr.getNext();
            }

            LLnode newNode = new LLnode(data, helpPtr.getNext());
            helpPtr.setNext(newNode);
        }
        // Return head
        return head;
    }

    public void insertWeighted(int data, int weight) {
        head = insertWeighted(head, data, weight);
    }

    private LLnode insertWeighted(LLnode head, int data, int weight) {

        if (head == null || head.getData() > data) {
            head = new LLnode(data, weight, head);
            return head;
        } else {

            LLnode helpPtr = head;

            while (helpPtr.getNext() != null) {

                if (helpPtr.getNext().getData() > data) {
                    break;
                }
                helpPtr = helpPtr.getNext();
            }

            LLnode newNode = new LLnode(data, helpPtr.getNext());
            newNode.setWeight(weight);
            helpPtr.setNext(newNode);
        }
        // Return head
        return head;
    }

    public void PrintList() {
        PrintList(head);
    }

    private void PrintList(LLnode head) {

        LLnode helpPtr = head;

        while (helpPtr != null) {

            System.out.print(helpPtr.getData() + " ");
            // Step one node over
            helpPtr = helpPtr.getNext();
        }
        System.out.println("");

    }

    public void delete() {
        head = null;
    }

}// class
