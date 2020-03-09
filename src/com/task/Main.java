package com.task;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
		 int task, section;
		 Scanner in = new Scanner(System.in);
		 System.out.print(" enter the section \n");
		 section = in.nextInt();
		 System.out.print("enter the task \n");
		 task = in.nextInt();
		 AnalisatorHTML analisator = new AnalisatorHTML();
		 StringAsArray stringAsArray = new StringAsArray();
		 WorkWithObjectString WorkWithString = new WorkWithObjectString();
		 AppText appText = new AppText ();

		 if (section == 1) {

			 if (task == 1) {
				stringAsArray.ToSnakeCase();
			 }

			 if ( task ==2) {
				stringAsArray.ReplaceWordLetter();
			 }

			 if ( task == 3) {
				stringAsArray.CountNumbersInArray();
			 }
			 if ( task == 4){
				stringAsArray.CountNumericinString();
			 }
			 if ( task == 5){
				 stringAsArray.DeleteSpaces();
			 }
     	 }
		 if (section == 2){
		 	if ( task == 1)
		 	{
				WorkWithString.LongestSpace();
			}
		 	if ( task == 2)
			{
				WorkWithString.ReplaceAwithAB();
			}
		 	if ( task == 3) {

		 		WorkWithString.CheckPolidrom();
		 	}
		 	if ( task == 4){
				WorkWithString.Cake();
			}
			 if ( task == 5){
				 WorkWithString.CountALetters();
			 }
			 if ( task == 6){
			 	WorkWithString.RepeatRowWithDuplicate();
			 }
			 if ( task == 7){
			 	WorkWithString.DeleteAllSpace();
			 }
			 if ( task == 8){
				 WorkWithString.MostLongWord();
			 }
			 if ( task == 9){
			 	WorkWithString.Countletters();
			 }
			 if ( task == 10){
				 WorkWithString.CountTheSentenceInTheText();
			 }

		 }
		 if (section ==3) {
		 	if (task == 1)
			{
				appText.Text();
			}
			 if (task == 2)
			 {
				 analisator.AnalisatorH();
			 }
		 }
		//in.close();
    }
}
