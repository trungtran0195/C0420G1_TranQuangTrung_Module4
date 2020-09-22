package com.codegym.controller;


import com.codegym.Service.UserDetailsServiceImpl;
import com.codegym.dao.RoleRepository;
import com.codegym.dao.UserRepository;
import com.codegym.entity.User;
//import com.codegym.validator.ConfirmUniqueValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

    @Autowired(required = false)
    private AuthenticationManager authenticationManager;

    @Autowired(required = false)
    private UserDetailsServiceImpl userServiceImpl;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;


    @GetMapping("/login")
    public ModelAndView viewLogin() {
        return new ModelAndView("index/login");
    }

    @GetMapping("/loginSuccess")
    public ModelAndView success() {
        return new ModelAndView("index/home");
    }

    @GetMapping("/home")
    public ModelAndView home() {
        return new ModelAndView("index/home");
    }

//    @PostMapping("/login")
//    public ModelAndView login(@RequestParam("username")String username, @RequestParam("password") String password) {
//        Authentication authentication = authenticationManager.authenticate(
//                new UsernamePasswordAuthenticationToken(username,password)
//        );
//        UserDetails userDetails = userServiceImpl
//                .loadUserByUsername(authentication.getName());
//        return new ModelAndView("loginSuccess");
//    }

    @GetMapping("/register")
    public ModelAndView viewRegister() {
        return new ModelAndView("index/register");
    }

    @PostMapping("/register")
    public ModelAndView viewRegister(@RequestParam("username") String username, @RequestParam("password") String password) {

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String hashPassword = encoder.encode(password);
        User user = new User();
        user.setUsername(username);
        user.setPassword(hashPassword);
        user.setRole(roleRepository.findByRoleName("ROLE_USER"));
        userRepository.save(user);
        return new ModelAndView("index/login");
    }
}
