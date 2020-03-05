package services.impl;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.metatype.annotations.Designate;
import pojoClasses.Student;
import services.ClassConfigurationService;
import services.StudentConfiguration;

import java.util.List;

@Component(service = ClassConfigurationService.class)
@Designate(ocd= StudentConfiguration.class)
public class ClassConfigurationServiceImpl implements ClassConfigurationService {

    @Activate
    private StudentConfiguration studentConfiguration;


    public boolean isClassLimitReached(List<Student> studentList) {
        return studentList.size()>=studentConfiguration.NO_OF_STUDENTS();
    }

    public int getPassingMarks() {
        return studentConfiguration.PASSING_MARKS();
    }
}
