package com.example.demoSpringBoot.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller to check if a word is a palindrome.
 *
 * @author Jorge Correyero
 */
@RestController
public class PalindromeValidatorRestController {
    /**
     * Method to reverse the String it receives as a parameter.
     *
     * @param word String that is going to be reversed.
     * @return reversed String.
     */
    public static String reverseWord(String word) {
        String reversed = "";
        for (int i = word.length()-1; i >= 0; i--) { // Loop through the whole String and save from the last letter to the first one in a variable
            reversed += word.charAt(i);
        }
        return reversed;
    }

    /**
     * Endpoint to check if a word is a palindrome.
     *
     * @param word String introduced in the URL by the user that wants to check if it's a palindrome.
     * @return the message that indicates if the word is a palindrome.
     */
    @GetMapping("/palindrome/{word}")
    public String showSolution(@PathVariable String word) {
        String reversed = reverseWord(word); // Get the String reversed
        if(reversed.equalsIgnoreCase(word))
            return "The word " + word + " IS a palindrome.";
        else
            return "The word " + word + " IS NOT a palindrome.";
    }
}
