package com.serxho.mapper;

import com.serxho.model.dto.UserDetailsDTO;
import com.serxho.model.entity.UserDetails;

public class UserDetailsMapper extends AbstractMapper<UserDetails, UserDetailsDTO> {

    @Override
    public UserDetails toEntity(UserDetailsDTO dto) {
        if(dto == null) {
            return null;
        }
        UserDetails userDetails =   new UserDetails();
        userDetails.setFirstName(dto.getFirstName());
        userDetails.setLastName(dto.getLastName());
        userDetails.setEmail(dto.getEmail());
        userDetails.setPhoneNumber(dto.getPhoneNumber());
        return userDetails;
    }

    @Override
    public UserDetailsDTO toDto(UserDetails entity) {
        if (entity == null) {
            return null;
        }
        UserDetailsDTO userDetailsDTO = new UserDetailsDTO();
        userDetailsDTO.setId(entity.getId());
        userDetailsDTO.setFirstName(entity.getFirstName());
        userDetailsDTO.setLastName(entity.getLastName());
        userDetailsDTO.setEmail(entity.getEmail());
        userDetailsDTO.setPhoneNumber(entity.getPhoneNumber());
        return userDetailsDTO;
    }

}
