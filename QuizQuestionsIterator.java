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
 * This is an iterator that moves through MultipleChoiceQuestion(s) in a singly linked list defined
 * by its head.
 */
public class QuizQuestionsIterator extends Object implements Iterator<MultipleChoiceQuestion> {
    private LinkedNode<MultipleChoiceQuestion> next;
    // refers to a node in the singly linked list of MultipleChoiceQuestion

    /**
     * Creates a new QuizQuestionsIterator to start iterating through a singly linked list storing
     * MultipleChoiceQuestion elements
     *
     * @param startNode pointer to the head of the singly linked list
     */
    QuizQuestionsIterator(LinkedNode<MultipleChoiceQuestion> startNode) {
        next = startNode;
    }

    /**
     * Returns true if this iteration has more MultipleChoiceQuestion(s).
     *
     * @return true if there are more MultipleChoiceQuestion(s) in this iteration
     */
    @Override public boolean hasNext() {
        return next != null;
    }

    /**
     * Returns the next MultipleChoiceQuestion in this iteration
     *
     * @return the next MultipleChoiceQuestion in this iteration
     * @throws NoSuchElementException with a descriptive error message if there are no more
     *                                questions in this iteration
     */
    public MultipleChoiceQuestion next() throws NoSuchElementException {
        if (hasNext() == false) {
            throw new NoSuchElementException("no next");
            // if there is no next, NSE exception has to be thrown
        }
        MultipleChoiceQuestion data1 = next.getData();
        next = next.getNext();
        //shifting next
        return data1;
    }
}
