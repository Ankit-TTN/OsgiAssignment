import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import pojoClasses.Student;
import services.StudentClassService;

import java.util.Random;

@Component
public class MainComponent {
    @Reference
    StudentClassService studentClassService;

    @Activate
    void activate(){
        for (int i = 0; i <=10; i++) {
            Random rand = new Random();
            Student stuObj = new Student(i+1,"Name_"+(i+1),rand.nextInt(100),rand.nextInt(10)+10);
            studentClassService.addStudent(stuObj);
        }

        System.out.println("------------------------------------------------");
        System.out.println("All Student");
        for (Student student : studentClassService.getAllStudents()) {
            System.out.println(student);
        }

        System.out.println("------------------------------------------------");
        System.out.println("Student With Id 9");
        System.out.println(studentClassService.getStudent(9));

        System.out.println("------------------------------------------------");
        System.out.println("Is Student With id 9 Passed");
        System.out.println(studentClassService.isStudentPassed(9));

        System.out.println("------------------------------------------------");
        System.out.println("Delete Student With id 9 Passed");
        studentClassService.deleteStudent(9);

    }
}
