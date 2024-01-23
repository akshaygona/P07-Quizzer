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
import java.util.ArrayList;

/**
 * This class checks the correctness of the implementation of p07 Quizzer
 */
public class QuizzerTester {
    /**
     * main method
     *
     * @param args list of input arguments if any
     */
    public static void main(String[] args) {
        runAllTests();
    }

    /**
     * Runs all the tester methods defined in this QuizzerTester
     *
     * @return true if all tests pass and false if any of the tests fails
     */
    public static boolean runAllTests() {

        return true;
    }

    /**
     * This method test and make use of the MultipleChoiceQuestion constructor, an accessor
     * (getter) method, overridden method toString() and equal() method defined in the
     * MultipleChoiceQuestion class.
     *
     * @return true when this test verifies a correct functionality, and false otherwise
     */
    public static boolean testMultipleChoiceQuestion() {

        return true;
    }

    /**
     * This method test and make use of the LinkedNode constructor, an accessor (getter) method,
     * and a mutator (setter) method defined in the LinkedNode class.
     *
     * @return true when this test verifies a correct functionality, and false otherwise
     */
    public static boolean testLinkedNode() {
        //tester for constructor
        try {
            LinkedNode<String> q = new LinkedNode<String>(null);
            System.out.println("NPE expected");
            return false;
        } catch (NullPointerException e) {
        } catch (Exception e) {
            System.out.println("NPE expected");
            return false;
        }
        {
            // tester for getters
            LinkedNode<Integer> test1 = new LinkedNode<>(5);
            if (!test1.getData().equals(5)) {
                System.out.println("getData is wrong");
                return false;
            }
            // tester for setters
            LinkedNode<Integer> test2 = new LinkedNode<>(2);
            test1.setNext(test2);
            if (test1.getNext() != test2) {
                System.out.println("getNext is wrong");
                return false;
            }
        }
        return true;
    }

    /**
     * This method checks for the correctness of CorrectQuestionsIterator class
     *
     * @return true when this test verifies a correct functionality, and false otherwise
     */
    public static boolean testCorrectQuestionsIterator() {
        ListQuizzer listQuizzer = new ListQuizzer();
        listQuizzer.switchMode(ListingMode.CORRECT);
        MultipleChoiceQuestion question1 =
            new MultipleChoiceQuestion("1", "a", new String[69], 1, 1000);
        MultipleChoiceQuestion question2 =
            new MultipleChoiceQuestion("2", "b", new String[69], 1, 1000);
        MultipleChoiceQuestion question3 =
            new MultipleChoiceQuestion("3", "c", new String[69], 1, 1000);
        MultipleChoiceQuestion question4 =
            new MultipleChoiceQuestion("4", "d", new String[69], 1, 1000);
        listQuizzer.addLast(question1);
        listQuizzer.addLast(question2);
        listQuizzer.addLast(question3);
        listQuizzer.addLast(question4);

        question1.setStudentAnswerIndex(1);
        question2.setStudentAnswerIndex(1);

        ArrayList<MultipleChoiceQuestion> expectedOutput = new ArrayList<>();
        expectedOutput.add(question1);
        expectedOutput.add(question2);

        try {
            ArrayList<MultipleChoiceQuestion> temp = new ArrayList<>();
            for (MultipleChoiceQuestion x : listQuizzer)
                temp.add(x);
            if (!expectedOutput.containsAll(temp) || !temp.containsAll(expectedOutput)) {
                System.out.println("correctQuestionsIterator fails");
                return false;
            }
        } catch (Exception e) {
            System.out.println("correctQuestionsIterator fails");
            return false;
        }
        return true;
    }

    /**
     * This method checks for the correctness of IncorrectQuestionsIterator class
     *
     * @return true when this test verifies a correct functionality, and false otherwise
     */
    public static boolean testInCorrectQuestionsIterator() {
        ListQuizzer listQuizzer = new ListQuizzer();
        listQuizzer.switchMode(ListingMode.INCORRECT);
        MultipleChoiceQuestion question1 =
            new MultipleChoiceQuestion("1", "a", new String[69], 1, 1000);
        MultipleChoiceQuestion question2 =
            new MultipleChoiceQuestion("2", "b", new String[69], 1, 1000);
        MultipleChoiceQuestion question3 =
            new MultipleChoiceQuestion("3", "c", new String[69], 1, 1000);
        MultipleChoiceQuestion question4 =
            new MultipleChoiceQuestion("4", "d", new String[69], 1, 1000);
        listQuizzer.addLast(question1);
        listQuizzer.addLast(question2);
        listQuizzer.addLast(question3);
        listQuizzer.addLast(question4);

        question1.setStudentAnswerIndex(3);
        question2.setStudentAnswerIndex(3);

        ArrayList<MultipleChoiceQuestion> expectedOutput = new ArrayList<>();
        expectedOutput.add(question1);
        expectedOutput.add(question2);

        try {
            ArrayList<MultipleChoiceQuestion> temp = new ArrayList<>();
            for (MultipleChoiceQuestion x : listQuizzer)
                temp.add(x);
            if (!expectedOutput.containsAll(temp) || !temp.containsAll(expectedOutput)) {
                System.out.println("IncorrectQuestionIterator fails");
                return false;
            }
        } catch (Exception e) {
            System.out.println("IncorrectQuestionIterator fails");
            return false;
        }
        return true;
    }

    /**
     * This method checks for the correctness of QuizQuestionsIterator class
     *
     * @return true when this test verifies a correct functionality, and false otherwise
     */
    public static boolean testQuizQuestionsIterator() {
        ListQuizzer listQuizzer = new ListQuizzer();
        listQuizzer.switchMode(ListingMode.ALL);
        MultipleChoiceQuestion question1 =
            new MultipleChoiceQuestion("1", "a", new String[69], 1, 1000);
        MultipleChoiceQuestion question2 =
            new MultipleChoiceQuestion("2", "b", new String[69], 1, 1000);
        MultipleChoiceQuestion question3 =
            new MultipleChoiceQuestion("3", "c", new String[69], 1, 1000);
        MultipleChoiceQuestion question4 =
            new MultipleChoiceQuestion("4", "d", new String[69], 1, 1000);
        ArrayList<MultipleChoiceQuestion> expectedOutput = new ArrayList<>();
        expectedOutput.add(question1);
        expectedOutput.add(question2);
        expectedOutput.add(question3);
        expectedOutput.add(question4);
        listQuizzer.addLast(question1);
        listQuizzer.addLast(question2);
        listQuizzer.addLast(question3);
        listQuizzer.addLast(question4);
        try {
            ArrayList<MultipleChoiceQuestion> temp = new ArrayList<>();
            for (MultipleChoiceQuestion x : listQuizzer)
                temp.add(x);
            if (!expectedOutput.containsAll(temp) || !temp.containsAll(expectedOutput)) {
                System.out.println("quizQuestionsIterator fails");
                return false;
            }
        } catch (Exception e) {
            System.out.println("quizQuestionsIterator fails");
            return false;
        }
        return true;
    }

    /**
     * Tester for ListQuizzer.addLast() method
     *
     * @return true when this test verifies a correct functionality, and false otherwise
     */
    public static boolean testAddLast() {
        return true;
    }

    /**
     * Tester for ListQuizzer.removeLast() method
     *
     * @return true when this test verifies a correct functionality, and false otherwise
     */
    public static boolean testRemoveLast() {
        return true;
    }

    /**
     * Tester for ListQuizzer.removeFirst() method
     *
     * @return true when this test verifies a correct functionality, and false otherwise
     */
    public static boolean testRemoveFirst() {
        return true;
    }

    /**
     * tester for ListQuizzer.remove() method
     *
     * @return true when this test verifies a correct functionality, and false otherwise
     */
    public static boolean testRemove() {
        try {
            ListQuizzer listQuizzer = new ListQuizzer();
            String[] answers = {"akshay", "gona", "is", "cool"};
            MultipleChoiceQuestion question1 =
                new MultipleChoiceQuestion("question1", "bruh?", answers, 1, 2000);
            question1.setStudentAnswerIndex(2);
            MultipleChoiceQuestion question2 =
                new MultipleChoiceQuestion("question2", "bruh?", answers, 1, 2000);
            question2.setStudentAnswerIndex(2);
            MultipleChoiceQuestion question3 =
                new MultipleChoiceQuestion("question3", "bruh?", answers, 1, 2000);
            question3.setStudentAnswerIndex(2);
            MultipleChoiceQuestion question4 =
                new MultipleChoiceQuestion("question4", "bruh?", answers, 1, 2000);
            question4.setStudentAnswerIndex(2);
            {
                listQuizzer.addLast(question1);
                listQuizzer.addLast(question2);
                listQuizzer.addLast(question3);
                if (!listQuizzer.remove(1).equals(question2)) {
                    if (!listQuizzer.get(1).equals(question3) && !listQuizzer.getFirst()
                        .equals(question1)) {
                        System.out.println("midnode test fails");
                        return false;
                    }
                }
            }
            {
                listQuizzer.clear();
                listQuizzer.addLast(question1);
                listQuizzer.addLast(question2);
                listQuizzer.addLast(question3);
                try {
                    listQuizzer.remove(3);
                    System.out.println("indexoutbounds error");
                    return false;
                } catch (IndexOutOfBoundsException e) {

                }
            }
            {
                listQuizzer.clear();
                listQuizzer.addLast(question1);
                listQuizzer.addLast(question2);
                listQuizzer.addLast(question3);
                listQuizzer.remove(0);
                if (!listQuizzer.getFirst().equals(question2) && !listQuizzer.getLast()
                    .equals(question3) && listQuizzer.size() != 2) {
                    System.out.println("bro wtf did you do");
                    return false;
                }
            }
            {
                listQuizzer.clear();
                listQuizzer.addLast(question1);
                listQuizzer.addLast(question2);
                listQuizzer.addLast(question3);
                listQuizzer.remove(2);
                if (!listQuizzer.getFirst().equals(question1) && !listQuizzer.getLast()
                    .equals(question2) && listQuizzer.size() != 2) {
                    System.out.println("aint no way bro");
                    return false;
                }
            }
            return true;
        } catch (Exception e) {
            System.out.println("how tf did you get a random exception");
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Tester for ListQuizzer.add() method
     *
     * @return true when this test verifies a correct functionality, and false otherwise
     */
    public static boolean testAdd() {
        return true;
    }

    /**
     * Tester for ListQuizzer.addFirst() method
     *
     * @return true when this test verifies a correct functionality, and false otherwise
     */
    public static boolean testAddFirst() {
        return true;
    }
}
