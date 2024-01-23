//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:   p07 Quizzer
// Course:   CS 300 Fall 2022
//
// Author:   Akshay Gona
// Email:    gona@wisc.edu
// Lecturer: Hobbes LeGault

///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
// Persons:   Rishit Patil, Varun Munagala, helped debug code
// Online Sources:  youtube, stackoverflow, javadocs, oracle community
//
///////////////////////////////////////////////////////////////////////////////


/**
 * An instance of this class represents a single node within a singly linked list.
 *
 * @param <T>
 */
public class LinkedNode<T> extends Object {
    private final T data;
    //data carried by this linked node
    private LinkedNode<T> next;
    //reference to the next linked node

    /**
     * Constructs a new node with the provided information.
     *
     * @param data to be stored within this node
     * @param next node, which comes after this node in a singly linked list
     * @throws NullPointerException with a descriptive error message if data is null
     */
    public LinkedNode(T data, LinkedNode<T> next) throws NullPointerException {
        if (data == null) {
            throw new NullPointerException("data is null");
        }
        this.data = data;
        this.next = next;
    }

    /**
     * Constructs a new node with a specific data and NO next node in the list.
     *
     * @param data to be stored within this node
     */
    public LinkedNode(T data) throws NullPointerException {
        if (data == null) {
            throw new NullPointerException("data is null");
        }
        this.data = data;
    }

    /**
     * Accessor method for this node's next node reference.
     *
     * @return the next reference to the node that comes after this one in the list, or null when
     * this is the last node in that list
     */
    public LinkedNode<T> getNext() {
        return this.next;
    }

    /**
     * Mutator method for this node's next node reference.
     *
     * @param next node, which comes after this node in a singly linked list
     */
    public void setNext(LinkedNode<T> next) {
        this.next = next;
    }

    /**
     * Accessor method for this node's data.
     *
     * @return the data stored within this node.
     */
    public T getData() {
        return this.data;
    }

    /**
     * Returns a string representation of this linked node formatted as follows:
     * <p>
     * data.toString() if this node does NOT have a next node in the list
     * data.toString() + "->" if this node has a next node in the list
     *
     * @return a String representation of this node in the list
     */
    @Override public String toString() {
        if (this.next == null) {
            return this.data.toString();
        }
        return this.data.toString() + "->";
    }
}
