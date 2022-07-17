import java.util.Scanner;

class Month {

    int monthNumber;

    // Constructor that sets monthNumber to 1.
    public Month() {
        monthNumber = 1;
    }

    // Constructor setting monthNumber to inputted value.  
    public Month(int monthNumber) throws MonthNumberException {

        // Throws custom MonthNumberException when value is less than 1 or more than 12. 
        if (monthNumber < 1 || monthNumber > 12) {
            this.monthNumber = 1;
            throw new MonthNumberException("Not a valid number for month: " + monthNumber);
        } else {
            this.monthNumber = monthNumber;
        }
    }

    // Constructor that sets the value of monthNumber based on the inputted String monthName.
    public Month(String monthName) throws MonthNameException {

        switch(monthName) {
            case "January": monthNumber = 1;
            break;
            case "February": monthNumber = 2;
            break;
            case "March": monthNumber = 3;
            break;
            case "April": monthNumber = 4;
            break;
            case "May": monthNumber = 5;
            break;
            case "June": monthNumber = 6;
            break;
            case "July": monthNumber = 7;
            break;
            case "August": monthNumber = 8;
            break;
            case "September": monthNumber = 9;
            break;
            case "October": monthNumber = 10;
            break;
            case "November": monthNumber = 11;
            break;
            case "December": monthNumber = 12;
            break;
            // In all other cases, throws MonthNameException.
            default: throw new MonthNameException(monthName + " is not a valid month name.");
        }
    }

    // Sets monthNumber according to input.  Sets to 1 when value not in 1-12 range is entered.
    public void setMonthNumber(int monthNum){
        
        if (monthNum < 1 | monthNum > 12) {
            monthNumber = 1;
        } else {
            monthNumber = monthNum;
        }
    }

    public int getMonthNumber() {
        return monthNumber;
    }

    // Returns name of the month based on monthNumber.
    public String getMonthName() {
        String monthName = "";
        switch(monthNumber) {
            case 1: monthName = "January";
            break;
            case 2: monthName = "February";
            break;
            case 3: monthName = "March";
            break;
            case 4: monthName = "April";
            break;
            case 5: monthName = "May";
            break;
            case 6: monthName = "June";
            break;
            case 7: monthName = "July";
            break;
            case 8: monthName = "August";
            break;
            case 9: monthName = "September";
            break;
            case 10: monthName = "October";
            break;
            case 11: monthName = "November";
            break;
            case 12: monthName = "December";
            break;
        }
        return monthName;
    }

    // Returns name of the month as a String.
    public String toString() {
        return getMonthName();
    }

    /* Compares the monthNumber values of two Month objects 
       and returns true or false according to whether they're equal. */
    public boolean equals(Month month) {
        if (month.getMonthNumber() == this.getMonthNumber()) {
            return true;
        } else {
            return false;
        }
    }
}

/* Defining custom exception, MonthNumberException to be thrown when 
   Month(int monthNumber) constructor receives invalid input for monthNumber parameter. */
class MonthNumberException extends RuntimeException {
    public MonthNumberException(String message) {
        super(message);
    }
}

/* Defining custom exception, MonthNameException to be thrown when 
   Month(String monthName) constructor receives invalid input for monthName parameter. */
class MonthNameException extends RuntimeException {
    public MonthNameException(String message) {
        super(message);
    }
}

class MonthDays extends Month {

    private int year;

    // Constructor setting the inherited monthNumber variable to inputted month and year variable to inputted year.
    public MonthDays(int month, int year) {
        super(month);
        this.year = year;
    }

    public int getNumberOfDays() {
        /* Declaring and intializing the int variable to be returned by the method, 
           representing the number of days in a month. */
        int days = 0;
        // When year is divisible by 100, ...
        if (year%100 == 0) {
            // ... if it's also divisible by 400, ...
            if (year%400 == 0) {
                // ... and the month is February...
                if (monthNumber == 2) {
                    // ... then return 29, the number of days in a leap year.
                    return 29;
                }
            }
          // Otherwise if year is divisible by 4, ...
        } else if (year%4 == 0) {
            // ... and the month is February...
            if (monthNumber == 2) {
                // ... then return 29, the number of days in a leap year.
                return 29;
            }
        }
        // Sets number of days to 31 for following months:
        if (monthNumber==1 | monthNumber==3| monthNumber==5| monthNumber==7| monthNumber==8 | monthNumber==10 | monthNumber==12) {
            days = 31;
        }
        // Sets number of days to 28 for February (when not a leap year).
        else if (monthNumber==2) {
            days = 28;
        }
        // Sets number of days to 30 for all other months.
        else {
            days =30;
        }
        return days;
    }
}

// Demonstration for MonthDays class.
public class HW6 {
    public static void main(String[] args) {
        
        // Creates scanner object to receive user input.
        Scanner sc = new Scanner(System.in);

        // Prompts user for month value represented by a number.
        System.out.print("Please enter a month (1-12): ");
        // Converts user input to int and sets it equal to month variable.
        int month = Integer.valueOf(sc.next());

        // Prompts user for year.
        System.out.print("Please enter a year: ");
        // Converts user input to int and sets it equal to year variable.
        int year = Integer.valueOf(sc.next());

        // Creates MonthDays object based on user input.
        MonthDays md = new MonthDays(month, year);
        // Prints the number of days for the month in the year entered by user.
        System.out.println(md.getMonthName() + " " + year + " has " + md.getNumberOfDays() + " days.");
    }
}