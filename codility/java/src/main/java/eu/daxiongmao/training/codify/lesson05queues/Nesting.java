package eu.daxiongmao.training.codify.lesson05queues;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.NoSuchElementException;

/**
 * To check a String format.<br/>
 * A String can be nested by "(S)" or even a combination such as "(())"
 *
 * @author Guillaume Diaz
 * @version 1.0 - February 2015
 */
public class Nesting {

    /**
     * Hypothesis:
     * <ol>
     *     <li>Each element can be nested inside itself. like ex: (())</li>
     *     <li>Only the following characters are allowed: '()'</li>
     * </ol>
     * @param source String to evaluate
     * @return boolean value. <br/>
     * 0 => Incorrect string || 1 => Correct! The format is OK.
     */
    public int checkString(final String source) {
        if (source == null || source.isEmpty()) {
            return 1;
        }

        int isValid = 1;
        // The queue will be used as FILO (First In Last Out)
        Deque<Character> nestedValues = new ArrayDeque<>();

        try {
            // Process given String
            int letterIndex = 0;
            while (letterIndex < source.length() && isValid == 1) {
                char currentLetter = source.charAt(letterIndex);
                if (currentLetter == '(') {
                        nestedValues.push(currentLetter);
                } else if (currentLetter == ')') {
                    Character currentNestedValue = nestedValues.pop();
                    if (currentNestedValue == null || currentNestedValue != '(') {
                        isValid = 0;
                    }
                } else {
                    // Not a valid character
                    isValid = 0;
                }
                letterIndex++;
            }

            // at the end the queue must be empty!
            if (isValid == 1 && !nestedValues.isEmpty()) {
                isValid = 0;
            }
        } catch (NoSuchElementException e) {
            isValid = 0;
        }

        return  isValid;
    }

}
