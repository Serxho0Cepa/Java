package com.springexample.SpringDataJPA1.service;

import com.springexample.SpringDataJPA1.mapper.UserMapper;
import com.springexample.SpringDataJPA1.model.dto.UserDTO;
import com.springexample.SpringDataJPA1.model.dto.UserRequestDTO;
import com.springexample.SpringDataJPA1.model.entity.User;
import com.springexample.SpringDataJPA1.model.entity.UserDetails;
import com.springexample.SpringDataJPA1.model.enums.UserRole;
import com.springexample.SpringDataJPA1.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserDTO> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(UserMapper::toUserDTO)
                .collect(Collectors.toList());
    }

    public Optional<UserDTO> getUserById(Long id) {
        return userRepository.findById(id)
                .map(UserMapper::toUserDTO);
    }

    public List<UserDTO> getUsersByFlightId(Long flightId) {
        return userRepository.findUsersByFlightId(flightId)
                .stream()
                .map(UserMapper::toUserDTO)
                .collect(Collectors.toList());
    }

    @jakarta.transaction.Transactional
    public UserDTO createOrUpdateUser(UserRequestDTO userRequestDTO, Long userId) {
        User user;

        if (userId != null) {
            Optional<User> existingUser = userRepository.findById(userId);
            if (existingUser.isPresent()) {
                user = existingUser.get();
                user.setUsername(userRequestDTO.getUsername());
                user.setPassword(userRequestDTO.getPassword());
                user.setUserRole(UserRole.valueOf(userRequestDTO.getRole()));

                if (userRequestDTO.getUserDetails() != null) {
                    user.getUserDetails().setFirstName(userRequestDTO.getUserDetails().getFirstName());
                    user.getUserDetails().setLastName(userRequestDTO.getUserDetails().getLastName());
                    user.getUserDetails().setEmail(userRequestDTO.getUserDetails().getEmail());
                    user.getUserDetails().setPhoneNumber(userRequestDTO.getUserDetails().getPhoneNumber());
                }
            } else {
                user = UserMapper.toUserEntity(userRequestDTO);
            }
        } else {
            user = UserMapper.toUserEntity(userRequestDTO);
        }

        User savedUser = userRepository.save(user);
        return UserMapper.toUserDTO(savedUser);
    }

    @Transactional
    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }
}
