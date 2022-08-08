import java.util.Arrays;
import java.util.Scanner;

public class HW8Program2 {

  public static void main(String[] args) {
    System.out.println("Welcome to the calculator program, please enter 0 to stop. Enjoy!");
    while (true) {
      Scanner sc = new Scanner(System.in);
      String expression = "";  // Declares and initializes String variable expression to hold user input.
      boolean isFirstAttempt = true;  // In the first attempt of entering a valid expression.

      do {
        if (!isFirstAttempt) {  // If an invalid expression was entered, prompts user to enter valid expression.
          System.out.println("Please enter a valid expression. (e.g. 7 * 3)");
        }
        System.out.print("Please enter an expression > ");  // Prompts user for input.
        expression = sc.nextLine();  // Stores in expression variable.
        isFirstAttempt = false;  // Sets isFirstAttempt to false since user is no longer at first attempt.
      } while (!isValid(expression));  // If entered expression is invalid, reruns the code in the do-block.

      // Ends the program if the user enters "0".
      if (expression.charAt(0) == '0' && expression.length() == 1) {
        System.out.println("Entered 0. Exiting program.");
        break;
      }
      // Checks the operator in the expression and perform appropriate operation.
      if (expression.contains("+")) {
        String[] parsedInput = expression.split("\\+"); // Splits expression at operator and stores in array.
        double result =
            Double.parseDouble(parsedInput[0]) + Double.parseDouble(parsedInput[1]);  // Performs calculation.
        System.out.println(String.format("Result: %f", result));  // Prints result.
      } else if (expression.contains("*")) {
        String [] parsedInput = expression.split("\\*");
        double result =
            Double.parseDouble(parsedInput[0]) * Double.parseDouble(parsedInput[1]);
        System.out.println(String.format("Result: %f", result));
      } else if (expression.contains("-")) {
        String [] parsedInput = expression.split("-");
        double result =
            Double.parseDouble(parsedInput[0]) - Double.parseDouble(parsedInput[1]);
        System.out.println(String.format("Result: %f", result));
      } else if (expression.contains("/")) {
        String [] parsedInput = expression.split("/");
        double result =
            Double.parseDouble(parsedInput[0]) / Double.parseDouble(parsedInput[1]);
        System.out.println(String.format("Result: %f", result));
      }
      System.out.println("Please enter 0 to exit program.");
    }
  }

  // Method that verifies validity of inputted expression.
  private static boolean isValid(String expression) {
    expression = expression.trim();  // Trims white space to aid verification process.

    // Since entering 0 ends the program, this statement allows an input of "0"
    // to be considered valid, even without an operator.
    if (expression.charAt(0) == '0' && expression.length() == 1) {
      return true;
    }

    if (!Character.isDigit(expression.charAt(0)) ||  // Checks if 0 index of expression is digit.
        !containsOperator(expression) ||  // Calls containsOperator to check whether expression includes operator.
        !Character.isDigit(expression.charAt(expression.length()-1))) {  // Checks if last index of expression is digit.
      return false;
    }
    return true;
  }

  // Method that checks whether inputted expression contains an operator.
  private static boolean containsOperator(String expression) {
    final String operators = "+-*/"; // Operators to be checked for.
    for (char c : expression.toCharArray()) {  // Iterates through inputted expression turned into an array of characters.
      if (operators.contains(String.valueOf(c))) {  // Checks whether an operator exists in the expression.
        return true;
      }
    }
    return false;
  }
}
