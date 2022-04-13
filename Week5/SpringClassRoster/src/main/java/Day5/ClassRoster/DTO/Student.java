package Day5.ClassRoster.DTO;

import java.util.Objects;

/**
 * Notice that studentId is a read-only field.
 * It is passed in as a parameter to the constructor, and there is no setter for this field.
 * All other fields on the Student class are read/write and must be set manually after
 * a Student object has been instantiated.
 */

public class Student {
    private String firstName;
    private String lastName;
    private String studentId;
    // Programming Language + cohort month/year
    private String cohort;

    public Student(String studentId) {
        this.studentId = studentId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getCohort() {
        return cohort;
    }

    public void setCohort(String cohort) {
        this.cohort = cohort;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student student = (Student) o;
        return getFirstName().equals(student.getFirstName()) && getLastName().equals(student.getLastName()) && getStudentId().equals(student.getStudentId()) && getCohort().equals(student.getCohort());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFirstName(), getLastName(), getStudentId(), getCohort());
    }

    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", studentId='" + studentId + '\'' +
                ", cohort='" + cohort + '\'' +
                '}';
    }
}
