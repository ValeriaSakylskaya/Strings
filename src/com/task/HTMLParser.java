package com.task;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.System.*;

public class HTMLParser {
    private static String XMLContent = "<notes>" +
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
            " </note>" +
            "</notes>";
    private static final String HtmlTagPattern = "<[^<>]+>";

    public static void parseXMLNodes() {
        out.println("start parsing document...");
        Pattern pattern = Pattern.compile(HtmlTagPattern);
        Matcher matcher = pattern.matcher(XMLContent);
        ArrayList<String> tagsArrayList = new ArrayList<String>();
        ArrayList<Integer> positionTheStartParsing = new ArrayList<Integer>();
        while (matcher.find()) {
            tagsArrayList.add(matcher.toMatchResult().group());
            positionTheStartParsing.add(matcher.start());
        }
        for (int i = 0; i < tagsArrayList.size(); i++) {
            out.println((i + 1) + " teg: " + tagsArrayList.get(i));
            out.println("Type: " + getTagType(tagsArrayList.get(i)));
            String Content = getTagContent(tagsArrayList.get(i), XMLContent, positionTheStartParsing.get(i));
            if (Content.isEmpty()) {
                out.println(" Content:  tag without body");
            } else {
                out.println(" Content: " + Content);
            }
        }
        out.println("parsing completed.");
    }

    private static String getTagType(String tag) {
        String tagType;
        Pattern pattern = Pattern.compile("/");
        Matcher matcher = pattern.matcher(tag);
        if (matcher.find())
            tagType = "close tag";
        else tagType = "open tag";
        return tagType;
    }

    private static String getTagContent(String tag, String textHTML, int index) {
        String content = "";
        int firstElementIndex = 0;
        if (index != firstElementIndex)
            textHTML = textHTML.substring(index);
        ArrayList<String> foundContentArray = new ArrayList<String>();
        String tagName = getTagName(tag);
        String tagContentRegex = "<" + tagName + "\\b[^>]*>(.*?)<\\/" + tagName + ">";
        Pattern pattern = Pattern.compile(tagContentRegex);
        Matcher matcher = pattern.matcher(textHTML);
        while (matcher.find()) {
            foundContentArray.add(matcher.group(firstElementIndex));
        }
        if (foundContentArray.isEmpty() == false)
            content += foundContentArray.get(firstElementIndex);
        return content;
    }

    private static String getTagName(String tag) {
        StringBuilder Name = new StringBuilder();
        for (int i = 0; i < tag.length(); i++) {
            if (tag.charAt(i) != '<' && tag.charAt(i) != '>' && tag.charAt(i) != ' ')
                Name.append(tag.charAt(i));
            else if (tag.charAt(i) == ' ')
                break;
        }
        return Name.toString();
    }
}