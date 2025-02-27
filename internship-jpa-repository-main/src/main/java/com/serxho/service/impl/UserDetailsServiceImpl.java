package com.serxho.service.impl;

import com.serxho.model.dto.UserDTO;
import com.serxho.model.dto.UserDetailsDTO;
import com.serxho.model.entity.UserDetails;
import com.serxho.repository.UserDetailsRepository;
import com.serxho.repository.impl.UserDetailsRepositoryImpl;
import com.serxho.service.UserDetailsService;

import java.util.List;
import java.util.stream.Collectors;

public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserDetailsRepository userDetailsRepository;
    public UserDetailsServiceImpl() {this.userDetailsRepository = new UserDetailsRepositoryImpl();}

    @Override
    public void saveUserDetails(UserDetails userDetails) {
        userDetailsRepository.save(userDetails);
    }



}
