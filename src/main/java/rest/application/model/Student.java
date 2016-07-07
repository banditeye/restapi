/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest.application.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author Komputer
 */
@Entity
@Table(name = "student", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class Student implements Serializable {
    /**
     * Default value included to remove warning. Remove or modify at will. *
     */
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue
    private long id_student;
    
    @NotNull
    @Size(min = 1, max = 25)
    @Pattern(regexp = "[A-Za-z ]*", message = "must contain only letters and spaces")
    private String login;
    
    @NotNull
    @NotEmpty(message = "Password cannot be empty")
    private String password;
    
    @NotNull
    @NotEmpty(message = "Email address cannot be empty")
    @Email(message = "Invalid email address, e.g. valid email address: example@gmail.com")
    private String email;

    public long getId_student() {
        return id_student;
    }

    public void setId_student(long id_student) {
        this.id_student = id_student;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
    
    
}
