package com.serxho.service.impl;

import com.serxho.mapper.UserMapper;
import com.serxho.model.dto.UserDTO;
import com.serxho.repository.UserRepository;
import com.serxho.repository.impl.UserRepositoryImpl;
import com.serxho.service.UserService;

import java.util.List;
import java.util.stream.Collectors;

public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserServiceImpl() {
        this.userRepository = new UserRepositoryImpl();
        this.userMapper = new UserMapper();
    }

    @Override
    public List<UserDTO> loadAllUsers() {
        return userRepository.findAll().stream().map(userMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public void saveUser(UserDTO user) {
        userRepository.save(userMapper.toEntity(user));
    }

    @Override
    public List<UserDTO> findAllNamedQuery(String username) {
        return userRepository.findAllNamedQuery(username).stream().map(userMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public UserDTO findById(Long id) {
        return userRepository.findById(id)
                .map(userMapper::toDto)
                .orElse(null);
    }

}
