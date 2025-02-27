package com.serxho.model.entity;


import jakarta.persistence.*;

import java.util.List;

@Entity
@NamedQueries({
        @NamedQuery(name = "allUsers", query = "SELECT u from User u"),
        @NamedQuery(name = "findByusername", query = "SELECT u FROM User u WHERE u.username = :uname")
})
@Table(name = "user")
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
    private String role;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private UserDetails userDetails;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<Booking> bookings;

    @ManyToMany
    @JoinTable(
            name = "user_flight",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "flight_id", referencedColumnName = "id")
    )
    private List<Flight> flights;


    public Long getId() { return id;  }
    public void setId(Long id) { this.id = id;}

    public String getUsername() {return username; }
    public void setUsername(String username) {this.username = username;}

    public String getPassword() {return password;}
    public void setPassword(String password) {this.password = password;}

    public String getRole() { return role;  }
    public void setRole(String role) {this.role = role; }

    public UserDetails getUserDetails() {return userDetails; }
    public void setUserDetails(UserDetails userDetails) { this.userDetails = userDetails; }

    public List<Booking> getBookings() { return bookings; }
    public void setBookings(List<Booking> bookings) { this.bookings = bookings; }

    public List<Flight> getFlights() { return flights; }
    public void setFlights(List<Flight> flights) { this.flights = flights; }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                ", userDetails=" + userDetails +
                '}';
    }
}
