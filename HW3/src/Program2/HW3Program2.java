import java.util.Scanner;

public class HW3Program2 {
    public static void main(String[] args) {
        
        // Creates scanner object.
        Scanner sc = new Scanner(System.in);
        // Declares and intializes shape variable for storing user input.
        String shape;
        // Prompts user to select a shape.
        System.out.println("Please choose from either a circle or a rectangle.");
        // Assigns input to shape variable.
        shape = sc.next();
        
        // Runs the following if the user selected circle.
        if (shape.equals("circle")) {
            
            // Prompts user to enter radius.
            System.out.println("Please enter the radius of the circle.");
            // Assigns input to radius variable.
            int radius = sc.nextInt();

            //Area = pi * radius^2 
		    double area = Math.PI * (radius * radius);
            /*Calculates and outputs circumference and area.  
		    Circumference = 2 * pi * radius.  */
		    double circumference = 2 * Math.PI * radius;
		
		    System.out.println("When the radius is " + radius + " the area is " 
				+ String.format("%.2f", area) + " and the circumference is " 
				+ String.format("%.2f", circumference) + ".");
         }

        // Runs the following if the user selected rectangle.
        if (shape.equals("rectangle")) {
            
            //Prompts user to enter width.
		    System.out.println("Please enter the width of the rectangle.");
		    //Assigns input to width variable.
		    int width = sc.nextInt();
		
		    //Prompts user to enter length.
		    System.out.println("Please enter the length of the rectangle.");
		    //Assigns input to length variable.
		    int length = sc.nextInt();
		
		    //Calculates and outputs the area and perimeter of the rectangle.
		    System.out.println("When one side is " + width + " and the other side is " 
			    + length + ", the area is " + width * length + " and the perimeter is " 
			    + (2 * width + 2 * length+ "."));
        }   
   }
}
