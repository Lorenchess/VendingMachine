package com.lorenchess.classroster.controller;

import com.lorenchess.classroster.dao.CourseDao;
import com.lorenchess.classroster.dao.StudentDao;
import com.lorenchess.classroster.dao.TeacherDao;
import com.lorenchess.classroster.entity.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
public class TeacherController {

    Set<ConstraintViolation<Teacher>> violations = new HashSet<>();

    @Autowired
    TeacherDao teacherDao;

    @Autowired
    StudentDao studentDao;

    @Autowired
    CourseDao courseDao;

    @GetMapping("teachers")
    public String displayTeachers(Model model) {
        List<Teacher> teachers = teacherDao.getAllTeachers();
        model.addAttribute("teachers", teachers);
        model.addAttribute("errors", violations);
        return "teachers";
    }

    @PostMapping("addTeacher")
    public String addTeacher(HttpServletRequest request) {
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String specialty = request.getParameter("specialty");

        Teacher teacher = new Teacher();
        teacher.setFirstName(firstName);
        teacher.setLastName(lastName);
        teacher.setSpecialty(specialty);

        /*
        * We instantiate our Validator object.
          We then pass the full Teacher object into the Validator and save the results in a “violations” class variable.
          We then check if we found any validation errors; if not, we add the Teacher.
        * */

        Validator validate = Validation.buildDefaultValidatorFactory().getValidator();
        violations = validate.validate(teacher);

        if(violations.isEmpty()) {
            teacherDao.addTeacher(teacher);
        }

        return "redirect:/teachers";
    }

    /**
     * Because this is working off of a link, we need it to be a @GetMapping for deleteTeacher.
     * To pull in the ID from the URL, we use the HttpServletRequest to get that parameter.
     * Once we have the ID, we use the DAO to delete the Teacher.
     * Finally, we redirect the browser back to the main Teachers page.
     * */

    @GetMapping("deleteTeacher")
    public String deleteTeacher(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        teacherDao.deleteTeacherById(id);

        return "redirect:/teachers";
    }

    @GetMapping("editTeacher")
    public String editTeacher(HttpServletRequest request, Model model) {
        int id = Integer.parseInt(request.getParameter("id"));
        Teacher teacher = teacherDao.getTeacherById(id);

        model.addAttribute("teacher", teacher);
        return "editTeacher";
    }

    /**
     * This is a POST mapping for editTeacher.
     * We only need to take in the HttpServletRequest so we can get the data out of the form.
     * We start by getting the hidden ID and pulling in the original version of the object.
     * We then get all the new data out of the form and set it into the Teacher object.
     * Once we have all the data, we make a call to our DAO update method.
     * We can then redirect back to the main Teachers page.
     * */

    @PostMapping("editTeacher")
    public String performEditTeacher(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        Teacher teacher = teacherDao.getTeacherById(id);

        teacher.setFirstName(request.getParameter("firstName"));
        teacher.setLastName(request.getParameter("lastName"));
        teacher.setSpecialty(request.getParameter("specialty"));

        teacherDao.updateTeacher(teacher);

        return "redirect:/teachers";
    }





}
