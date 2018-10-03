/*
ADDDDDD NAAAAMMMMMMEEEEEESSSSSSSSSSSSSSSSS!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
*/



package project1;

import java.io.*;

import java.io.FileNotFoundException;

import java.util.*;

public class Project1 {

    // This program reads vertices and their edges 
    // from a text file then generate 3 different 
    // graph representations. 
    // We, the programmers, assume all input files follow the exact same format 
    // as the one given to us on blacboard (graph.txt)
    public static void main(String[] args) throws FileNotFoundException {

        File file = new File("input.txt");

        Scanner inputFile = new Scanner(file);

        // initialize a flag variable with initial value not equal to zero
        int weightFlag = 7;
        // edge = (first,second) numbers
        int first = -1;
        int second = -1;

        // A graph is a set of vertices.
        //  Create an array of vertices to store 
        // graph nodes, edges, and possible weights.
        // the initial graph length is set to zero because 
        // we haven't read the input file yet
        Vertex[] Graph = new Vertex[0];

        // This graph object is used later on to print weighted graphs
        Vertex GraphObj = new Vertex();

        // only for print
        int graphNumber = 1;

        // check if file exists
        if (!file.exists()) {
            System.out.println(" does not exist");
            // end program if it doesn't exit 
            System.exit(0);
        }

        // otherwise, read the file:
        while (inputFile.hasNext()) {
            // read the file line by ine
            String newLine = inputFile.nextLine();
            // the length of each line is used to determine whether it contains: 
            // number of vertices, and THE TYPE (0 unWEIGHTED , 1 WEIGHTED)
            // OR a set of edges
            int length = newLine.length();
            // if length == 4 lines containing vertices and type consits of four characters: EXAMPE (6, 0) it's length is 4
            if (length == 4) {

                // read number of vertices.. EXAMPLE: 6
                char number1 = newLine.charAt(0);

                // Convert it from char to int 
                int GraphLength = Character.getNumericValue(number1);

                // set graph length instead of 0 to the number of vertices 
                Graph = new Vertex[GraphLength];

                // read weight bit and weight here is the last index (3)
                char weighttflg = newLine.charAt(length - 1);
                // convert to int
                weightFlag = Character.getNumericValue(weighttflg);

                // initialize graph
                for (int i = 0; i < Graph.length; i++) {
                    Graph[i] = new Vertex();
                    Graph[i].setValue(i);

                    // each vertex OBJECT in the array has a 
                    // linked list representing its neighbors
                    Graph[i].list = new LinkedList();
                }

            } // FIRST- IF 
            // if the line contains more than four characters, 
            // then it contains a set of edges and possible weights
            else if (newLine.length() > 4) {

                // create new scanner to READ Character by character 
                Scanner input = new Scanner(newLine);

                while (input.hasNext()) {

                    // UNweighted 
                    if (weightFlag == 0) {

                        // the edges are given in pairs (0,2) with 
                        // no whitespaces inbetween. 
                        // the scanner reads each pair as a string
                        String s = input.next();

                        // index 0 will tell the first number
                        // index 1 is the comma 
                        // index 2 is the second number
                        char firstNumber = s.charAt(0);
                        char secondNumber = s.charAt(2);

                        // convert them to int
                        first = Character.getNumericValue(firstNumber);
                        second = Character.getNumericValue(secondNumber);

                        // set the values 
                        GraphObj.setweighted(false);
                        GraphObj.setweight(0);

                        for (int i = 0; i < Graph.length; i++) {

                            // Example : (0,2) first we will find 0 in the ARRAY
                            // then will make 2 the first neighbor to it's linkedList
                            if (i == first) {

                                Graph[i].list.insert(second);
                            }
                        }
                    } // if-UNweighted 
                    // Weighted Case 
                    else if (weightFlag == 1) {

                        String s = input.next();
                        char firstNumber = s.charAt(0);
                        char secondNumber = s.charAt(2);

                        first = Character.getNumericValue(firstNumber);
                        second = Character.getNumericValue(secondNumber);
                        int weight = input.nextInt();

                        GraphObj.setweighted(true);
                        GraphObj.setweight(1);

                        for (int i = 0; i < Graph.length; i++) {
                            // Example : (0,2 10) first we will find 0 in the ARRAY
                            // then will make 2 the first neighbor to it's linkedList and insert it's weight within the neighbor
                            if (i == first) {
                                Graph[i].list.insertWeighted(second, weight);
                            }
                        }

                    } // if- Weighted
                    // if read line is null: (The String reaches the END)
                    else if (input.next() == null) {
                        input.close();
                    }

                } //WHILE - Character by character scanner has next
            }// else if new line
            // we TEST all the possible cases, so the last case we are in NEW EMPTY LINE 
            // so simply REset the graphs and all the values. 
            else {

                for (int i = 0; i < Graph.length; i++) {
                    Graph[i] = new Vertex();
                    Graph[i].setValue(i);
                    GraphObj.setweight(-1);
                    Graph[i].list = new LinkedList();
                }

                // THIS variable is just helping us for printing how many graphs in our Code.
                graphNumber += 1;

            }

            // only print the graph if weight is 0 or 1 not -1
            if (GraphObj.getweight() != -1) {
                // ***************Representations******************* 

                System.out.println("\n\n\n\n __________________________________________________________________________________\n"
                        + "|                                                                                  |\n"
                        + "|                                    Graph # " + graphNumber + "                                     |\n"
                        + "|__________________________________________________________________________________|\n"
                        + "\n\n\n");

                // first representation "Linked List"
                System.out.print("      __________________________________________________________________\n"
                        + "     |                                                                  |\n"
                        + "     |                  Data Structure #1: Linked list                  |\n"
                        + "     |__________________________________________________________________|\n\n\n");
                PrinLinkedList(Graph, GraphObj);
                System.out.println("\n\n");

                // Second representation "Matrix"
                System.out.print("      __________________________________________________________________\n"
                        + "     |                                                                  |\n"
                        + "     |            Data Structure #2: Adjacency Matrix                   |\n"
                        + "     |__________________________________________________________________|\n\n\n\n\n\n");

                PrinMatrix(Graph, GraphObj);
                System.out.println("\n\n\n\n\n");

                // third representation "Matrix with symbols ? and *"
                System.out.print("      __________________________________________________________________\n"
                        + "     |                                                                  |\n"
                        + "     |                  Data Structure #3: Symbol box                   |\n"
                        + "     |__________________________________________________________________|\n\n\n");

                PrintSymbolBox(Graph, GraphObj);

            } // IF- PRINTING 

        } // BIG - WHILE

        System.out.println("");

    }// main

    // method to display the graph as a linked list:
    public static void PrinLinkedList(Vertex[] Graph, Vertex GraphObj) {

        // traverse all nodes in graph
        for (int i = 0; i < Graph.length; i++) {

            // to travers on each node's LinkedList 
            // (that contains all its neighboring vertices)
            LLnode pointer = Graph[i].getList().getHead();

            // travers Sequentinally along the Graph Array 
            if (i == Graph[i].getValue()) {

                // to make sure the Graph Weight has a Value (0 or 1) AND
                // if GraphObj.getweighted() is true THEN IT'S WEIGHTED
                if (GraphObj.getweighted() && GraphObj.getweight() != -1) {

                    System.out.print("\t\t\t" + i + " --> ");

                    while (pointer != null) {

                        // simply print the Vertices and it's weight
                        System.out.print("(" + pointer.getData() + "," + pointer.getWeight() + ")");
                        // travers to the next NODE
                        pointer = pointer.getNext();

                    }

                    System.out.println("");
                } // to make sure the Graph Weight has a Value (0 or 1) AND
                // if GraphObj.getweighted() is FALSE THEN IT'S UNWEIGHTED
                else if (!GraphObj.getweighted() && GraphObj.getweight() != -1) {

                    System.out.print("\t\t\t" + i + " --> ");
                    Graph[i].list.PrintList();

                }

            }//IF-MATCHES
        } // for

    } // METHOD 1

    // method to display the graph as a matrix:
    public static void PrinMatrix(Vertex[] Graph, Vertex GraphObj) {

        /*
        
        Each graph node has a linked list attached to it that stores 
        the values of all its neighboring nodes. 
       
        
        How this method works:
        
        For each graph node, traverse down its linked list and compare each 
        adjacent node to every node in the graph. 
        
        So, for example, graph node 0 has linked list nodes 2 and 4. 
        This method traverses down  0's linked list (2,4) 
        and makes the following comparisons:
        linked list node 2 with graph node 0 -> not equal 
        linked list node 2 with graph node 1 -> not equal
        linked list node 2 with graph node 2 -> equal:
        
        save current for loop index to start at index 3 on the next iteration
        set boolean variable to true
        exit for loop 
        print 1 (IF UNWEIGHTED) OR 2's weight (IF WEIGHTED)
        traverse the list (set helppointer (which is pointed at 2) to helppointer.next)
        
         (All linked list nodes are inserted in ascending order.
        so, logically, if graph node 0 has another neighboer besides 2, 
        it will be greater than 2
        so there is no need to traverse 0's linked list 
        OR loop the graph array from the beginning all over again)
     
        
        start at index 3
        compare linked list node 4 with graph node 3 -> not equal 
        compare linked list node 4 with graph node 4 -> equal   
        save current for loop index to start at index 5 on the next iteration
        set boolean variable to true
        exit for loop 
        print 1 (IF UNWEIGHTED) OR 2's weight (IF WEIGHTED)
        traverse the list (set helppointer (which is pointed at 4) to helppointer.next)

        helppointer is null, exit while loop
        check if there are any graph nodes left that were not compared. 
        In this case, only node 5 was not reached. 
        So we print a zero at the fifth column.
        
        
         */
        System.out.print("\t\t");

        //Print all nodes as a row
        for (int i = 0; i < Graph.length; i++) {
            System.out.print("\t" + Graph[i].value);
        }
        System.out.println("\n\t\t____________________________________________________");

        // print columns And do Other Jobs 
        for (int i = 0; i < Graph.length; i++) {

            System.out.print("\n\t\t" + Graph[i].value + "  |");

            LLnode hlpptr = Graph[i].getList().getHead();

            // this boolean variable is used to determine 
            // whether the values compared
            // are equal or not and will be used for the program to decide what 
            // to print
            boolean equals = false;

            // we use this variable (indx) to store the index just after the 
            // last iteration the for loop stopped at.
            int indx = 0;
            while (hlpptr != null) {
                // read linked list node value
                int data = hlpptr.getData();
                // comparison for loop. 
                for (int j = indx; j < Graph.length; j++) {
                    // read graph node value
                    int arrayValue = Graph[j].value;

                    // if the two values are equal, that indicates they're adjacent. 
                    if (data == arrayValue) {
                        // since they're adjacent, we want to print "1" or the weight, 
                        // so we set equals to true
                        equals = true;
                        // we save the index we stopped at
                        indx = j + 1;
                        // and exit the for loop to move on to the next node 
                        // + to print once only not for the entire length of the array
                        break;
                    } else {
                        System.out.print("\t0");
                    }
                } // for loop
                // if the two numbers are equal, then do one of two things:
                // print the weight OR print 1
                if (equals) {
                    // check if the graph is weighted
                    if (GraphObj.getweight() != 0) {
                        // if it is, print the weight
                        System.out.print("\t" + hlpptr.getWeight());
                    } // otherwise, print 1
                    else {
                        System.out.print("\t1");
                    }
                }
                // reset
                equals = false;
                // point to next neighboring node
                hlpptr = hlpptr.getNext();
            }
            // if we reached the end of the graph array
            // BUT the linked list 
            // we enter this block of code when the last adjacent vertex is less than 
            // the last graph vertex
            // i.e.: 
            // 0 --> 2,4. 
            // When the program reaches 4, it will exit the for loop.
            // This block of code prints zeros after 4 (so at column 5)
            // 5 --> 1,2,3 
            // When the program reaches 3, it will exit the for loop.
            // This block of code prints zeros after 3 (so at columns 4 and 5)
            if (indx < Graph.length) {
                for (int j = indx; j < Graph.length; j++) {
                    System.out.print("\t0");

                }
            }

        } // graph 
    } // METHOD 2 

    //*****************************************************
    public static void PrintSymbolBox(Vertex[] Graph, Vertex GraphObj) {
        // just print rows 
        System.out.print("\t\t ____________________________________________________\n\t\t|                                                    |\n\t\t|");
        for (int i = 0; i < Graph.length; i++) {
            System.out.print("\t" + Graph[i].value);
        }

        System.out.println("    |\n\t\t|____________________________________________________|");

        // column
        for (int i = 0; i < Graph.length; i++) {
            // print the column and execute 
            System.out.print("\n\t\t" + Graph[i].value + "  |");

            // for each node in the graph give me the biggening of its list 
            LLnode hlpptr = Graph[i].getList().getHead();

            // is a variable to decide "is the Data in LinkedList EQUALS the array values?" 
            boolean equals = false;
            int indx = 0;

            // we will travers along the list untill the help pointer become null 
            while (hlpptr != null) {
                // Each list has it's own data
                int data = hlpptr.getData();

                for (int j = indx; j < Graph.length; j++) {
                    // will travers in the Graph array values sequentinally 
                    int arrayValue = Graph[j].value;
                    // is the data of LinkedList == the Data in the Array? 
                    if (data == arrayValue) {

                        equals = true;
                        // to start from the upcoming index not zero 
                        indx = j + 1;
                        break;
                    } else {
                        // then they're not neighbors 
                        System.out.print("\t?");
                    }

                } // for 
                // as long as Equals is true, that's mean they're neighbors 
                if (equals) {
                    // Check if Graph is Weighted or Unweighted 
                    if (GraphObj.getweight() != 0) {
                        System.out.print("\t" + hlpptr.getWeight());
                    } else {
                        System.out.print("\t*");
                    }
                }
                equals = false;
                hlpptr = hlpptr.getNext();

            } // while 

            // do the other iterations
            // and while the equals is not true we already know it is not neighbor 
            if (indx < Graph.length) {

                for (int j = indx; j < Graph.length; j++) {
                    System.out.print("\t?");

                }
            } // if index > than the length of the graph 

        } // big for 

    } // METHOD 3 

}
