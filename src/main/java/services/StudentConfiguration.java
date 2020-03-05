package services;

import jdk.nashorn.internal.objects.annotations.Function;
import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.AttributeType;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;

import java.util.List;

@ObjectClassDefinition(name = "Customer Config",description = "Student Config Service")
public @interface StudentConfiguration {
    @AttributeDefinition(name = "No of Students",type= AttributeType.INTEGER,description = "No Of Student")
    int NO_OF_STUDENTS() default 10;

    @AttributeDefinition(name = "Passing Marks",type= AttributeType.INTEGER,description = "Marks required by the student to pass the class")
    int PASSING_MARKS() default 40;
}
