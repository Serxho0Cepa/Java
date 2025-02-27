package com.serxho.main;

import com.serxho.model.dto.UserDTO;
import com.serxho.model.dto.UserDetailsDTO;
import com.serxho.model.entity.User;
import com.serxho.model.entity.UserDetails;
import com.serxho.repository.UserRepository;
import com.serxho.repository.impl.UserRepositoryImpl;
import com.serxho.service.UserDetailsService;
import com.serxho.service.UserService;
import com.serxho.service.impl.UserDetailsServiceImpl;
import com.serxho.service.impl.UserServiceImpl;

import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        UserService userService = new UserServiceImpl();

        Long userId = 47L;
        UserDTO userDTO = userService.findById(userId);

        if (userDTO != null) {
            System.out.println("User found: " + userDTO);
        } else {
            System.out.println("User not found.");
        }


//        UserService userService = new UserServiceImpl();
//        UserDTO user = new UserDTO();
//        user.setUsername("seXhonUs1");
//        user.setPassword("sJxhonpass11112");
//        user.setRole("sRole1111112");
//
//        UserDetailsDTO userDetailsDTO = new UserDetailsDTO();
//        userDetailsDTO.setFirstName("sXhon_Fn1");
//        userDetailsDTO.setLastName("sXhon_Ln1");
//        userDetailsDTO.setEmail("sxhon@gmail.co1");
//        userDetailsDTO.setPhoneNumber("s12345671");
//
//        user.setUserDetailsDTO(userDetailsDTO);
//        userService.saveUser(user);
//
//        List<UserDTO> list = userService.findAllNamedQuery("seXhonUs1");
//        System.out.println(list);


    }
}
