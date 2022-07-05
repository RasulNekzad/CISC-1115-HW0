import java.util.Scanner;

public class RectangleStat {
	
	public static void main(String[] args) {
		//Creates scanner object.
		Scanner sc = new Scanner(System.in);
		
		//Declares width and length variables.
		int width, length;
		
		//Prompts user to enter width.
		System.out.println("Please enter the width of the rectangle.");
		//Assigns input to width variable.
		width = sc.nextInt();
		
		//Prompts user to enter length.
		System.out.println("Please enter the length of the rectangle.");
		//Assigns input to length variable.
		length = sc.nextInt();
		
		//Calculates and outputs the area and perimeter of the rectangle.
		System.out.println("When one side is " + width + " and the other side is " 
			+ length + ", the area is " + width * length + " and the perimeter is " 
			+ (2 * width + 2 * length+ "."));
	}
}