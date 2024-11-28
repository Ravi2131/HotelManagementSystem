package com.Hotel.Management.System.repository;


import com.Hotel.Management.System.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CityRepository extends JpaRepository<City, Long> {

    Optional<City> findByCityName(String cityName);
}