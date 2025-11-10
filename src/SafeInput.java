import java.util.Scanner;

public class SafeInput {

    // Static methods go here

    public static String getNonZeroLenString(Scanner pipe, String prompt) {
        String retString = "";
        do {
            System.out.print("\n" + prompt + ": "); // show prompt
            retString = pipe.nextLine(); // read user input
        } while (retString.length() == 0); // loop until input is not empty
        return retString; // return valid string
    }

    public static int getInt(Scanner pipe, String prompt) {
        int value = 0;
        boolean valid = false;

        do {
            System.out.print(prompt + ": "); // show prompt

            if (pipe.hasNextInt()) {
                value = pipe.nextInt(); // read valid int
                valid = true;
            } else {
                String trash = pipe.nextLine(); // read and discard invalid input
                System.out.println("Invalid input. Enter an integer: " + trash);
            }
            pipe.nextLine(); // clear newline after reading int
        } while (!valid);
        return value;
    }

    public static double getDouble(Scanner pipe, String prompt) {
        double value = 0;
        boolean valid = false;

        do {
            System.out.print(prompt + ": "); // show prompt

            if (pipe.hasNextDouble()) {
                value = pipe.nextDouble(); // read valid double
                valid = true;
            } else {
                String trash = pipe.nextLine(); // read and discard invalid input
                System.out.println("Invalid input. Enter a double: " + trash);
            }
            pipe.nextLine(); // again clear newline after reading double
        } while (!valid);
        return value;
    }

    public static int getRangedInt (Scanner pipe, String prompt, int low, int high) {
        int value = 0;
        boolean valid = false;

        do {
            // show prompt with specified range
            System.out.println(prompt + "[" + low + " - " + high + "]: ");
            // check if the next input is an integer
            if (pipe.hasNextInt()) {
                value = pipe.nextInt(); // read the integer

                // check if it's within range
                if (value >= low && value <= high) {
                    valid = true; // input is valid-exit loop
                } else {
                    // input is outside the range
                    System.out.println("input outside of range. Try again.");
                }
            } else {
                String trash = pipe.nextLine(); // trash invalid inputs
                System.out.println("Invalid input. Enter a integer: " + trash);
            }
            pipe.nextLine(); // clear leftover newline
        } while (!valid); // repeat until valid input is received
        return value;
    }

    public static double getRangedDouble (Scanner pipe, String prompt, double low, double high) {
        double value = 0; // stores final valid output
        boolean valid = false; // controls the loop until valid output is read

        do {
            // show prompt with allowed range
            System.out.println(prompt + "[" + low + " - " + high + "]: ");

            // check if next input is a valid double
            if (pipe.hasNextDouble()) {
                value = pipe.nextDouble(); // read double

                // check if it's within range
                if (value >= low && value <= high) {
                    valid = true; // input is valid, exit loop
                } else {
                    // input is outside the range
                    System.out.println("input outside of range. Try again.");
                }
            } else {
                // input is not a double-read and discard
                String trash = pipe.nextLine();
                System.out.println("Invalid input. Enter a double: " + trash);
            }
            pipe.nextLine(); // clear buffer
        } while (!valid); // repeat until valid input received
        return value;
    }

    public static boolean getYNconfirm (Scanner pipe, String prompt) {
        String response = "";
        boolean valid = false;
        do {
            System.out.println(prompt + " Y/N: ");
            response = pipe.nextLine().trim(); // trim white space

            if (response.equalsIgnoreCase("Y")) {
                return true; // user confirmed
            } else if (response.equalsIgnoreCase("N")) {
                return false; // user declined
            } else {
                System.out.println("Invalid input. Enter Y or N.");
            }
        } while (!valid); // loop until valid input
        return false;
    }

    public static String getRegExString(Scanner pipe, String prompt, String regEx) {
        String response = "";
        boolean valid = false;

        do {
            System.out.print(prompt + ": ");
            response = pipe.nextLine();

            if (response.matches(regEx)) {
                valid = true; // Input matches pattern
            } else {
                System.out.println("Input does not match expected format. Try again.");
            }
        } while (!valid);
        return response;
    }
}
