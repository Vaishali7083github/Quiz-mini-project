package com.quiz.student.database;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;


public class QuizStart {
	private ArrayList<Question> questionSet;
	public QuizStart() {
		questionSet = new ArrayList<Question>();
		String q1 ="Select the Valid Statement.";
		String[] a1 = { "char[] ch=new char(5) ","char[] ch = new char[5] ","char[] ch = new char () ","char[] ch = new char[] "};
		questionSet.add(new Question(q1,a1,"char[] ch = new char[5]"));
		String q2 ="When an array is passed to a method, what does the method receive? ";
		String[] a2= new String[] {"The reference of the array","A copy of the array"," Length of the array","Copy of First element" };
		questionSet.add(new Question(q2,a2,"The reference of the array"));
		String q3="When is the object created with new keyword?";
		String[] a3 = new String[] {"At run time","At compile time","Depends on the code","None"};
		questionSet.add(new Question(q3,a3,"At run time"));
		String q4 = "Identify the corrected defination of a package.";
		String[] a4= new String[] {"A package is a collection of editing tools","A package is a collection of classes","A package is a collection of classes and interface","A package is a collection of Interface",};
		questionSet.add(new Question(q4,a4,"A package is a collection of classes and interface"));
		String q5 = "Identify the keyword among the following that makes a variable belong to a class, rather than being defined for each instance of the class.";
		String[] a5= new String[] {"Final","Static","Volatile","abstract"};
		questionSet.add(new Question(q5,a5,"Static"));
		String q6 = "In which of the following is toString() method defined?";
		String[] a6 = new String[] {"java.lang.object","java.lang.String","java.lang.util","none"};
		questionSet.add(new Question(q6,a6,"java.lang.object"));
		String q7 = "compare to() returns?";
		String[] a7= new String[] {"True","False","An int value","None"};
		questionSet.add(new Question(q7,a7,"An int value"));
		String q8="To which of the following does the class String belong to.";
		String[] a8= new String[] {"java.lang","java.awt","java.applet","java.string"};
		questionSet.add(new Question(q8,a8,"java.lang"));
		String q9 = "Identify the return type of a method that does not return any value.";
		String[] a9 = new String[] {"int","void","double","None"};
		questionSet.add(new Question(q9,a9,"void"));
		String q10= "Where does the System stores parameters and local variable whenever a method is invoked?";
		String[] a10 = new String[] {"Heap","Stack","Array","Tree"};
		questionSet.add(new Question(q10,a10,"Stack"));
		Collections.shuffle(questionSet,new Random());
	}
	public void start() {
		Scanner scan = new Scanner(System.in);
		int numCorrect=0;
		//show questions from questionSet
		for(int question=0; question<questionSet.size();question++) {
			System.out.println(questionSet.get(question).getQuestion());
			int numChoices= questionSet.get(question).getChoices().size();
			// show choices from questions in questionSet
			for(int choice=0; choice < numChoices; choice++) {
				System.out.println((choice + 1)+": "+questionSet.get(question).getChoices().get(choice));
			
			}
			int playerAnswer = scan.nextInt();
			ArrayList<String> choiceSet = questionSet.get(question).getChoices();
			String correctAnswer = questionSet.get(question).getAnswer();
			int correctAnswerIndex = choiceSet.indexOf(correctAnswer);
			if(playerAnswer == correctAnswerIndex + 1) {
				numCorrect++;
			}
		}
		scan.close();
		System.out.println("you got "+ numCorrect+ " correct answer(s)");
		if(numCorrect>=8) {
			System.out.print("Grade A");
		}
		else if(numCorrect>5 && numCorrect<8) {
			System.out.println("Grade B");
		}
		else if(numCorrect==5) {
			System.out.println("Grade C");
		}
		else {
			System.out.println("Fail");
		}

	}

}
