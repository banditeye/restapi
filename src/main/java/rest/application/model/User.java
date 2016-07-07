/*
 * JBoss, Home of Professional Open Source
 * Copyright 2014, Red Hat, Inc. and/or its affiliates, and individual
 * contributors by the @authors tag. See the copyright.txt in the
 * distribution for a full listing of individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package rest.application.model;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name = "user", uniqueConstraints = @UniqueConstraint(columnNames = "login"))
public class User implements Serializable {
    /**
     * Default value included to remove warning. Remove or modify at will. *
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Long id_user;


    @Size(min = 1, max = 25)
    @Pattern(regexp = "[A-Za-z-zżźćńółęąśŻŹĆĄŚĘŁÓŃ ]*", message = "must contain only letters and spaces")
    private String name;


    @Size(min = 1, max = 25)
    @Pattern(regexp = "[A-Za-z-zżźćńółęąśŻŹĆĄŚĘŁÓŃ ]*", message = "must contain only lettersand spaces")
    private String surname;

    @NotNull
    @Pattern(regexp = "[A-Za-z-0-9]*", message = "must contain only letters, spaces and number")
    @NotEmpty(message = "Login address cannot be empty")
    private String login;


    @NotNull
    @NotEmpty(message = "Email address cannot be empty")
    @Email(message = "Invalid email address, e.g. valid email address: example@gmail.com")
    private String email;

    @Size(min = 2, max = 3)
    @Digits(fraction = 0, integer = 3, message = "Incorrect Format, valid e.g. 212")
    @Column(name = "phone_prefix")
    private String phonePrefix;

    @Size(min = 9, max = 9)
    @Digits(fraction = 0, integer = 9, message = "Incorrect Format, valid e.g. 212121212")
    @Column(name = "phone_number")
    private String phoneNumber;


    @Size(min = 1, max = 25)
    @Pattern(regexp = "[A-Za-z-zżźćńółęąśŻŹĆĄŚĘŁÓŃ ]*", message = "must contain only letters and spaces")
    @Column(name = "city")
    private String city;


    @Size(min = 1, max = 25)
    @Pattern(regexp = "[A-Za-z-zżźćńółęąśŻŹĆĄŚĘŁÓŃ ]*", message = "must contain only letters and spaces")
    @Column(name = "street")
    private String street;


    @Size(min = 1, max = 25)
    @Pattern(regexp = "[A-Za-z ]*", message = "must contain only letters and spaces")
    @Column(name = "home_number")
    private String homeNumber;

    @Size(min = 1, max = 25)
    @Pattern(regexp = "[A-Za-z ]*", message = "must contain only letters and spaces")
    @Column(name = "[postal_code")
    private String postalCode;

    @Size(min = 1, max = 25)
    @Pattern(regexp = "[A-Za-z ]*", message = "must contain only letters and spaces")
    @Column(name = "postal_city")
    private String postalCity;



    public User(Long id_user, String name, String surname, String login, String email, String phonePrefix, String phoneNumber, String city, String street, String homeNumber, String postalCode, String postalCity) {
        this.id_user = id_user;
        this.name = name;
        this.surname = surname;
        this.login = login;
        this.email = email;
        this.phonePrefix = phonePrefix;
        this.phoneNumber = phoneNumber;
        this.city = city;
        this.street = street;
        this.homeNumber = homeNumber;
        this.postalCode = postalCode;
        this.postalCity = postalCity;
    }

 

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId_user() {
        return id_user;
    }

    public void setId_user(Long id_user) {
        this.id_user = id_user;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPhonePrefix() {
        return phonePrefix;
    }

    public void setPhonePrefix(String phonePrefix) {
        this.phonePrefix = phonePrefix;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHomeNumber() {
        return homeNumber;
    }

    public void setHomeNumber(String homeNumber) {
        this.homeNumber = homeNumber;
    }

    public String getPostalCity() {
        return postalCity;
    }

    public void setPostalCity(String postalCity) {
        this.postalCity = postalCity;
    }
}
