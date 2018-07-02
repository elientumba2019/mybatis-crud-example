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
        SqlSession sqlSession = FactorySingleton.openSession();
        try{
            StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
            return mapper.findById(id);
        }
        finally {
            sqlSession.close();
        }
    }
}
