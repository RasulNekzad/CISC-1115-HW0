import java.util.Locale;
import java.util.Scanner;
import java.io.File;
import java.io.PrintStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class HW3Program3 {
    public static void main(String[] args) throws Exception {
        
		Scanner scanner = new Scanner(new File("./records.txt"));
        PrintStream ps = new PrintStream("./records-output.txt");

        // Creates local date time object to store current unformatted exact time.
        LocalDateTime ldt = LocalDateTime.now();
        // Converts local date time to formatted string in the form "MM-dd-yyyy."
        String dtf = DateTimeFormatter.ofPattern("MM-dd-yyyy", Locale.ENGLISH).format(ldt);

        // Splits the formatted date into month, day and year and stores in array.
        String[] dateVals = dtf.split("-");
        // Stores array values for month, day and year in appropriate variables.
        int currMonth = Integer.parseInt(dateVals[0]);
        int currDate = Integer.parseInt(dateVals[1]);
        int currYear = Integer.parseInt(dateVals[2]);

        int[] daysPerMonth = new int[]{
            0,
            31, // January
            28, // February
            31, // March
            30, // April
            31, // May
            30, // June
            31, // July
            31, // August
            30, // September
            31, // October
            30, // November
            31, // December
        };

        while (scanner.hasNext()) {
            // Splits scanned line at the hyphen to separate month, date, and year values.  Stores them in array.
            String [] dateVals2 = scanner.next().split("-");
            
            //Assigns split values to input variables.
            int inputMonth = Integer.parseInt(dateVals2[0]);
            int inputDate = Integer.parseInt(dateVals2[1]);
            int inputYear = Integer.parseInt(dateVals2[2]);

            // Declare year with placeholder value which will be replaced.
            int year = -1;
            int month = currMonth - inputMonth;
            
            // Handles case where full year has elapsed or it's the same year.
            if (currMonth > inputMonth) {
                year = currYear - inputYear;
                if (month < 0) {
                    month+=12;
                }

            // Handles case where full year hasn't elapsed (assuming year diff > 1) 
            // and not same year. 
            } else {
                year = currYear - inputYear -1;
                if (month <= 0) {
                    month+=11;
                }
            }

            int date = currDate - inputDate + daysPerMonth[Integer.valueOf(inputMonth)];
            
            // Prints to output file, "records-output.txt".
            ps.printf("This record is " + year + " year(s), " + month + " month(s), and " + date + " day(s) old.\n");

            // Prints to console.
            System.out.println("This record is " + year + " year(s), " + month + " month(s), and " + date + " day(s) old.");
        }
    }
}

