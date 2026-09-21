package com.project.hotelmgmt.entity;


import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.*;


import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
@Table(name = "booking")
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class BookingEntity {
    @Id
    private String bookingID;
    @Column(nullable = false)
    private LocalDate checkInDate;
    @Column(nullable = false)
    private LocalDate checkOutDate;
    @Column(nullable = false)
    private LocalTime checkInTime;
    @Column(nullable = false)
    private LocalTime checkOutTime;

    private Boolean isBookingAvailable;

    @ManyToOne
    @JoinColumn(name = "customer_id",nullable=false)
    private CustomerEntity customer;

    @ManyToMany
    @JoinTable(
            name = "booking_room",
            joinColumns = @JoinColumn(name = "booking_id"),
            inverseJoinColumns = @JoinColumn(name = "room_id"))
    private List<RoomEntity> rooms;

    @ManyToOne(optional = false)
    @JoinColumn(name = "hotel_id",nullable = false)
    private HotelEntity hotel;
}


/*Now you don't need:

private String customerId;

because:

private CustomerEntity customer;

represents that relationship.

 */
