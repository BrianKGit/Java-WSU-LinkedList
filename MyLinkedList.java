/*
 * Author:      Brian Klein
 * Date:        11/13/17
 * Program:     MyLinkedList.java
 * Description: Add a tail reference to the linked list. The tail reference 
                always refer to the last node. The following methods should be 
                included: addFirst – Add a new node as the first node of the 
                linked list. removeFirst – Remove the first node of the linked 
                list and return it. addLast - Add a new node as the last node 
                of the linked list. The new node should be added at the tail 
                reference. Do not traverse the linked list. selectionSort – Sort
                the linked list in ascending order. search – Search the linked 
                list for a particular element and return true or false. traverse
                – Return all the nodes in the linked list.
 */
public class MyLinkedList<E extends Comparable> {

    //<E extends Comparable<E> >
    // It means that MyLinkedList works with generic comparable objects
    //data members
    private Node<E> head;
    private Node<E> tail;
    private int size;

    //constructor
    public MyLinkedList() {

        head = null;
        tail = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    //ask jim about throwing exceptions here.
    public boolean isEmpty() {
        if (head == null) {
            return true;
        }

        return false;
    }

    //add new node as the first node
    public void addFirst(E element) {

        //step 1 - create a new node for the element
        Node<E> temp = new Node<E>(element, null);

        if (isEmpty()) {
            head = temp;
            tail = temp;
        } else {
            temp.setNext(head); // step 2 - temp.next = head
            head = temp; // step 3
        }

        size++;
    }

    //remove the first node and return the element
    public E removeFirst() throws EmptyListException {

        if (isEmpty()) {
            throw new EmptyListException("The list is empty.");
        }

        Node<E> temp = head; //step 1

        head = head.getNext(); //step 2 - head = head.next

        temp.setNext(null); //step 3 - temp.next = null

        E element = temp.getElement(); //step 4

        size--;

        //if size is 0, change tail to null
        if(size == 0) {
            tail = null;
        }
        temp = null;

        return element;

    }

    //add new node as the last node
    public void addLast(E element) {

        //step 1 - create a new node for the element
        Node<E> temp = new Node<E>(element, null);

        if (isEmpty()) {
            head = temp;
            tail = temp;
        } else {
            tail.setNext(temp); // step 2 - temp.next = head
            tail = temp; // step 3
        }

        size++;
        //this method is part of assignment 6
        //use the tail reference to add it
        //do not traverse the list
    }

    //search an element (generic object) in the list
    public boolean search(E searched) {

        selectionSort();
        
        boolean found = false;
        Node<E> temp = head;

        if (isEmpty() == true) {
            return found;
        } else {
            while (temp != null && found != true) {
                if (temp.getElement().compareTo(searched) == 0) {
                    found = true;
                } else {
                    temp = temp.getNext();
                    found = false;
                }
            }
        }
        return found;

        //this is part of assignment 6
        //it searches the list and return true if found
        //the searched object must be a Comparable object
    }

    //use selection sort to sort the linked list
    public void selectionSort() throws EmptyListException {

        if (isEmpty()) {
            throw new EmptyListException("The list is empty.");
        }
        
        Node<E> minNode, tempHead, tempHeadNext;
        E temp;

        tempHead = head;
        tempHeadNext = head.getNext();

        for (int x = 0; x < size - 1; x++) {//outer loop

            minNode = tempHead;

            for (int i = x + 1; i < size; i++) {//inner loop

                if (tempHeadNext.getElement().compareTo(minNode.getElement()) < 0) {
                    minNode = tempHeadNext;

                }//end if

                tempHeadNext = tempHeadNext.getNext(); //move it to the next node

            }//end inner loop

            //swap
            temp = tempHead.getElement();
            tempHead.setElement(minNode.getElement()); //list[x] = list[minIndex];
            minNode.setElement(temp); //list[minIndex] = temp;

            tempHead = tempHead.getNext();
            tempHeadNext = tempHead.getNext();

        }//end outer loop

    }

    //traverse the list
    public String traverse() throws EmptyListException {

        if (isEmpty()) {
            throw new EmptyListException("The list is empty.");
        }

        Node<E> temp = head;

        String result = "\nHead -->";

        int i = size;

        while (i > 0) {

            result += temp.getElement() + "\n-->";

            temp = temp.getNext(); //temp = temp.next;

            i--;
        }//end while

        return result;

    }//end traverse

    //remove the second node and return the element
    public E removeSecond() throws EmptyListException {

        if (size < 2) {
            throw new EmptyListException("The list has less than two nodes.");
        }

        Node<E> temp = head.getNext(); //temp refers to the second node

        //move head to the third node
        head.setNext(temp.getNext());

        //retrieve the element of temp node
        E result = temp.getElement();

        temp.setNext(null);

        temp = null;

        size--;

        return result;

    }

}//end of class

