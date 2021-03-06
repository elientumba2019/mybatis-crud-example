package com.elie.services;
import com.elie.domain.Student;
import com.elie.mapper.StudentMapper;
import com.elie.util.FactorySingleton;
import org.apache.ibatis.session.SqlSession;

import java.io.Serializable;
import java.util.List;
import java.util.logging.Logger;


/**
 * Student service class
 * where all the magic happens
 */
public class StudentService implements Serializable {

    private Logger logger = Logger.getLogger(getClass().getName());


    /**
     * Service level method to get all elements from the database
     * @return {List<Student>} objects returned
     */
    public List<Student> findAll(){
        logger.info("GETTING ALL STUDENTS FROM THE DB");
        SqlSession sqlSession = FactorySingleton.openSession();
        try{
            StudentMapper mapper =  sqlSession.getMapper(StudentMapper.class);
            return  mapper.findAll();
        }
        finally {
            sqlSession.close();
        }

    }




    /**
     * service level method gets a student from the database given its id
     * @param id {int} id of the student to be retrieved
     * @return {Student} instance
     */
    public Student findOne(int id){
        logger.info("FINDING A STUDENT ID ID : " + id);
        SqlSession sqlSession = FactorySingleton.openSession();
        try{
            StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
            return mapper.findById(id);
        }
        finally {
            sqlSession.close();
        }
    }




    /**
     * Service level method to create and add a new student to
     * the database
     * @param student {Student} instance to be saved in the Db
     */
    public void createStudent(Student student){
        logger.info("CREATING NEW STUDENT");
        SqlSession sqlSession = FactorySingleton.openSession();
        try {
            StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
            mapper.createStudent(student);
            sqlSession.commit();
        }finally {
            sqlSession.close();
        }
    }




    /**
     * service level method to delete a student from the DB
     * @param id {int} id to be deleted
     */
    public void deleteStudent(int id){
        logger.info("DELETING STUDENT WITH ID : " + id);
        SqlSession sqlSession = FactorySingleton.openSession();
        try {
            StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
            mapper.deleteStudent(id);
            sqlSession.commit();
        }
        finally {
            sqlSession.close();
        }
    }
}
