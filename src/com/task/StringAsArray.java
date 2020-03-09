package com.task;

import java.util.Arrays;
import java.util.Objects;

public class StringAsArray {

    private String[] camelCaseArray = new String[]{"camelCase", "snakeCase", "camelSnakeCase"};
    private String[] snakeCaseArray = new String[camelCaseArray.length];
    private String  myString = " 46  +  23 = 69 ";

    public void ToSnakeCase() {
        String regex = "([a-z])([A-Z]+)";
        String replacement = "$1_$2";

        for (int i = 0; i < camelCaseArray.length; i++) {
            snakeCaseArray[i] = camelCaseArray[i].replaceAll(regex, replacement).toLowerCase();
        }

        System.out.println(Arrays.toString(snakeCaseArray));
    }

    public void ReplaceWordLetter() {
       String word = "Hello word";
       String letter =  word.replace("word","letter");

       System.out.println(letter);
    }

    public void CountNumbersInArray() {
        int count = 0;
        char myArray[] = myString.toCharArray();

        for (int i = 0; i < myArray.length; i ++) {
            if (Character.isDigit(myArray[i])) {
                count++;
            }
        }

        System.out.println("Count the numbers " + count);
    }
    public void CountNumericinString (){

        String[] sarr = myString.split(" ");
        int count = 0;
        for(String str : sarr) {
            try {
                Integer.parseInt(str);
            } catch(NumberFormatException e) {
                count++;
            }
        }
        System.out.println(sarr.length - count);

    }
    public void DeleteSpaces (){
     char myArray [] = myString.toCharArray();
     char newArray [] = new char [myArray.length] ;
     String qtring;
        newArray[0]= myArray[0];
     for ( int i = 1; i < myArray.length; i++)
     {
        if ( myArray[i]== ' '&& myArray[i-1]==' ')
        {

        }
        else newArray[i]=myArray[i];
     }
        qtring = Arrays.toString(newArray);
     System.out.println(qtring);
       }
    }
