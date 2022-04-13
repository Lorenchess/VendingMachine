package Day5.ClassRoster.UI;

/*
 * All we have done is move the functionality for printing the menu and getting the user's selection
 * from the controller over to the view. Notice that we're using composition here — the ClassRosterView
 * has-a UserIO member and it uses UserIO to interact with the user.
 * Remember that UserIO is an interface. As we have mentioned, programming to interfaces
 * is a pattern that we'll use throughout the rest of the course.
 * ClassRosterView uses the public interface, UserIO, and is unaware of the implementation details
 * of the concrete implementation, UserIOConsoleImpl. In other words, ClassRosterView is unaware that it
 * is writing to and reading from the console, it only knows that it is interacting with the user.
 */

import Day5.ClassRoster.DTO.Student;

import java.util.List;

public class ClassRosterView {
    private UserIO io;

    //private UserIO io = new UserIOConsoleImpl(); //view are still tightly coupled to a specific implementation of the interface

    public ClassRosterView(UserIO io) {
        this.io = io;
    }

    public int printMenuAndGetSelection() {
        io.print("Main Menu");
        io.print("1. List Students");
        io.print("2. Create New Student");
        io.print("3. View a Student");
        io.print("4. Remove a Student");
        io.print("5. Exit");

        return io.readInt("Please select from the above choices.", 1, 5);
    }

    /**
     * This method prompts the user for Student ID, First Name, Last Name, and Cohort,
     * gathers this information, creates a new Student object, and returns it to the caller.
     * @return new Student object
     */

    public Student getNewStudentInfo() {
        String studentId = io.readString("Please enter Student ID");
        String firstName = io.readString("Please enter First Name");
        String lastName = io.readString("Please enter Last Name");
        String cohort = io.readString("Please enter Cohort");
        Student currentStudent = new Student(studentId);
        currentStudent.setFirstName(firstName);
        currentStudent.setLastName(lastName);
        currentStudent.setCohort(cohort);
        return currentStudent;
    }

    /**
     * Displays a banner or heading to the UI indicating that the next interactions
     * on the screen will be for creating a new student
     */

    public void displayCreateStudentBanner() {
        io.print("=== Create Student ===");
    }

    /**
     * Displays a message that the new student was successfully created and waits for the user
     * to hit Enter to continue
     */

    public void displayCreateSuccessBanner() {
        io.readString("Student successfully created.  Please hit enter to continue");
    }

    /**
     * Here we'll create a method that takes a list of Student objects as a parameter and displays
     * the information for each Student to the screen.
     * After the list has been displayed, the method will pause and wait for the user to hit the Enter key.
     * @param studentList
     */

    public void displayStudentList(List<Student> studentList) {
        for (Student currentStudent : studentList) {
            String studentInfo = String.format("#%s : %s %s",
                    currentStudent.getStudentId(),
                    currentStudent.getFirstName(),
                    currentStudent.getLastName());
            io.print(studentInfo);
        }
        io.readString("Please hit enter to continue.");
    }

    /**
     * Method to show the Display All Students banner
     */
    public void displayDisplayAllBanner() {
        io.print("=== Display All Students ===");
    }

    /**
     * Shows the Display Student banner
     */
    public void displayDisplayStudentBanner () {
        io.print("=== Display Student ===");
    }

    /**
     * Asks the user for the ID of the student he/she wishes to display
     * @return String id
     */
    public String getStudentIdChoice() {
        return io.readString("Please enter the Student ID.");
    }

    /**
     * displays a student's information to the user
     * @param student
     */
    public void displayStudent(Student student) {
        if (student != null) {
            io.print(student.getStudentId());
            io.print(student.getFirstName() + " " + student.getLastName());
            io.print(student.getCohort());
            io.print("");
        } else {
            io.print("No such student.");
        }
        io.readString("Please hit enter to continue.");
    }

    public void displayRemoveStudentBanner () {
        io.print("=== Remove Student ===");
    }

    public void displayRemoveResult(Student studentRecord) {
        if(studentRecord != null){
            io.print("Student successfully removed.");
        }else{
            io.print("No such student.");
        }
        io.readString("Please hit enter to continue.");
    }

    public void displayExitBanner() {
        io.print("Good Bye!!!");
    }

    public void displayUnknownCommandBanner() {
        io.print("Unknown Command!!!");
    }

    public void displayErrorMessage(String errorMsg) {
        io.print("=== ERROR ===");
        io.print(errorMsg);
    }
}