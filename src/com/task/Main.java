package com.task;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	 int task , section;

	 Scanner in = new Scanner(System.in);
	 System.out.print(" enter the section \n");
	 section = in.nextInt();
	 System.out.print("enter the task \n");
	 task = in.nextInt();

	 StringAsArray asArray = new StringAsArray();

	 if (section == 1)
	 {
	     if (task == 2)
         {
           asArray.ToSnakeCase();
         }
     }
    }
}
