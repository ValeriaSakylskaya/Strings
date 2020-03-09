package com.task;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import static java.lang.System.*;

public class AnalisatorHTML {
    private String HTMLText = "<notes>" +
            "<note id =\"1\">" +
            " <to>Вася</to>" +
            " <from>Света</from>" +
            " <heading>Напоминание</heading>" +
            " <body>Позвони мне завтра!</body>" +
            " </note>" +
            " <note id = \"2\">" +
            " <to>Петя</to>" +
            " <from>Маша</from>" +
            " <heading>Важное напоминание</heading>" +
            " <body/>" +
            " </note>";
    private static final String HtmlTagPattern = "<(\\w+)[^>]*>";
  //  private  static  final

    void AnalisatorH() {
        this.startDocument();
        this.PatternTAG(HTMLText);
        this.endDocument();
    }
    public void PatternTAG ( String HTMLString)
    {
        Pattern pattern = Pattern.compile(HtmlTagPattern);
        Matcher matcher = pattern.matcher(HTMLString);
        ArrayList<String> Temp = new ArrayList<String>();
        ArrayList<Integer> POZ = new ArrayList<Integer>();
        while (matcher.find())
        {
            Temp.add(matcher.toMatchResult().group());
            POZ.add(matcher.start());
        }

        for ( int i = 0; i < Temp.size(); i++)
        {
            out.println(( i + 1) +" teg: " + Temp.get(i) );
            out.println("Type: " + Typetag(Temp.get(i)));
            out.println(" Content: " + TagContent(Temp.get(i), HTMLString,POZ.get(i)));
        }
    }


    public void startDocument ()
    {
        out.println("start parsing a document");
    }


    public  void endDocument ()
    {
        out.println("parsing completed");
    }
     public static String Typetag ( String tag)
     {
        String TypeTag;
         Pattern pattern = Pattern.compile("/");
         Matcher matcher = pattern.matcher(tag);
         if (matcher.find())
         {
             TypeTag = "close teg";
         }
         else TypeTag = "open teg";
         return  TypeTag;
     }
    public static  String TagContent( String tag, String text, int index)
   {
       String Content = "";
       if ( index != 0) text =  text.substring(index);
       tag = Nametag(tag);
       String HTNMLContent = "<" + tag + "\\b[^>]*>(.*?)<\\/" + tag +">";
       Pattern pattern1 = Pattern.compile(HTNMLContent);
       Matcher matcher1 = pattern1.matcher(text);
       ArrayList<String> Temp = new ArrayList<String>();
       while (matcher1.find()) Temp.add(matcher1.group(1));
          //Content = Temp.get(0);
     // Content= tag;

       return Content;
   }
   private static  String Nametag( String tag)
   {
       StringBuilder Name = new StringBuilder();
       for ( int i = 0; i < tag.length(); i++)
       {
         if ( tag.charAt(i) !='<' && tag.charAt(i) != '>'  && tag.charAt(i) != ' ' )
         {
             Name.append(tag.charAt(i));
         }
         else if  ( tag.charAt(i) == ' ' ) { break;}
         }
       return  Name.toString();
   }
}