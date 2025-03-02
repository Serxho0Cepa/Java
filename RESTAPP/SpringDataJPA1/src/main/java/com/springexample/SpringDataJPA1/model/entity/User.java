package com.springexample.SpringDataJPA1.model.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.springexample.SpringDataJPA1.model.enums.UserRole;
import jakarta.persistence.*;

import java.util.List;

@NamedQueries({
        @NamedQuery(name = "User.findAll", query = "SELECT u FROM User u"),
        @NamedQuery(name = "User.findById", query = "SELECT u FROM User u WHERE u.id = :id")
})
@Entity
@Table(name = "user", uniqueConstraints = {
        @UniqueConstraint(name = "unique_username_constraint", columnNames = {"username"})
})
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name = "username", unique = true, nullable = false)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "role", nullable = false)
    @Enumerated(value = EnumType.STRING)
    private UserRole userRole;

    @OneToOne(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonManagedReference
    private UserDetails userDetails;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Booking> bookings;

    public User() {}

    public User(Long id, String username, String password, UserRole userRole, UserDetails userDetails, List<Booking> bookings) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.userRole = userRole;
        this.userDetails = userDetails;
        this.bookings = bookings;
    }

    public User(String username, String password, UserRole userRole, UserDetails userDetails, List<Booking> bookings) {
        this.username = username;
        this.password = password;
        this.userRole = userRole;
        this.userDetails = userDetails;
        this.bookings = bookings;
    }

//    @ManyToMany(mappedBy = "users")
//    private List<Flight> flights;


    public Long getId() { return id;  }
    public void setId(Long id) { this.id = id;}

    public String getUsername() {return username; }
    public void setUsername(String username) {this.username = username;}

    public String getPassword() {return password;}
    public void setPassword(String password) {this.password = password;}

    public UserRole getUserRole() {
        return userRole;
    }
    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }

    public UserDetails getUserDetails() {return userDetails; }
    public void setUserDetails(UserDetails userDetails) { this.userDetails = userDetails; }

    public List<Booking> getBookings() { return bookings; }
    public void setBookings(List<Booking> bookings) { this.bookings = bookings; }

}
