package com.task;

import java.util.Arrays;

public class StringAsArray {

    private static String[] camelCaseElementsArray = new String[]{"camelCase", "snakeCase", "camelSnakeCase"};
    private static String[] snakeCaseElementsArray = new String[camelCaseElementsArray.length];
    private static String exampleString = new String(" 46  +  23 = 69");

    public static void toSnakeCase() {
        String regex = "([a-z])([A-Z]+)";
        String replacement = "$1_$2";
        for (int i = 0; i < camelCaseElementsArray.length; i++) {
            snakeCaseElementsArray[i] = camelCaseElementsArray[i].replaceAll(regex, replacement).toLowerCase();
        }
        System.out.println(Arrays.toString(snakeCaseElementsArray));
    }

    public static void replaceWordToLetter() {
        String exampleString = "Hello word";
        String replacedString = exampleString.replace("word", "letter");
        System.out.println(replacedString);
    }

    public static void countNumbersInString() {
        int count = 0;
        char charArray[] = exampleString.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            if (Character.isDigit(charArray[i]))
                count++;
        }
        System.out.println("Count the numbers " + count);
    }

    public static void countNumericInString() {
        String delimiter = " ";
        String[] splittedStringArray = exampleString.split(delimiter);
        int count = 0;
        for (String element : splittedStringArray) {
            try {
                Integer.parseInt(element);
            } catch (NumberFormatException e) {
                count++;
            }
        }
        System.out.println(splittedStringArray.length - count);
    }

    public static void deleteExceedSpaces() {
        String trimedString = exampleString.trim();
        char withoutDoubleSpacesArray[] = trimedString.toCharArray();
        char newArray[] = new char[withoutDoubleSpacesArray.length];
        String result;
        int index = 0;
        for (int i = 0; i < withoutDoubleSpacesArray.length - 1; i++) {
            if (Character.isWhitespace(withoutDoubleSpacesArray[i]) == true && Character.isWhitespace(withoutDoubleSpacesArray[i + 1]) == true) {
                System.out.println("delete space index char " + i);
            } else {
                newArray[index] = withoutDoubleSpacesArray[i];
                index++;
            }
            newArray[index] = withoutDoubleSpacesArray[withoutDoubleSpacesArray.length - 1];
        }
        result = Arrays.toString(newArray);
        System.out.println(result);
    }
}
