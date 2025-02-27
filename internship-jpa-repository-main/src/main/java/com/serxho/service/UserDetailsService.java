package com.serxho.service;

import com.serxho.model.dto.UserDTO;
import com.serxho.model.dto.UserDetailsDTO;
import com.serxho.model.entity.UserDetails;

import java.util.List;

public interface UserDetailsService {
    void saveUserDetails(UserDetails userDetails);

}
