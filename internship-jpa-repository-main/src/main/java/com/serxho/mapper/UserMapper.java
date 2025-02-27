package com.serxho.mapper;

import com.serxho.model.dto.UserDTO;
import com.serxho.model.entity.User;

public class UserMapper extends AbstractMapper<User, UserDTO> {

    private final UserDetailsMapper userDetailsMapper;
    public UserMapper() {this.userDetailsMapper = new UserDetailsMapper();}

    @Override
    public User toEntity(UserDTO userDTO) {
        User user = new User();
        user.setUsername(userDTO.getUsername());
        user.setPassword(userDTO.getPassword());
        user.setRole(userDTO.getRole());
        user.setUserDetails(userDetailsMapper.toEntity(userDTO.getUserDetailsDTO()));
        return user;
    }

    @Override
    public UserDTO toDto(User user) {
        if (user == null) {
            return null;
        }
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setUsername(user.getUsername());
        userDTO.setPassword(user.getPassword());
        userDTO.setRole(user.getRole());
        userDTO.setUserDetailsDTO(userDetailsMapper.toDto(user.getUserDetails()));
        return userDTO;
    }

}
