import java.util.Scanner;
import java.io.File;
import java.io.PrintStream;

public class HW5 {
    public static void main(String[] args) throws Exception {
        
        // Creates scanner object.
        Scanner scanner = new Scanner(new File("./vehicle-info.txt"));

        // Consumes the first line of the input which includes column titles: "Vehicle,Speed,Time".
        scanner.nextLine();

        // Sets the delimiter to a comma or a new line.
		scanner.useDelimiter(",|\n");
        

        while (scanner.hasNextLine()) {

            // Stores vehicle into String variable.
            String vehicle = scanner.next();
            // Converts speed and time values into integers and stores them in int variables.
            int speed = Integer.valueOf(scanner.next());
            int time = Integer.parseInt((scanner.next().trim()));

            /* Calls saveAsFile method to create a PrintStream object that points to a file named after vehicle
               and stores it in ps variable. */
            PrintStream ps = saveAsFile(vehicle);

            // Prints column headers into file.
            ps.printf("Hour\tDistance Traveled\n-------------------------\n");
           
            /* Calls distance method to calculate distance based on speed and time 
               and stores it into distanceInfo array variable. */
            String[] distanceInfo = distance(speed, time);

            // Iterates through the array containing distance information and prints each element into file.
            for (int i = 0; i < distanceInfo.length; i++) {
                // Prints hour and distance data into PrintStream object created for the approprate vehicle.
                ps.printf(distanceInfo[i] + "\n");
            }
        }

    }

    public static String[] distance(int speed, int time) {
        // Creates String array with size of time variable for storing distance based on each hour.
        String[] distanceInfo = new String[time];

        // Stores hour and distance data into the String array declared above.
        for (int i=0; i<time; i++) {
            distanceInfo[i] = " " + (i+1) + "\t" + "       " + speed*(i+1);
        }            
        return distanceInfo;
    }

    public static PrintStream saveAsFile(String fileName) throws Exception {
        
        // Returns PrintStream object attached to a file named after input.
        return new PrintStream(new File("./" + fileName + ".txt"));        
    }
}