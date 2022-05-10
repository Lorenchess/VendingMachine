package com.lorenchess.classroster.entity;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.Objects;

/*
* We are choosing not to validate the Teacher or list of Students.
* Because we take those from the form as IDs, it would be difficult to use our existing
* validation to check them. Our setup should guarantee that we have a Teacher, but it is
* valid for no Students to come through, so we have nothing to validate there.
* */

public class Course {
    private int id;
    @NotBlank(message = "Name must not be blank")
    @Size(max = 50, message="Name must be fewer than 50 characters")
    private String name;

    @Size(max = 255, message = "Description must be fewer than 255 characters")
    private String description;
    private Teacher teacher;
    private List<Student> students;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Course)) return false;
        Course course = (Course) o;
        return getId() == course.getId() && getName().equals(course.getName()) && getDescription().equals(course.getDescription()) && getTeacher().equals(course.getTeacher()) && getStudents().equals(course.getStudents());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getDescription(), getTeacher(), getStudents());
    }
}
