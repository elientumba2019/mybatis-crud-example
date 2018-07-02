import com.elie.domain.Student;
import com.elie.services.StudentService;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Date;

public class StudentServiceTest {

    private static StudentService studentService;


    @BeforeClass
    public static void init(){
         studentService = new StudentService();
    }


    @AfterClass
    public static void kill(){
        studentService = null;
    }


    @Test
    public void findAllTest(){
        Assert.assertNotNull(studentService.findAll());
        studentService.findAll().forEach(
                System.out::println
        );
    }



    @Test
    public void findById(){
        Assert.assertNotNull(studentService.findOne(1));
        System.out.println(studentService.findOne(1));
    }



    @Test
    public void createTest(){
        int id = 10;
        Student student = new Student();
        student.setId(id);
        student.setName("Create Test");
        student.setEmail("elie@createTest");
        student.setDob(new Date());

        studentService.createStudent(student);
        Assert.assertNotNull(studentService.findOne(id));
        studentService.deleteStudent(id);
    }




    @Test
    public void deleteTest(){

        int id = 11;
        Student student = new Student();
        student.setId(id);
        student.setName("Create Test");
        student.setEmail("elie@createTest");
        student.setDob(new Date());


        studentService.createStudent(student);
        Assert.assertNotNull(studentService.findOne(id));
        studentService.deleteStudent(id);
        Assert.assertNull(studentService.findOne(id));

    }

}
