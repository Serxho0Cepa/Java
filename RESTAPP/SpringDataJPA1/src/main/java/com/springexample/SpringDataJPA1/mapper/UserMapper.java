package com.springexample.SpringDataJPA1.mapper;

import com.springexample.SpringDataJPA1.model.dto.UserDTO;
import com.springexample.SpringDataJPA1.model.dto.UserDetailsDTO;
import com.springexample.SpringDataJPA1.model.dto.UserRequestDTO;
import com.springexample.SpringDataJPA1.model.entity.User;
import com.springexample.SpringDataJPA1.model.entity.UserDetails;
import com.springexample.SpringDataJPA1.model.enums.UserRole;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public static UserDTO toUserDTO(User user) {
        if (user == null) return null;

        return new UserDTO(
                user.getId(),
                user.getUsername(),
                user.getUserRole().name(),
                toUserDetailsDTO(user.getUserDetails())
        );
    }

    public static UserDetailsDTO toUserDetailsDTO(UserDetails userDetails) {
        if (userDetails == null) return null;

        return new UserDetailsDTO(
                userDetails.getFirstName(),
                userDetails.getLastName(),
                userDetails.getEmail(),
                userDetails.getPhoneNumber()
        );
    }

    public static User toUserEntity(UserRequestDTO dto) {
        if (dto == null) return null;

        User user = new User();
        user.setUsername(dto.getUsername());
        user.setPassword(dto.getPassword());
        user.setUserRole(UserRole.valueOf(dto.getRole()));

        if (dto.getUserDetails() != null) {
            UserDetails userDetails = toUserDetailsEntity(dto.getUserDetails());
            userDetails.setUser(user);
            user.setUserDetails(userDetails);
        }

        return user;
    }

    public static UserDetails toUserDetailsEntity(UserDetailsDTO dto) {
        if (dto == null) return null;

        return new UserDetails(
                dto.getFirstName(),
                dto.getLastName(),
                dto.getEmail(),
                dto.getPhoneNumber(),
                null
        );
    }
}
