package JavaStudy4;

import java.util.Scanner;

class Main {

	public static void main(String[] args) {
		int attendScore;
		int assignmentScore;
		int quizScore;
		int midtermexamScore;
		int finalexamScore;
		double totalScore;

		char grade;

		Scanner scan = new Scanner(System.in);
		System.out.print("attendance score:");
		attendScore = scan.nextInt();
		System.out.print("assignment score:");
		assignmentScore = scan.nextInt();
		System.out.print("quiz score:");
		quizScore = scan.nextInt();
		System.out.print("midterm exam score:");
		midtermexamScore = scan.nextInt();
		System.out.print("final exam score:");
		finalexamScore = scan.nextInt();

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
