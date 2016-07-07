/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest.application.data;

import rest.application.model.Student;

import java.util.List;

/**
 *
 * @author Komputer
 */
public interface StudentDao {

    public Student findById(Long id);

    public Student findByEmail(String email);

    public List<Student> findAllOrderedByLogin();

    public void register(Student student);
    
}
