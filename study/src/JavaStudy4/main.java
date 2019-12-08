package JavaStudy4;

import java.util.Scanner;

class Main {

	public static void main(String[] args) {
		int attendScore;				//출석점수
		int assignmentScore;			//과제점수
		int quizScore;					//퀴즈점수
		int midtermexamScore;			//중간점수
		int finalexamScore;				//기말점수
		double totalScore;				//점수의 합

		char grade;						//등급

		Scanner scan = new Scanner(System.in);
		System.out.print("attendance score:");
		attendScore = scan.nextInt();			//출석점수를 받아온다
		System.out.print("assignment score:");
		assignmentScore = scan.nextInt();		//과제점수를 받아온다
		System.out.print("quiz score:");
		quizScore = scan.nextInt();				//퀴즈점수를 받아온다
		System.out.print("midterm exam score:");
		midtermexamScore = scan.nextInt();		//중간점수를 받아온다
		System.out.print("final exam score:");
		finalexamScore = scan.nextInt();		//기말점수를 받아온다

		//점수의 합 계산
		totalScore = attendScore * 0.1 + assignmentScore * 0.4 + quizScore * 0.1 + midtermexamScore * 0.2
				+ finalexamScore * 0.2;

		if (totalScore >= 90.0)
			grade = 'A';
		else if (totalScore >= 80.0)
			grade = 'B';
		else if (totalScore >= 70.0)
			grade = 'C';
		else if (totalScore >= 60.0)
			grade = 'D';
		else
			grade = 'F';

		System.out.println("total score:" + totalScore);
		System.out.println("grade:" + grade);
	}

}
