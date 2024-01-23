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
 * Implements an iterator to iterate over incorrectly answered MultipleChoiceQuestion(s) stored in a singly linked list defined by its head.
 */
public class IncorrectQuestionsIterator extends Object implements Iterator<MultipleChoiceQuestion> {
    private LinkedNode<MultipleChoiceQuestion> next;
    //refers to a node in the singly linked list of MultipleChoiceQuestions

    /**
     * Creates a new InCorrectQuestionsIterator to start iterating through a singly linked list
     * storing MultipleChoiceQuestion elements
     *
     * @param startNode pointer to the head of the singly linked list
     */
    public IncorrectQuestionsIterator(LinkedNode<MultipleChoiceQuestion> startNode) {
        next = startNode;
        while (next != null) {
            if (!next.getData().isCorrect()) {
                return;
                //return correct data
            }
            next = next.getNext();
            //update next
        }
    }

    /**
     * Returns true if this iteration has more MultipleChoiceQuestion(s) answered incorrectly.
     *
     * @return true if there are more incorrect MultipleChoiceQuestion(s) in this iteration
     */
    @Override public boolean hasNext() {
        return next != null;
        //checks next is not null
    }

    /**
     * Returns the next incorrect MultipleChoiceQuestion in this iteration
     *
     * @return the next incorrect MultipleChoiceQuestion in this iteration
     * @throws NoSuchElementException with a descriptive error message if there are no more
     *                                incorrect questions in this iteration
     */
    @Override public MultipleChoiceQuestion next() throws NoSuchElementException {
        if (!hasNext()) {
            throw new NoSuchElementException("no next");
            //NSE for empty
        }
        MultipleChoiceQuestion data1 = next.getData();
        while (next.getNext() != null) {
            next = next.getNext();
            if (!next.getData().isCorrect()) {
                return data1;
                //return correct stuff
            }
        }

        this.next = null;
        return data1;
    }
}
