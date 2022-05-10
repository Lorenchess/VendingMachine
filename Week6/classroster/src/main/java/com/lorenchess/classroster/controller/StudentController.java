package com.lorenchess.classroster.controller;

import com.lorenchess.classroster.dao.CourseDao;
import com.lorenchess.classroster.dao.StudentDao;
import com.lorenchess.classroster.dao.TeacherDao;
import com.lorenchess.classroster.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
public class StudentController {
    @Autowired
    TeacherDao teacherDao;

    @Autowired
    StudentDao studentDao;

    @Autowired
    CourseDao courseDao;

    @GetMapping("students")
    public String displayStudents(Model model) {
        List<Student> students = studentDao.getAllStudents();
        model.addAttribute("students", students);
        return "students";
    }

    /**
     * We start by declaring our @PostMapping of Students.
     * Instead of pulling in the HttpServletRequest and then pulling out the data, we are bringing the data in directly as parameters of the method. To do this, the name of the parameter has to match the name in the form exactly. Here, firstName in the form is String firstName in the method parameters.
     * With the data pulled in, we create our Student object and save it.
     * We then redirect back to the main Students page.
     * Pulling data directly by its name in the form can be useful because it eliminates a step in the process of handling the form data. One potential disadvantage is if you have many form fields to read in, your method signature can get very long. If that's the case, there is yet a third way we can pull in that data that we'll look at for editing Students.
     * */

    @PostMapping("addStudent")
    public String addStudent(String firstName, String lastName) {
        Student student = new Student();
        student.setFirstName(firstName);
        student.setLastName(lastName);
        studentDao.addStudent(student);

        return "redirect:/students";
    }

    /**
     * Because we are using a link to trigger this action, it is a GET mapping for deleteStudent.
     * We don't use HttpServletRequest here, either. Instead, we can pull in the data from the URL using the key, id in this case.
     * We know it should be a number, so we pull it in as an integer. We use Integer instead of int because an Integer can accept a null value, so if no id was sent we can deal with it in the method if we want.
     * Once we have the ID, we call our DAO delete method and redirect back to the main Students page.
     * */

    @GetMapping("deleteStudent")
    public String deleteStudent(Integer id) {
        studentDao.deleteStudentById(id);
        return "redirect:/students";
    }

    /**
     *
     * We declare our @GetMapping for editStudent.
     * We take the ID directly from the URL and bring in a Model so we can send data to the page.
     * We use the ID to get the Student and add it to the Model.
     * Finally, we return to editStudent, which will send us to an editStudent.html template that
     * we will create next.
     * */


    @GetMapping("editStudent")
    public String editStudent(Integer id, Model model) {
        Student student = studentDao.getStudentById(id);
        model.addAttribute("student", student);
        return "editStudent";
    }

    /**
     * We create a @PostMapping for editStudent.
     * Because the fields in our form match up exactly with the fields in our Student object,
     * we can pull the entire form in as a Student object. This only works for input fields where
     * the name matches the name of a field in the Student class. Any input where the name
     * doesn't match up will have to be pulled in separately, either using its name as a parameter
     * or through the HttpServletRequest. If any fields are missing from the form, those will
     * be left blank in the object you pull in.
     * We have the full object right away, so we can call our DAO update method and redirect
     * back to the main Students page.
     * */
     /**
      * Because the POST mapping for editStudent takes in the full Student object, we don't need
      * to create a Validator to validate the data.
      * we add the @Valid annotation before the Student object to indicate it should be validated.
      * We add the BindingResult to the parameter list to hold the results of the validation.
      * Inside the method, we check if the BindingResult has any errors in it. If it does, we go back to the editStudent page directly.
      * If no error was found, we update the Student and redirect back to the main Student page like normal.
      * */

    @PostMapping("editStudent")
    public String performEditStudent(@Valid Student student, BindingResult result) {
        if(result.hasErrors()) {
            return "editStudent";
        }
        studentDao.updateStudent(student);
        return "redirect:/students";
    }

    /**
     * We now know three different ways to pull in form data: through the HttpServletRequest,
     * as individual method parameters, or as a full object.
     * The HttpServletRequest can always be used as a fallback if the others won't work
     * because it will always pull in the data as a string and let you modify it from there.
     * The other two need a little more care to work with, but can be more efficient.
     * It's up to you to decide which one is appropriate for the work you are doing.
     * */
}
