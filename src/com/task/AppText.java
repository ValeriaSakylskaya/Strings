package com.task;

import javax.xml.transform.Result;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AppText {
    Scanner in = new Scanner(System.in);
    private String Text = " In fact, a regular expression is a pattern for finding a string in a text." +
            "\n In Java, the initial representation of this template is always a string, that is, an object of class String. However, not every string can " +
            "be compiled into a regular expression. But only one that complies with the rules for writing a regular expression - the syntax defined in the language specification." +
            "\n To write a regular expression, alphanumeric characters are used. As well as metacharacters - characters that have special meaning in the regular expression syntax.";
    private String TEXTtext ="belka belka. Qne belkffdfda as uiy. pupsil er.";
    private int taskText = 0;
    private static final String PARAGRAPH_SPLIT_REGEX = "(?m)(?=^\\s{4})";
    private static final String WORDS_SPLIT_REGEX = "[!?.]+";


    void Text ()
    {
        System.out.println( "Text : " + Text);
        System.out.println(" What do you want to do with text? ");
        System.out.println(" 1 - Sort paragraphs by number of sentences.\n 2 - Sort words by length \n 3 - Sort word in a sentence in descending order of occurrences of a given character" );
        taskText = in.nextInt();
        if ( taskText == 1)
        {
            System.out.println("" +  SortParagphs(Text));
        }
        if ( taskText == 2)
        {
            System.out.println("" +  SortWords(Text));
        }
        if ( taskText == 3)
        {
            System.out.println("" +  lexeme(Text));
        }


    }
    private static String  SortParagphs( String mystring )
    {
        String ResultString = "";
        String [ ] Paragphs = mystring.split(PARAGRAPH_SPLIT_REGEX);
        Arrays.sort(Paragphs);
        ResultString = Arrays.toString(Paragphs);
        return ResultString;
    }
    private static String SortWords ( String mystring)
    {

        String ResultString = "";
        String [] Words = mystring.split(WORDS_SPLIT_REGEX);
        String [] Result = new String[Words.length];

        for ( int i = 0; i < Words.length; i++)
        {
            Words[i] = Words[i].trim();
            Result[i] = sortwordLetters(Words[i]);
        }
        ResultString = Arrays.toString(Result);
        return ResultString;
    }
    private static String sortwordLetters ( String mystring)
    {
        Comparator<String> comprator = (o1,o2) -> o1.length() - o2.length();
        String ResultString = "";
        Pattern pattern = Pattern.compile("\\w+", Pattern.UNICODE_CHARACTER_CLASS);
        Matcher matcher = pattern.matcher(mystring);
        ArrayList<String> Temp = new ArrayList<String>();
        while (matcher.find())  Temp.add(matcher.group());
        Temp.sort(comprator);
        ResultString = Temp.toString();
        return ResultString;

    }
    private  static String lexeme (String mystring)
    {
        String ResultString = "";
        String [] Words = mystring.split(WORDS_SPLIT_REGEX);
        String [] Result = new String[Words.length];
        for ( int i = 0; i < Words.length; i++)
        {
            Words[i] = Words[i].trim();
            Result[i] = Sortlexeme(Words[i]);
        }
        ResultString = Arrays.toString(Result);
        return ResultString;
    }
    private static  String Sortlexeme (String mystring)
    {
        String ResultString = "";
        char searchFor = 'a';
        Comparator<String> comprator = Comparator.comparing(obj -> CountLetters(obj));
        Pattern pattern = Pattern.compile("\\w+", Pattern.UNICODE_CHARACTER_CLASS);
        Matcher matcher = pattern.matcher(mystring);
        ArrayList<String> Temp = new ArrayList<String>();
        while (matcher.find())  Temp.add(matcher.group());
        Collections.sort(Temp);
        Temp.sort(comprator);
        ResultString = Temp.toString();

        return ResultString;
    }
    private static int  CountLetters ( String mystring)
    {
         char Lettter = 'a';
        int occurrencesCount =(int) mystring.chars().filter(ch -> ch == Lettter).count();

        return  occurrencesCount;
    }


}
