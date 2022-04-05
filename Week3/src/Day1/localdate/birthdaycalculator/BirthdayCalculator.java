package Day1.localdate.birthdaycalculator;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class BirthdayCalculator {
    private LocalDate ld = LocalDate.now();
    private LocalDate ldBirthday;
    private String birthday;
    private String birthdayDayNow;
    private String birthdayDay;
    private int daysTillBirthday;
    private int yearsOld;



    private void print(String prompt) {
        System.out.println(prompt);
    }

    private String getUserInput(String prompt) {
        String userInput = null;
        print(prompt);
        try (Scanner sc = new Scanner(System.in)) {
            userInput = sc.nextLine();
        }catch (Exception e) {
            System.out.println("Invalid input");
        }
        return userInput;
    }

    public void calculateDates() {
        int daysBetween;
        //ask for day of week birthday
        //ask day of week this year
        //how many days until birthday this year
        //how many years turning
        String userInput = getUserInput("What's your birthday? mm/dd/yyyy");
        ldBirthday = LocalDate.parse(userInput, DateTimeFormatter.ofPattern("MM/dd/yyyy")); //Date of birthday
        birthdayDay = ldBirthday.getDayOfWeek().toString(); //day of week birthday //OK

        Period age = Period.between(ldBirthday,ld);

        yearsOld = age.getYears(); //how old is the person //OK

        int day = ldBirthday.getDayOfMonth(); //my day of birthday (25);

        int today = ld.getDayOfMonth(); //4
        if (today <= day ) {
            daysTillBirthday = day - today;
        } else {
            daysTillBirthday = 360 - (today - day);
        }

        birthdayDayNow = ld.plusDays(daysTillBirthday).getDayOfWeek().toString();

    }

    public void printResults() {
        print("Welcome to the Magical BirthDAY Calculator!");
        calculateDates();
        print("That's means you were born on a " + birthdayDay);
        print("This year it falls on a " + birthdayDayNow + "...");
        print("And since today is " +ld + ", there's only " + daysTillBirthday + " more days until the next one!");
        print("Be excited to be turning " + (yearsOld + 1)+"!");
    }













}
