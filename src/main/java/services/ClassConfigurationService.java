package services;

import pojoClasses.Student;

import java.util.List;

public interface ClassConfigurationService {
    boolean isClassLimitReached(List<Student> studentList);
    int getPassingMarks();
}
