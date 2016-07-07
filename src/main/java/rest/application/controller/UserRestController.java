/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest.application.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import rest.application.data.UserDao;
import rest.application.model.User;

/**
 *
 * @author Komputer
 */

@Controller
@RequestMapping("/rest")
public class UserRestController {
     @Autowired
     UserDao userDao;
     
     @RequestMapping(value = "/users", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody List<User> studentList() {return userDao.findAllOrderedByLogin();}
    
    
}
