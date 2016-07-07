package rest.application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.UnexpectedRollbackException;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import rest.application.data.StudentDao;
import rest.application.model.Student;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by Komputer on 27.05.2016.
 */

@Controller
@RequestMapping("/rest")
public class StudentRestController {
    @Autowired
    StudentDao studentDao;

    @RequestMapping(value = "/students", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody List<Student> studentList() {return studentDao.findAllOrderedByLogin();}

    @RequestMapping(value = "/student/{id}", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody Student findStudentById(@PathVariable("id") long id) {return studentDao.findById(id);}

    @RequestMapping(method = RequestMethod.POST)
    public String registerNewMember(@Valid @ModelAttribute("newStudent") Student newStudent, BindingResult result, Model model) {
        if (!result.hasErrors()) {
            try {
                studentDao.register(newStudent);
                return "redirect:/";
            } catch (UnexpectedRollbackException e) {
                model.addAttribute("students", studentDao.findAllOrderedByLogin());
                model.addAttribute("error", e.getCause().getCause());
                return "index";
            }
        } else {
            model.addAttribute("members", studentDao.findAllOrderedByLogin());
            return "index";
        }
    }

}
