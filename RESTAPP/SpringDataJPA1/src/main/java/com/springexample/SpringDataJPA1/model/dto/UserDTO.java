package com.springexample.SpringDataJPA1.model.dto;

public class UserDTO {

    private Long id;
    private String username;
    private String role;
    private UserDetailsDTO userDetails;

    public UserDTO() {}

    public UserDTO(Long id, String username, String role, UserDetailsDTO userDetails) {
        this.id = id;
        this.username = username;
        this.role = role;
        this.userDetails = userDetails;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }

    public UserDetailsDTO getUserDetails() {
        return userDetails;
    }
    public void setUserDetails(UserDetailsDTO userDetails) {
        this.userDetails = userDetails;
    }
}
