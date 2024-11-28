package com.Hotel.Management.System.repository;


import com.Hotel.Management.System.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoomRepository extends JpaRepository<Room, Long> {

    Optional<Room> findByRoomTypes(String roomTypes);
}