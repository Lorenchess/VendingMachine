package com.lorenchess.classroster.dao;

import com.lorenchess.classroster.entity.Course;
import com.lorenchess.classroster.entity.Student;
import com.lorenchess.classroster.entity.Teacher;

import java.util.List;

public interface CourseDao {
    Course getCourseById(int id);
    List<Course> getAllCourses();
    Course addCourse(Course course);
    void updateCourse(Course course);
    void deleteCourseById(int id);

    List<Course> getCoursesForTeacher(Teacher teacher);
    List<Course> getCoursesForStudent(Student student);
}
