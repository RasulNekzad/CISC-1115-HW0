import java.util.Arrays;

import javax.swing.plaf.basic.BasicTreeUI.SelectionModelPropertyChangeHandler;

public class HW4 {
    public static void main(String[] args) {
        
        // Declaring and initializing a String array and calling it with printElements method.
        String[] count = new String[]{"first", "second", "third", "fourth", "fifth",
                                      "sixth", "seventh", "eighth", "ninth", "tenth"};
        printElements(count);

        // Declaring and initializing a Time array of 3 elements and calling it with printElements method.
        Time[] times = new Time[]{
            new Time(1, 2, 3),
            new Time(4, 5, 6),
            new Time(7, 8, 9)};
        printElements(times);

        // Declaring 2D array.
        int[][] values = new int[10][20];
        // Prints number of rows in 2D array.
        System.out.println("This array has " + values.length + " rows.");
        // Prints number of columns in 2D array.
        System.out.println("This array has " + values[0].length + " columns.");
        // Calls printElements to print 2D array.
        printElements(values);
    }

    public static void basicArray() {
        
        int[] nums = new int[50];

        // Assign 1-50 to elements of array.
        for (int i=0; i<nums.length; i++) {
            nums[i] = i+1;
        }
        // Add 10 to each element of array.
        for (int i=0; i<nums.length; i++) {
            nums[i]+=10;
            System.out.println(nums[i]);
        }
    }

    public static void printElements(String[] stringArray) {
        
        for (int i=0; i<stringArray.length; i++) {
            // Prints each element. 
            System.out.print(stringArray[i]);
            // Prints length of each element.
            System.out.println(" : " + stringArray[i].length() + " characters long.");
        }
    }

    public static void printElements(int[][] matrix) {

        // Iterate through rows.
        for (int i=0; i<matrix.length; i++) {
            // Iterate through columns.
            for (int j=0; j<matrix[i].length; j++) {
                System.out.printf("%d ", matrix[i][j]);
            }
            System.out.println();
        }
    }

    public static void printElements(Time[] timeArr) {
        for (int i=0; i<timeArr.length; i++) {
            System.out.println(timeArr[i]);
        }
    }

    // Defines Time class.
    static class Time {
        private int hour;
        private int minute;
        private int second;

        public Time(int hour, int minute, int second) {
            this.hour = hour;
            this.minute= minute;
            this.second=second;
        }
        
        @Override
        public String toString() {
            return String.format("%02d:%02d:%02d", hour, minute, second);
        }
    }
}