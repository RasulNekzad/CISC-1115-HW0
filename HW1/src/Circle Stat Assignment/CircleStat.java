import java.util.Scanner;

public class CircleStat {

	public static void main(String[] args) {
		//Creates scanner object.
		Scanner sc = new Scanner(System.in);
		
		//Declares radius variable.
		int radius;
		
		//Prompts user to enter a radius value.
		System.out.println("Please enter the radius of the circle.");
		//Assigns input to radius variable.
		radius = sc.nextInt();
		
		/*Calculates and outputs circumference and area.  
		Circumference = 2 * pi * radius.  */
		double circumference = 2 * Math.PI * radius;
		//Area = pi * radius^2 
		double area = Math.PI * (radius * radius);
		
		System.out.println("When the radius is " + radius + " the circumference is " 
				+ String.format("%.2f", circumference) + " and the area is " 
				+ String.format("%.2f", area) + ".");
	}
}
