import java.io.IOException;
import java.util.Scanner;
import java.io.File;

public class HW8Program1 {

  public static void main(String[] args) throws IOException {
    // ["file1.txt", "file2.txt", "file3.txt"]
    for (int i = 0; i < args.length; i++) {  // Iterates through every text file read in from command line.
      Scanner sc = new Scanner(new File(args[i]));  // Creates scanner object that scans through given file.
      int wordCount = 0;  // Variable that keeps track of word count.
      // Consumes every word and increments wordCount for each word.
      while (sc.hasNext()) {
        sc.next();
        wordCount++;
      }
      // Prints word count.
      System.out.println(args[i] + " contains " + wordCount + " words.");
    }
  }
}
