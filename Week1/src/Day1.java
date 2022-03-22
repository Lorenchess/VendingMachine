/**
 * @author Ramon Lorente
 * date: Mar 21st, 2022
 * purpose: My Java Basics program
 * mThree c184
 */

public class Day1 {
    public static void main(String[] args) {

        //Print statements
        System.out.println("My name is Ramon Lorente.");
        System.out.print("My Star Wars name is LorRa MaCu. ");
        System.out.println("Day 1 of training");

        //Variables/Data Types
       boolean isEmployee = false;
       char letter = 'm';
       String course = "Three";
       int myJavaLevel = 5;
       double trainingHoursPerWeek = 40.0;
        System.out.println("IsEmployee: " + isEmployee + " " + letter + course + " My Java Level: " + myJavaLevel + " Total Hrs/Week: " + trainingHoursPerWeek);

      //Expressions
        int numberOfWeeksInTraining = 7;
        int numberOfPaidHours = 8; //8 hours a day
        int numberOfClassHours = 6; // 10a -4pm
        int result = 0; //Hold my result throughout my different expressions

      // - Subtraction -Find ou how many hours self study after class you have
        result = numberOfPaidHours - numberOfClassHours;
        System.out.println("\nSelf Study Hours after Class:\t " + result + " hrs to finish work");

      // + and *
      result = numberOfWeeksInTraining * (int) trainingHoursPerWeek;
        System.out.println("Total hrs in this training : " + result + " hours.");

        //Add in 2 days for week 8 (Mon & Tue)
        result += 12; //result + 2 days (8hr day)
        System.out.println(result);
      // / & %
      int totalTrainingHrs = result;
      result = totalTrainingHrs / numberOfPaidHours;
        System.out.println("TotalHours(" + totalTrainingHrs+")/" + numberOfPaidHours + " = " + result);

        //Modulus % Remainder
        result = totalTrainingHrs% 8;
        System.out.println("TotalHours(" +totalTrainingHrs + ") % 8 = " + result);



    }
}
