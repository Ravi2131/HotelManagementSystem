package com.Hotel.Management.System.repository;


import com.Hotel.Management.System.entity.AppUser;
import com.Hotel.Management.System.entity.Property;
import com.Hotel.Management.System.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {

    List<Review> findByAppUserId(AppUser appUserId);

    boolean existsByAppUserIdAndPropertyId(AppUser appUserId, Property propertyId);
}