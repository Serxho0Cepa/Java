package com.springexample.SpringDataJPA1.model.entity;

import com.springexample.SpringDataJPA1.model.enums.BookingStatus;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "booking", uniqueConstraints = {
        @UniqueConstraint(name = "unique_booking_code_constraint", columnNames = {"booking_date"})
})
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name = "booking_date", unique = true, nullable = false)
    private Date bookingdater;

    private String status;


//    @Enumerated(value = EnumType.STRING)
//    @Column(name = "booking_status", nullable = false)
//    private BookingStatus bookingStatus;



    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}
