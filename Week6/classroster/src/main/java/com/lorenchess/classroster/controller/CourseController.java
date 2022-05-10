package com.lorenchess.classroster.controller;


import com.lorenchess.classroster.dao.CourseDao;
import com.lorenchess.classroster.dao.StudentDao;
import com.lorenchess.classroster.dao.TeacherDao;
import com.lorenchess.classroster.entity.Course;
import com.lorenchess.classroster.entity.Student;
import com.lorenchess.classroster.entity.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
public class CourseController {
    @Autowired
    TeacherDao teacherDao;

    @Autowired
    StudentDao studentDao;

    @Autowired
    CourseDao courseDao;

    @GetMapping("courses")
    public String displayCourses(Model model) {
        List<Course> courses = courseDao.getAllCourses();
        List<Teacher> teachers = teacherDao.getAllTeachers();
        List<Student> students = studentDao.getAllStudents();
        model.addAttribute("courses", courses);
        model.addAttribute("teachers", teachers);
        model.addAttribute("students", students);
        return "courses";
    }

    @GetMapping("courseDetail")
    public String courseDetail(Integer id, Model model) {
        Course course = courseDao.getCourseById(id);
        model.addAttribute("course", course);
        return "courseDetail";
    }

    @GetMapping("deleteCourse")
    public String deleteCourse(Integer id) {
        courseDao.deleteCourseById(id);
        return "redirect:/courses";
    }

    /**
     * We start with the @GetMapping for editCourse.
     * Similar to the Course Details page, we take in both the ID and the Model.
     * We get our Course as well as the lists of Students and Teachers so we can display all of them for the Edit.
     * We put those three variables into the Model.
     * Finally, we return editCourse, taking us to the editCourse.html template we are about to create.
     * Similar to the Add Course form, our Edit Course form will require all the Teachers and all the Students so we can potentially change both. Our Edit Course page will let us choose a new Teacher and change the Students that are selected.
     * */

    @GetMapping("editCourse")
    public String editCourse(Integer id, Model model) {
        Course course = courseDao.getCourseById(id);
        List<Student> students = studentDao.getAllStudents();
        List<Teacher> teachers = teacherDao.getAllTeachers();
        model.addAttribute("course", course);
        model.addAttribute("students", students);
        model.addAttribute("teachers", teachers);
        return "editCourse";
    }

    /**
     * We make our @PostMapping for editCourse.
     * We pull in a Course object for the simple data (ID, name, description) and the HttpServletRequest for the more complicated data (Teacher, Students).
     * We get our teacherId and array of studentIds out of the HttpServletRequest.
     * We first set the Teacher using the teacherId to retrieve the Teacher from its DAO.
     * We loop through the studentIds and fill a list of Students that we retrieve from the Student DAO.
     * We then set our Students with the list we filled in the loop.
     * Next, we call our updateCourse method in the Course DAO.
     * Finally, we redirect back to the main Courses page.
     * Once again, the main thing to remember is how we can use the HttpServletRequest to get the IDs out of the form. As long as we have an ID, we can get the full object to add it to the Course.
     * */

    /**
     * Validation: To start, we indicate that we are validating the simple Course fields with the @Valid annotation.
     * We then add in the BindingResult directly after the Course; the BindingResult must follow whatever we are validating in order to work.
     * At the end, we also add in a Model. This page needs extra information to display, the list of Teachers and the list of Students, so we need the Model to get the data back out there if we have validation errors.
     * We pull in our Teacher and Student IDs like usual and set the Teacher, but before we create the students we need to check if studentIds is null. If no Students were selected, that field will come in as null and our enhanced for loop will throw an exception.
     * If it's not null, we proceed like normal; but if it is null, we create a new type of object, a FieldError. The BindingResult uses FieldErrors to keep track of which field has errors in our object. Lucky for us, we can create our own FieldError and add it to the BindingResult. We create one for our students field and give it a message to print out on the page.
     * We now put our list of Students into the Course; if it was null, it should just be an empty list.
     * Now we can check if our BindingResult has any errors. If it does, we need to put some data into our Model: the list of Teachers, the list of Students, and finally the Course that was passed in. Normally we don't need to do this – the object we are validating goes back out automatically – but because we are putting data into the Model ourselves, we need to include it here. Once the data is in, we return to the editCourse page.
     * Finally, if there were no errors, we finish the update and go back to the main Courses page.
     * */

    @PostMapping("editCourse")
    public String performEditCourse(@Valid Course course, BindingResult result, HttpServletRequest request, Model model) {
        String teacherId = request.getParameter("teacherId");
        String[] studentIds = request.getParameterValues("studentId");

        course.setTeacher(teacherDao.getTeacherById(Integer.parseInt(teacherId)));

        List<Student> students = new ArrayList<>();
        if(studentIds != null) {
            for(String studentId : studentIds) {
                students.add(studentDao.getStudentById(Integer.parseInt(studentId)));
            }
        } else {
            FieldError error = new FieldError("course", "students", "Must include one student");
            result.addError(error);
        }

        course.setStudents(students);

        if(result.hasErrors()) {
            model.addAttribute("teachers", teacherDao.getAllTeachers());
            model.addAttribute("students", studentDao.getAllStudents());
            model.addAttribute("course", course);
            return "editCourse";
        }

        courseDao.updateCourse(course);

        return "redirect:/courses";
    }
}
