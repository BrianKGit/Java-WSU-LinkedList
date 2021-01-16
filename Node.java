/*
 * Author:      Brian Klein
 * Date:        11/13/17
 * Program:     Node.java
 * Description: Generic node object class for MyLinkedList
 */

public class Node<E> {

    //data members
    private E element;
    private Node<E> next;

    //constructors
    public Node() {
        this(null, null);
    }

    public Node(E element, Node<E> next) {
        this.element = element;
        this.next = next;
    }

    //setters and getters
    public void setElement(E element) {
        this.element = element;
    }

    public E getElement() {
        return element;
    }

    public void setNext(Node<E> next) {
        this.next = next;
    }

    public Node<E> getNext() {
        return next;
    }

}
