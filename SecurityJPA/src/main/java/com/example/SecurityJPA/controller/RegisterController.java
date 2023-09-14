package com.example.SecurityJPA.controller;

import com.example.SecurityJPA.dao.RoleRepository;
import com.example.SecurityJPA.entity.Role;
import com.example.SecurityJPA.entity.User;
import com.example.SecurityJPA.service.UserService;
import com.example.SecurityJPA.web.RegisterUser;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.naming.Binding;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/register")
public class RegisterController {
    UserService userService;
    RoleRepository roleRepository;
    @Autowired
    public RegisterController(UserService userService,RoleRepository roleRepository) {
        this.userService = userService;
        this.roleRepository = roleRepository;
    }
    @GetMapping("/showRegisterForm")
    public String toRegisterForm(Model model) {
        RegisterUser registerUser = new RegisterUser();
        model.addAttribute("registerUser",registerUser);
        return "register/form";
    }

    @InitBinder
    public void initBinder(WebDataBinder data) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        data.registerCustomEditor(String.class,stringTrimmerEditor);
    }

    @PostMapping("/process")
    public String solveProcess(@Valid @ModelAttribute RegisterUser registerUser,BindingResult bindingResult, Model model,
                                HttpSession session)
    {
        if(bindingResult.hasErrors()) {
            System.out.println("Không ổn rồi");
            return "register/form";
        }
        String username  = registerUser.getUsername();
        User user = userService.findByUsername(username);
        if(user != null) {
            System.out.println("Có rồi m ưi");
            model.addAttribute("registerUser",new RegisterUser());
            model.addAttribute("myerror","Tài khoản đã tồn tại ");
            return "register/form";
        }
        BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
        user = new User();
        user.setUserName(username);
        user.setPassWord(bcrypt.encode(registerUser.getPassword()));
        user.setFirstName(registerUser.getFirstname());
        user.setLastName(registerUser.getLastname());
        user.setEmail(registerUser.getEmail());
        Role defaultRole = roleRepository.findByName("ROLE_USER");
        List<Role> list = new ArrayList<>();
        list.add(defaultRole);
        user.setRoles(list);
        userService.save(user);
        session.setAttribute("myuser",user);
        return "register/confirm";
    }

}
