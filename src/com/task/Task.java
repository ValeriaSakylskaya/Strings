package com.task;

interface TaskFactory {
    void runTask(int taskNumber);
}

class TaskFactoryImpl implements TaskFactory {
    private final int CONVERT_ARRAY_ELEMENTS_TO_SNAKE_CASE = 1;
    private final int REPLACE_WORD_TO_LETTER_IN_STRING = 2;
    private final int FIND_COUNT_OF_NUMBERS_IN_STRING = 3;
    private final int FIND_COUNT_OF_NUMERIC_IN_STRING = 4;
    private final int DELETE_EXCEED_SPACES_IN_STRING = 5;
    private final int FIND_THE_LARGEST_NUMBER_OF_SPACES_iN_STRING = 6;
    private final int INSERT_CHARACTER_B_AFTER_A = 7;
    private final int CHECK_IS_THE_WORD_PALINDROME = 8;
    private final int MAKE_FROM_INFORMATIKA_WORD_TORT = 9;
    private final int COUNT_THE_NUMBER_A_IN_STRING = 10;
    private final int GET_LINE_BY_REPEATING_EACH_CHARACTER = 11;
    private final int DELETE_ALL_DUPLICATE_CHARACTER = 12;
    private final int SEARCH_FOR_THE_LONGEST_WORD_IN_STRING = 13;
    private final int COUNT_NUMBERS_OF_UPPERCASE_LOWERCASE_LETTERS_IN_STRING = 14;
    private final int COUNT_SENTENCE_IN_STRING = 15;
    private final int OPERATION_FOR_TEXT = 16;
    private final int PARSER_HTML_TEXT = 17;

    public void runTask(int taskNumber) {
        switch (taskNumber) {
            case CONVERT_ARRAY_ELEMENTS_TO_SNAKE_CASE:
                StringAsArray.toSnakeCase();
            case REPLACE_WORD_TO_LETTER_IN_STRING:
                StringAsArray.replaceWordToLetter();
            case FIND_COUNT_OF_NUMBERS_IN_STRING:
                StringAsArray.countNumbersInString();
            case FIND_COUNT_OF_NUMERIC_IN_STRING:
                StringAsArray.countNumericInString();
            case DELETE_EXCEED_SPACES_IN_STRING:
                StringAsArray.deleteExceedSpaces();
            case FIND_THE_LARGEST_NUMBER_OF_SPACES_iN_STRING:
                WorkWithObjectString.getLargestNumberOfConsecutiveSpaces();
            case INSERT_CHARACTER_B_AFTER_A:
                WorkWithObjectString.appendSymbolAToB();
            case CHECK_IS_THE_WORD_PALINDROME:
                WorkWithObjectString.isWordPalindrome();
            case MAKE_FROM_INFORMATIKA_WORD_TORT:
                WorkWithObjectString.makeFromWordInformatikaTort();
            case COUNT_THE_NUMBER_A_IN_STRING:
                WorkWithObjectString.countTheNumberOfCharactersA();
            case  GET_LINE_BY_REPEATING_EACH_CHARACTER:
                WorkWithObjectString.repeatEachCharacter();
            case DELETE_ALL_DUPLICATE_CHARACTER:
                WorkWithObjectString.deleteAllDuplicate();
            case  SEARCH_FOR_THE_LONGEST_WORD_IN_STRING:
                WorkWithObjectString.searchLongestWord();
            case  COUNT_NUMBERS_OF_UPPERCASE_LOWERCASE_LETTERS_IN_STRING:
                WorkWithObjectString.countOfNumbersUppercaseAndLowercaseLetters();
            case COUNT_SENTENCE_IN_STRING:
                WorkWithObjectString.CountTheSentenceInTheText();
            case OPERATION_FOR_TEXT:
                TextOperation.callOperationForText();
            case PARSER_HTML_TEXT:
                HTMLParser.parseXMLNodes();

        }
    }
}