package com.Hotel.Management.System.repository;


import com.Hotel.Management.System.entity.Hotels;
import com.Hotel.Management.System.entity.Price;
import com.Hotel.Management.System.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.Optional;

public interface PriceRepository extends JpaRepository<Price, Long> {

    Optional<Price> findByPriceOfRooms(BigDecimal priceOfRooms);

    Optional<Price> findByRoomIdAndHotelId(Room roomId, Hotels hotelId);
}