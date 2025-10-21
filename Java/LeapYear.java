package Java;
import java.util.Scanner;

public class LeapYear {

    public static String isLeap(int year) {
        boolean isLeapYear;

        isLeapYear = ((year % 100 != 0) && (year % 4 == 0));
        isLeapYear = isLeapYear || ((year % 400 == 0));

        if (isLeapYear) return "Leap Year";
        else return "Regular Year";

    }

    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);

        // prints out message to user
        System.out.print("Enter a year: ");

        // get integer from keyboard entry
        int year = userInput.nextInt();
        userInput.close();

        System.out.println(isLeap(year));

    }
}