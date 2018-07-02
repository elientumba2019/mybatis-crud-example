package com.elie.mapper;

import com.elie.domain.Student;

import java.util.List;

public interface StudentMapper {

    /**
     * retrieves all the students
     * @return a list of {Student} objects from the DB
     */
    List<Student> findAll();




    /**
     * finds a student by its id inthe DB
     * @param id id {int}
     * @return {Student instance from the DB}
     */
    Student findById(int id);




    /**
     * creates a new Student ans saves it in the DB
     * @param student {Student} object passed as a parameter
     */
    void createStudent(Student student);




    /**
     * given the id of an element in the DB , the element is deleted
     * @param id {int} id of the element
     */
    void deleteStudent(int id);
}
