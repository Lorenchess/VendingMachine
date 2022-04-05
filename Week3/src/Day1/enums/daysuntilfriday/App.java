package Day1.enums.daysuntilfriday;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        printDaysUntilFriday();
    }
    private static String getUserInput(String prompt) {
        String userInput = null;
            try(Scanner sc = new Scanner(System.in)) {
                printMsg(prompt);
                userInput = sc.nextLine();
                userInput = userInput.toUpperCase();

            }catch (Exception e){
                printMsg("Invalid input for day of the week" + e);
            }
        return userInput;
    }

    private static void printMsg(String msg) {
        System.out.println(msg);
    }

    private static int getDaysUntilFriday(DaysOfTheWeek day) {
       final int totalOfDays = DaysOfTheWeek.values().length;
        if(day.ordinal() > DaysOfTheWeek.FRIDAY.ordinal()){
            printMsg("There is "+ totalOfDays + " day(s) until " + DaysOfTheWeek.FRIDAY);
            return totalOfDays;
        } else {
            int days = DaysOfTheWeek.FRIDAY.ordinal()- day.ordinal();
            printMsg("There is "+ days + " day(s) until " + DaysOfTheWeek.FRIDAY);
            return days;
        }

    }

    public static void printDaysUntilFriday() {

        printMsg("Find out how many days until Friday");

            try{
                String userDay =  getUserInput("Type a day of the week: ");
                switch (DaysOfTheWeek.valueOf(userDay)) {
                    case SUNDAY:
                    case MONDAY:
                    case TUESDAY:
                    case WEDNESDAY:
                    case THURSDAY:
                    case FRIDAY:
                    case SATURDAY:
                        getDaysUntilFriday(DaysOfTheWeek.valueOf(userDay));
                        break;
                    default: throw new IllegalArgumentException();

                }
            } catch (Exception e) {
                printMsg("Invalid input for day of the week.");

            }

    }
}
