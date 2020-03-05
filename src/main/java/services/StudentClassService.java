package services;

import pojoClasses.Student;
import java.util.List;

public interface StudentClassService {
    void addStudent(Student values);
    void deleteStudent(int id);
    boolean isStudentPassed(int id);
    Student getStudent(int id);
    List<Student> getAllStudents();
}
