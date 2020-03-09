package com.task;

import java.util.Objects;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class WorkWithObjectString {
    private String myString ;
    private String ResultString;
    private String regex ;
    private String replacement;
    private String Temp;
    Scanner in = new Scanner(System.in);

    void ReplaceAwithAB ()
    {
        myString = "   Replace all characters 'a' with 'ab' ";
        regex = "([a])";
        replacement = "ab";
        System.out.println("first text : " + myString);
        ResultString = myString.replaceAll(regex,replacement);
        System.out.println("result text : " + ResultString);
    }
    void CheckPolidrom ()
    {
     System.out.print("Enter the word ");
     myString = in.nextLine();
     System.out.println(" This word " + Palindrom(myString) + " palindrom");
    }
    private static boolean Palindrom ( String st)
    {
        boolean result;
       result= st.equalsIgnoreCase(new StringBuilder(st).reverse().toString());

        return result;
    }
    void Countletters ()
    {
        System.out.print("Enter the text ");
        myString = in.nextLine();
        System.out.println(" Count lowercase letters = " + CountLowerCase(myString));
        System.out.println(" Count uppercase letters = " + CountUpperCase(myString));
    }
    private static long CountLowerCase ( String s)
    {
        long count = 0;

         count = s.chars().filter((st) -> Character.isLowerCase(st)).count();
        return count;
    }
    private static long CountUpperCase ( String s)
    {
        long count = 0;

        count = s.chars().filter((st) -> Character.isUpperCase(st)).count();
        return count;
    }
    void DeleteAllSpace ()
    {
        System.out.print("Enter the text ");
        myString = in.nextLine();
        myString = myString.trim();
        regex = "\\s";
        replacement = "";
        ResultString = myString.replaceAll(regex,replacement);
        System.out.println(ResultString);

    }
    void RepeatRowWithDuplicate ()
    {
        System.out.print("Enter the text ");
        myString = in.nextLine();
        StringBuilder builder = new StringBuilder();
        for ( int i = 0; i < myString.length(); i++)
        {

            builder.append(myString.charAt(i));
            builder.append(myString.charAt(i));

        }
        ResultString= builder.toString();
        System.out.println(ResultString);
    }
    void CountALetters()
    {
        System.out.print("Enter the text ");
        myString = in.nextLine();
        System.out.println("count: " + CountA(myString));
    }
    private static  long CountA( String s)
    {
        long count;
        count = s.chars().filter( cn -> cn =='a').count();
        return count;
    }
    void CountTheSentenceInTheText ()
    {
        System.out.print("Enter the text ");
        myString = in.nextLine();
        System.out.println( CountSentence(myString));
    }
    private int  CountSentence( String s)
    {
        int count = s.split("[!?.]+").length;
        return count;
    }
    void MostLongWord ()
    {
        System.out.print("Enter the text ");
        myString = in.nextLine();
        System.out.println( CountSentence(myString));
        String[] word = myString.split(" ");
        ResultString = "";
        for(int i = 0; i < word.length; i ++){
            if( word[i].length() >= ResultString.length()){
                ResultString = word[i];
            }
        }
        System.out.println(" word :" + ResultString);
    }
    void  LongestSpace() {
        System.out.print("Enter the text ");
        myString = in.nextLine();
        final String  rexd =" ";
        int count = 0;
        int maxSpace = 0;
        for (int i = 0; i < myString.length(); i++)
        {

            if( rexd.equals(Objects.toString( myString.charAt(i))))
            {
                count ++;
            }
            else
                {
                    count = 0;
                }
            if ( count > maxSpace)
            {
                maxSpace = count;
            }
        }
        System.out.print(" Longest space " + maxSpace);
    }

     void Cake ()
     {
         String Input = "информатика";
         String Output = "торт";
         String newWord = CreateWordFromAnother(Input, Output);
         System.out.println(newWord);
     }
    private static String CreateWordFromAnother(String input, String output) {
        StringBuilder builder= new StringBuilder();
        for (int i = 0; i < output.length(); i++)
        {
            for (int j = 0; j < input.length(); j++)
            {
                if (output.charAt(i) == input.charAt(j))
                {
                    builder.append(input.charAt(j));
                }
            }
        }
        return builder.toString();
    }
}
