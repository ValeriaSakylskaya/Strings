package com.task;

import java.util.Objects;
import java.util.Scanner;


public class WorkWithObjectString {
    private static String resultString;
    private static String regex;
    private static String replacement;
    private static String Temp;
    private static Scanner in = new Scanner(System.in);

    public static void appendSymbolAToB() {
        String userString = requestStringFromUser();
        regex = "([a])";
        replacement = "ab";
        System.out.println("first text : " + userString);
        resultString = userString.replaceAll(regex, replacement);
        System.out.println("result text : " + resultString);
    }

    public static void isWordPalindrome() {
        String userInputString = requestStringFromUser();
        boolean isPalindrome = userInputString.equalsIgnoreCase(new StringBuilder(userInputString).reverse().toString());
        System.out.println("Is word Palindrome: " + isPalindrome);
    }

    public static void countOfNumbersUppercaseAndLowercaseLetters() {
        String userString = requestStringFromUser();
        System.out.println(" Count lowercase letters = " + CountLowercaseLetters(userString));
        System.out.println(" Count uppercase letters = " + CountUppercaseLetters(userString));
    }

    private static long CountLowercaseLetters(String s) {
        long count = 0;
        count = s.chars().filter((st) -> Character.isLowerCase(st)).count();
        return count;
    }

    private static long CountUppercaseLetters(String s) {
        long count = 0;
        count = s.chars().filter((st) -> Character.isUpperCase(st)).count();
        return count;
    }

    private static String requestStringFromUser() {
        System.out.print("Enter the text ");
        return in.nextLine();
    }

    public static void deleteAllDuplicate() {
        String userString = requestStringFromUser();
        userString = userString.trim();
        regex = "\\s";
        replacement = "";
        resultString = userString.replaceAll(regex, replacement);
        resultString = resultString.replaceAll("([a-z])\\1", "$1");
        System.out.println(resultString);
    }

    public static void repeatEachCharacter() {
        String userString = requestStringFromUser();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < userString.length(); i++) {
            builder.append(userString.charAt(i));
            builder.append(userString.charAt(i));
        }
        resultString = builder.toString();
        System.out.println(resultString);
    }

    public static void countTheNumberOfCharactersA() {
        String userString = requestStringFromUser();
        long count;
        count = userString.chars().filter(cn -> cn == 'a').count();
        System.out.println("count A in string: " + count);
    }

    public static void CountTheSentenceInTheText() {
        String userString = requestStringFromUser();
        int count = userString.split("[!?.]+").length;
        System.out.println(count);
    }

    public static void searchLongestWord() {
        String userString = requestStringFromUser();
        String[] word = userString.split(" ");
        resultString = "";
        for (int i = 0; i < word.length; i++) {
            if (word[i].length() >= resultString.length())
                resultString = word[i];
        }
        System.out.println(" word :" + resultString);
    }

    public static void getLargestNumberOfConsecutiveSpaces() {
        String spaceCharacter = " ";
        String userString = requestStringFromUser();
        int intermediateSpaceCounter = 0;
        int resultCount = 0;
        for (int i = 0; i < userString.length(); i++) {
            if (spaceCharacter.equals(Objects.toString(userString.charAt(i))))
                intermediateSpaceCounter++;
            else
                intermediateSpaceCounter = 0;
            if (intermediateSpaceCounter > resultCount)
                resultCount = intermediateSpaceCounter;
        }
        System.out.print(" Longest space " + resultCount);
    }

    public static void makeFromWordInformatikaTort() {
        String Input = "информатика";
        String Output = "торт";
        String newWord = createWordFromAnother(Input, Output);
        System.out.println(newWord);
    }

    private static String createWordFromAnother(String input, String output) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < output.length(); i++) {
            for (int j = 0; j < input.length(); j++) {
                if (output.charAt(i) == input.charAt(j))
                    builder.append(input.charAt(j));
            }
        }
        return builder.toString();
    }
}
