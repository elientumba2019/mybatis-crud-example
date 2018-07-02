import com.elie.domain.Student;
import com.elie.services.StudentService;

import java.util.Date;

public class DriverProgram {

    public static void main(String[] args){

        StudentService studentService = new StudentService();

        Student student = new Student();
        student.setDob(new Date());
        student.setEmail("Elientumba@obo.com");
        student.setName("Bnob kjkjskdjsk");


        //studentService.createStudent(student);



        studentService.findAll().forEach(std -> System.out.println(std));
    }
}
