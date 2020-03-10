package com.task;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextOperation {
    private static Scanner scanner = new Scanner(System.in);
    private static String textExample = "    Because ExecutorService is an interface, an instance of any its implementations can be used." +
            "There are several implementations to choose from in the java util concurrent package or you can create your own.\r\n" +
            "    For example. the ThreadPoolExecutor class. has a few constructors which can be used to configure an executor service and its internal pool.";
    private static int operationNumber = 0;
    private static final String PARAGRAPH_SPLIT_REGEX = "(?m)(?!\\A)(?=^\\s{4})";
    private static final String SENTENCES_SPLIT_REGEX = "[!?.]+";
    private static final int SORT_PARAGRAPHS_BY_COUNT_SENTENCE = 1;
    private static final int SORT_WORD_BY_LENGTH_IN_SENTENCE = 2;
    private static final int SORT_WORD_BY_COUNT_LETTER = 3;

    public static void callOperationForText() {
        System.out.println("Text : " + textExample);
        System.out.println(" What do you want to do with text? ");
        System.out.println(" 1 - Sort paragraphs by number of sentences.\n 2 - Sort words by length \n 3 - Sort word in a sentence in descending order of occurrences of a given character ' a' ");
        operationNumber = scanner.nextInt();
        switch (operationNumber) {
            case SORT_PARAGRAPHS_BY_COUNT_SENTENCE:
                SortParagraphs(textExample);
            case SORT_WORD_BY_LENGTH_IN_SENTENCE:
                SortWordsByLength(textExample);
            case SORT_WORD_BY_COUNT_LETTER:
                SortWordByCountLetterInWord(textExample);
        }
    }

    private static String SortParagraphs(String myString) {
        String result = "";
        String[] paragraph = myString.split(PARAGRAPH_SPLIT_REGEX);
        Comparator<String> comparator = Comparator.comparing(obj -> getSentencesCount(obj));
        Arrays.sort(paragraph, comparator);
        for (int i = 0; i < paragraph.length; i++) {
            result += paragraph[i];
        }
        return result;
    }

    private static String SortWordsByLength(String myString) {
        String[] sentences = myString.split(SENTENCES_SPLIT_REGEX);
        String[] result = new String[sentences.length];
        for (int i = 0; i < sentences.length; i++) {
            sentences[i] = sentences[i].trim();
            result[i] = SortWordByCountLetters(sentences[i]);
        }
        return Arrays.toString(result);
    }

    private static String SortWordByCountLetters(String myString) {
        Comparator<String> comparator = (o1, o2) -> o1.length() - o2.length();
        Pattern pattern = Pattern.compile("\\w+", Pattern.UNICODE_CHARACTER_CLASS);
        Matcher matcher = pattern.matcher(myString);
        ArrayList<String> words = new ArrayList<String>();
        while (matcher.find()) words.add(matcher.group());
        words.sort(comparator);
        return words.toString();
    }

    private static String SortWordByCountLetterInWord(String myString) {
        String[] words = myString.split(SENTENCES_SPLIT_REGEX);
        String[] result = new String[words.length];
        for (int i = 0; i < words.length; i++) {
            words[i] = words[i].trim();
            result[i] = SortWordByCountLetter(words[i]);
        }
        return Arrays.toString(result);
    }

    private static String SortWordByCountLetter(String myString) {
        Comparator<String> comparator = Comparator.comparing(obj -> getCountLetterInWord(obj));
        Pattern pattern = Pattern.compile("\\w+", Pattern.UNICODE_CHARACTER_CLASS);
        Matcher matcher = pattern.matcher(myString);
        ArrayList<String> sentenceWords = new ArrayList<String>();
        while (matcher.find()) sentenceWords.add(matcher.group());
        Collections.sort(sentenceWords);
        sentenceWords.sort(comparator);
        return sentenceWords.toString();
    }

    private static int getCountLetterInWord(String myString) {
        char letter = 'a';
        int occurrencesCount = (int) myString.chars().filter(ch -> ch == letter).count();
        return occurrencesCount;
    }

    private static int getSentencesCount(String myString) {
        String[] Sentences = myString.split(SENTENCES_SPLIT_REGEX);
        return Sentences.length;
    }
}
