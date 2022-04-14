package com.hyperiondev.thelibrarian.isbn;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Validator {
    private String bookNumber;
    private List<Integer> bookNumberDigits;

    /***
     * Constructor for the Validator class
     * @param bookNumber: The string that is to be verified against the ISBN-10 or ISBN-13 standards
     */
    public Validator(String bookNumber) {
        this.bookNumber = bookNumber.strip();
    }

    /***
     * Public method for checking the validity of given numbers.
     * @return (String): Returns either 'valid, 'invalid', or a converted ISBN-13 standard number.
     */
    public String validate() {
        if (bookNumber.matches("\\d{13}$")) {
            convertToDigitList();
            return verifyISBN13();
        } else if (bookNumber.matches("\\d{10}$")) {
            convertToDigitList();
            return verifyISB10();
        } else if (bookNumber.matches("\\d{9}X$")) {
            this.bookNumber = bookNumber.replace("X", "");
            convertToDigitList();
            return verifyISB10();
        } else
            return "Invalid";
    }

    /***
     * Converts the string of digits to an array list with the same elements in the same order
     * @return: void
     */
    private void convertToDigitList() {
        this.bookNumberDigits = Stream.of(bookNumber.split(""))
                .map((Integer::parseInt))
                .collect(Collectors.toList());
    }

    /***
     * Verifies the ISBN-13 number based on the algorithm
     * @return: (String) 'Valid' or 'Invalid' based on whether the number is valid or not
     */
    private String verifyISBN13() {
        int total = 0;

        for (int i = 0; i < bookNumberDigits.size(); i++) {
            total += (i % 2 == 0) ? bookNumberDigits.get(i) : (bookNumberDigits.get(i) * 3);
        }

        return total % 10 == 0 ? "Valid" : "Invalid";
    }

    /***
     * Verifies the ISBN-10 number based on the algorithm
     * @return: (String) ISBN-13 number or otherwise 'Invalid' based on whether the number is
     * valid or not.
     */
    private String verifyISB10() {
        int total = 0;
        int multiplier = 10;

        if (bookNumberDigits.size() == 9)
            bookNumberDigits.add(10);

        for (Integer bookNumberDigit : bookNumberDigits) {
            total += (bookNumberDigit * multiplier);
            --multiplier;
        }

        return total % 11 == 0 ? convertToISBN13() : "Invalid";
    }

    /***
     * Converts a valid and verified ISBN-10 number to ISBN-13 number
     * @return (String): The converted ISBN-13 number
     */
    private String convertToISBN13() {
        StringBuilder convertedString = new StringBuilder();
        int total = 38;
        List<Integer> newList = new ArrayList<>(bookNumberDigits.subList(0, 9));

        for (int i = 0; i < newList.size(); i++) {
            total += (i % 2 == 0) ? (newList.get(i) * 3) : newList.get(i);
        }

        newList.forEach(convertedString::append);
        int checkDigit = 10 - (total % 10);

        return "978" + convertedString + checkDigit;
    }
}
