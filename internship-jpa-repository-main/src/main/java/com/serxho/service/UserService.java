package com.serxho.service;

import com.serxho.model.dto.UserDTO;

import java.util.List;

public interface UserService {

    List<UserDTO> loadAllUsers();

    void saveUser(UserDTO user);

    List<UserDTO> findAllNamedQuery(String username);

    UserDTO findById(Long id);

}
