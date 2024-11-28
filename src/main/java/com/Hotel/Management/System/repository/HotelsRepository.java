package com.Hotel.Management.System.repository;


import com.Hotel.Management.System.entity.Hotels;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface HotelsRepository extends JpaRepository<Hotels, Long> {

    Optional<Hotels> findByHotelName(String hotelName);
}