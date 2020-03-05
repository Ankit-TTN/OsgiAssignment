package services.impl;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import pojoClasses.Student;
import services.ClassConfigurationService;
import services.StudentClassService;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Component(service = StudentClassService.class)
public class StudentClassServiceImpl implements StudentClassService {
    private List<Student> students = new ArrayList<Student>();

    @Reference
    ClassConfigurationService classConfigurationService;

    public void addStudent(Student value) {
        if (!classConfigurationService.isClassLimitReached(students)) {
            students.add(value);
        } else{
            System.out.println("Class Limit Reached");
        }
    }

    public void deleteStudent(int id) {
        Iterator studentItr = students.iterator();
        while (studentItr.hasNext()) {
            Student student = (Student) studentItr.next();
            if(student.getId()==id){
                studentItr.remove();
                System.out.println("Student Removed");
                break;
            }
        }
    }

    public boolean isStudentPassed(int id) {
        for (Student currStudent : students) {
            if (currStudent.getId() == id) {
                return currStudent.getMarks()>=classConfigurationService.getPassingMarks();
            }
        }
        return false;
    }

    public Student getStudent(int id) {
        for (Student currStudent : students) {
            if (currStudent.getId() == id) {
                return currStudent;
            }
        }
        return null;
    }

    public List<Student> getAllStudents() {
        return students;
    }

}
