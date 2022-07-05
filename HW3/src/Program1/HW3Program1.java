import java.io.File;
import java.io.PrintStream;
import java.util.Scanner;

public class HW3Program1 {
	public static void main(String[] args) throws Exception {
		Scanner scanner = new Scanner(new File("./sample-integers.txt"));
		PrintStream ps = new PrintStream("./output.txt");

		// Scans numbers in input line by line to initiate computations.
		while (scanner.hasNextLine()) {
			String token = scanner.next();

			// Converts token to integer and prints the factorial value for the integer to output file.
			ps.printf("The factorial of " + token + " is " + factorial(Integer.valueOf(token)) + ".\n");
			// Converts token to integer and prints the sum of squares value for the integer to output file.
			ps.printf("The sum of squares is " + sumOfSquares(Integer.valueOf(token)) + ".\n");
			// Converts token to integer and using an array, prints the fibonacci sequence to output file.
			int[] res = fibonacci(Integer.valueOf(token));
			// Iterates through the array holding the values of the fibonacci sequence and prints each value.
			ps.print("Fibonacci sequence: ");
			for (int i = 1; i < res.length; i++) {
				ps.print(res[i]);
				ps.print(", ");
			}
			ps.print("...\n");
			
			// Prints factorial value onto console.
			System.out.println("The factorial of " + token + " is " + factorial(Integer.valueOf(token)) + ".");
			// Prints sum of squares value onto console.
			System.out.println("The sum of squares is " + sumOfSquares(Integer.valueOf(token)) + ".");
			// Prints fibonacci sequence onto console.
			System.out.print("Fibonacci sequence: ");
			for (int i = 1; i < res.length; i++) {
				System.out.print(res[i]);
				System.out.print(", ");
			}
			System.out.print("...\n");
		}
		System.out.println("Finished computing.");
		scanner.close();

	}
	// Defines method for the factorial of a number using recursion.
	public static int factorial(int n) {
		if (n == 0) {
			return 1;
		}
		// Calls factorial method within itself until the value of x reaches 1.
		return n * factorial(n-1);
	}

	// Defines method for the sum of sqaures of a series ending in the input value using a for loop.
	public static int sumOfSquares(int n) {

		// Declares and initializes a variable for storing sums.
		int sum = 0;

		// Iterates from 1...n and calculates the square for each iteration i and appends it to the sum.
		for (int i=1; i<=n; i++) {
			int square = i*i;
			sum += square;
		}
		return sum;
	}
	// Defines method for the fibonacci sequence using an array of integers.
	public static int[] fibonacci(int n) {
		// Declares and initializes variables used in outlining the fibonacci sequence.
		int num1 = 1;
		int num2 = 2;
		int counter = 1;
		// Creates an array of integers to store the values of the fibonacci sequence up to the entered input.
		int[] res = new int[n+1];
		while(counter <= n) {
			res[counter] = num1;
			// Stores the sum of num1 and num2.
			int num3 = num1 + num2;
			num1 = num2;
			num2 = num3;
			// Iterates counter variable.
			counter+=1;
		}
		return res;
	}

}