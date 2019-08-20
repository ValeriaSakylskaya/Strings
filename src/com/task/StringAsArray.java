package com.task;

import java.util.Arrays;

public class StringAsArray {

    String[] camelCaseArray = new String[]{"camelCase", "snakeCase", "camelSnakeCase"};
    String[] snakeCaseArray = new String[camelCaseArray.length];

    public void ToSnakeCase()
    {
        String regex = "([a-z])([A-Z]+)";
        String replacement = "$1_$2";

        for (int i = 0; i < camelCaseArray.length; i++)
        {
            snakeCaseArray[i] = camelCaseArray[i].replaceAll(regex, replacement).toLowerCase();
        }

        System.out.println(Arrays.toString(snakeCaseArray));
    }
}
