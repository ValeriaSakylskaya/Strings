package com.task;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int taskNumber;
        Scanner in = new Scanner(System.in);
        System.out.print("enter the task \n");
        taskNumber = in.nextInt();
        TaskFactoryImpl taskFactory = new TaskFactoryImpl();
        taskFactory.runTask(taskNumber);
    }
}