package com.serxho.model.dto;

public class UserDTO {
    private Long id;
    private String username;
    private String password;
    private String role;
    private UserDetailsDTO userDetailsDTO;

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
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }

    public UserDetailsDTO getUserDetailsDTO() {
        return userDetailsDTO;
    }
    public void setUserDetailsDTO(UserDetailsDTO userDetailsDTO) {
        this.userDetailsDTO = userDetailsDTO;
    }

        @Override
        public String toString() {
            return "UserDTO{" +
                    "id=" + id +
                    ", username='" + username + '\'' +
                    ", password='" + password + '\'' +
                    ", role='" + role + '\'' +
                    ", userDetailsDTO=" + userDetailsDTO +
                    '}';

    }
}
