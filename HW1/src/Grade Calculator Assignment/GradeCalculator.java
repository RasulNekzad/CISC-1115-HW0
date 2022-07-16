import java.util.Scanner;

public class GradeCalculator {

	public static void main(String[] args) {
		//Creates scanner object.
		Scanner sc = new Scanner(System.in);
		
		//Declares variables for the different inputs.
		int hw, codeLab, midterm1, midterm2, finalExam;
		
		//Prompts user to enter grades for different aspects of class and assigns their inputs to the appropriate variables.
		System.out.print("Please enter your grade for Homework > ");
		hw = sc.nextInt();
		
		System.out.print("Please enter your grade for Code Lab > ");
		codeLab = sc.nextInt();
		
		System.out.print("Please enter your grade for Midterm 1 > ");
		midterm1 = sc.nextInt();
		
		System.out.print("Please enter your grade for Midterm 2 > ");
		midterm2 = sc.nextInt();
		
		System.out.print("Please enter your grade for the final exam > ");
		finalExam = sc.nextInt();
		System.out.println();
		
		//Sums the grades and outputs as final grade.
		System.out.println("The total score is " 
			+ (hw + codeLab + midterm1 + midterm2 + finalExam) + ".");
	}
}
