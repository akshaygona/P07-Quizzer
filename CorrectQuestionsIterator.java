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
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Implements an iterator to iterate over correctly answered MultipleChoiceQuestion(s) stored in a
 * singly linked list defined by its head.
 */
public class CorrectQuestionsIterator extends Object implements Iterator<MultipleChoiceQuestion> {
    private LinkedNode<MultipleChoiceQuestion> next;
    //refers to a node in the singly linked list of MultipleChoiceQuestion to traverse

    /**
     * Creates a new CorrectQuestionsIterator to start iterating through a singly linked list
     * storing MultipleChoiceQuestion elements
     *
     * @param startNode - pointer to the head of the singly linked list
     */
    public CorrectQuestionsIterator(LinkedNode<MultipleChoiceQuestion> startNode) {
        next = startNode;
        while (next != null) {
            if (next.getData().isCorrect()) {
                //checking if the next question is correct
                return;
            }
            next = next.getNext();
            //shifting to next
        }
    }

    /**
     * Returns true if this iteration has more MultipleChoiceQuestion(s) answered correctly.
     *
     * @return true if there are more correct MultipleChoiceQuestion(s) in this iteration
     */
    @Override public boolean hasNext() {
        return next != null;
    }

    /**
     * Returns the next correct MultipleChoiceQuestion in this iteration
     *
     * @return the next correct MultipleChoiceQuestion in this iteration
     * @throws NoSuchElementException with a descriptive error message if there are no more correct questions in this iteration
     */
    @Override public MultipleChoiceQuestion next() throws NoSuchElementException {
        if (!hasNext()) {
            throw new NoSuchElementException("no next");
            // throws NSE if has next is false
        }
        MultipleChoiceQuestion data1 = next.getData();
        while (next.getNext() != null) {
            next = next.getNext();
            if (next.getData().isCorrect()) {
                //checks if the question is correct
                return data1;
            }
        }

        this.next = null;
        return data1;
    }
}
