package com.serxho.model.entity;

import com.serxho.model.enums.BookingStatus;
import jakarta.persistence.*;

import java.util.Date;

//, uniqueConstraints = {
//@UniqueConstraint(name = "unique_booking_code_constraint", columnNames = {"booking_date"})
//}
@Entity
@Table(name = "booking")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name = "booking_date", unique = true, nullable = false)
    private Date bookingdate;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "status", nullable = false)
    private BookingStatus bookingStatus;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;



    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public Date getBookingDate() {return bookingdate;}
    public void setBookingDate(Date bookingdate) {this.bookingdate = bookingdate;}

    public BookingStatus getBookingStatus() {
        return bookingStatus;
    }
    public void setBookingStatus(BookingStatus bookingStatus) {
        this.bookingStatus = bookingStatus;
    }

    public User getUser() {return user;}
    public void setUser(User user) {this.user = user;}

    @Override
    public String toString() {
        return "Booking{" +
                "id=" + id +
                ", bookingDate='" + bookingdate + '\'' +
                ", bookingStatus=" + bookingStatus +
                '}';
    }

}
