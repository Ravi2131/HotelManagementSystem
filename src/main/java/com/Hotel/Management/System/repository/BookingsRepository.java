package com.Hotel.Management.System.repository;


import com.Hotel.Management.System.entity.Bookings;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookingsRepository extends JpaRepository<Bookings, Long> {

    Optional<Bookings> findByBookingCode(String bookingCode);
}