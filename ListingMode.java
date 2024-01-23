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
 * An enum representing the three states of the quiz list:
 * - ALL (all questions)
 * - CORRECT (only correctly answered questions)
 * - INCORRECT (only incorrectly answered questions)
 */
public enum ListingMode {
    /**
     * ALL stands for listing ALL the MultipleChoiceQuestions in the quiz6
     */
    ALL,
    /**
     * CORRECT stands for listing the correct MultipleChoiceQuestions only (answered correctly)
     */
    CORRECT,
    /**
     * INCORRECT stands for listing the incorrect MultipleChoiceQuestions only (answered incorrectly)
     */
    INCORRECT
}
