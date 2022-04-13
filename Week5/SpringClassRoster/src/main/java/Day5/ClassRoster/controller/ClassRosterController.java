package Day5.ClassRoster.controller;

import Day5.ClassRoster.DAO.ClassRosterPersistenceException;
import Day5.ClassRoster.DTO.Student;
import Day5.ClassRoster.UI.ClassRosterView;
import Day5.ClassRoster.service.ClassRosterDataValidationException;
import Day5.ClassRoster.service.ClassRosterDuplicateIdException;
import Day5.ClassRoster.service.ClassRosterServiceLayer;

import java.util.List;


public class ClassRosterController {
    private ClassRosterView view;
    private ClassRosterServiceLayer service;


    /**
     * Constructor that initializes these members.
     * @param service
     * @param view
     */
    public ClassRosterController(ClassRosterServiceLayer service, ClassRosterView view) {
        this.service = service;
        this.view = view;
    }


    public void run() {
        boolean keepGoing = true;
        int menuSelection = 0;
      try{
          while (keepGoing) {

              menuSelection = getMenuSelection();

              switch (menuSelection) {
                  case 1:
                      listStudents();
                      break;
                  case 2:
                      createStudent();
                      break;
                  case 3:
                      viewStudent();
                      break;
                  case 4:
                      removeStudent();
                      break;
                  case 5:
                      keepGoing = false;
                      break;
                  default:
                      unknownCommand();
              }

          }
          exitMessage();
      }catch (ClassRosterPersistenceException e) {
          view.displayErrorMessage(e.getMessage());
      }

    }

    private int getMenuSelection() {
        return view.printMenuAndGetSelection();
    }

    private void createStudent() throws ClassRosterPersistenceException {
        view.displayCreateStudentBanner();
        boolean hasErrors = false;
        do {
            Student currentStudent = view.getNewStudentInfo();
            try {
                service.createStudent(currentStudent);
                view.displayCreateSuccessBanner();
                hasErrors = false;
            } catch (ClassRosterDuplicateIdException | ClassRosterDataValidationException e) {
                hasErrors = true;
                view.displayErrorMessage(e.getMessage());
            }
        } while (hasErrors);
    }

    private void listStudents() throws ClassRosterPersistenceException {
        view.displayDisplayAllBanner();
        List<Student> studentList = service.getAllStudents();
        view.displayStudentList(studentList);
    }


    private void viewStudent() throws ClassRosterPersistenceException {
        view.displayDisplayStudentBanner();
        String studentId = view.getStudentIdChoice();
        Student student = service.getStudent(studentId);
        view.displayStudent(student);
    }


    private void removeStudent() throws ClassRosterPersistenceException {
        view.displayRemoveStudentBanner();
        String studentId = view.getStudentIdChoice();
        Student removedStudent = service.removeStudent(studentId);
        view.displayRemoveResult(removedStudent);
    }

    /**
     * unknownCommand and exitMessage. These methods just ask the view to display the appropriate message to the user.
     */

    private void unknownCommand() {
        view.displayUnknownCommandBanner();
    }

    private void exitMessage() {
        view.displayExitBanner();
    }

}
