package Java;


import java.util.Scanner;

public class HoursMinutesSeconds
{
    public static void main(String[] args) {

        Scanner myObj = new Scanner(System.in);  // Scanner object
        System.out.print("Enter number of seconds: ");
        String userInputString = myObj.nextLine();  // method to read user input
        int userInputInt = myObj.nextInt(); // another method to read user input
    }

    static String getTime(int seconds) {
        int hours = getHours(seconds);
        int secondsLeft = seconds - (hours * 3600);
        int minutes = getMinutes(secondsLeft);
        secondsLeft = secondsLeft - (minutes * 60);
        return hours + ":" + minutes + ":" + secondsLeft;
    }

    static int getHours(int seconds) {
        return seconds/3600;
    }

    static int getMinutes(int seconds) {
        return seconds/60;
    }


}