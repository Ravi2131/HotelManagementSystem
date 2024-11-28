package com.Hotel.Management.System.service;


import com.Hotel.Management.System.entity.AppUser;
import com.Hotel.Management.System.entity.Property;
import com.Hotel.Management.System.entity.Review;
import com.Hotel.Management.System.payload.AppUserDto;
import com.Hotel.Management.System.payload.PropertyDto;
import com.Hotel.Management.System.payload.ReviewDto;
import com.Hotel.Management.System.repository.PropertyRepository;
import com.Hotel.Management.System.repository.ReviewRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReviewService {

    private final ReviewRepository reviewRepository;
    private final PropertyRepository propertyRepository;
    private final PropertiesService propertiesService;
    private final AppUserService appUserService;

    // -------------------- Constructor --------------------- //

    public ReviewService(ReviewRepository reviewRepository,
                         PropertyRepository propertyRepository, PropertiesService propertiesService, AppUserService appUserService) {
        this.reviewRepository = reviewRepository;
        this.propertyRepository = propertyRepository;
        this.propertiesService = propertiesService;
        this.appUserService = appUserService;
    }

    //--------------------------- Convertors --------------------------------------//

    public Review convertDtoToEntity(ReviewDto reviewDto,Long propertyId,AppUser appUserId){
        Review reviews = new Review();
        reviews.setRatings(reviewDto.getRatings());
        reviews.setDescriptions(reviewDto.getDescription());
        reviews.setPropertyId(propertyRepository.findById(propertyId).get());
        reviews.setAppUserId(appUserId);
        return reviews;
    }

    public ReviewDto convertEntityToDto(Review review){
        ReviewDto reviewDto = new ReviewDto();
        reviewDto.setRatings(review.getRatings());
        reviewDto.setDescription(review.getDescriptions());
        PropertyDto propertyDto = propertiesService.convertEntityToDto(review.getPropertyId());
        AppUserDto appUserDto = appUserService.mapToDto(review.getAppUserId());
        reviewDto.setPropertyDto(propertyDto);
        reviewDto.setAppUserDto(appUserDto);
        return reviewDto;
    }

    // ----------------------- Create ----------------------- //

    public boolean verifyUniqueReview(Long propertyId, AppUser appUserId) {
        Property property = propertyRepository.findById(propertyId).get();
        return reviewRepository.existsByAppUserIdAndPropertyId(appUserId,property);
    }

    public Review addNewReviews(Review review, Long propertyId, AppUser appUserId) {
        Property property = propertyRepository.findById(propertyId).get();
        review.setPropertyId(property);
        review.setAppUserId(appUserId);
        return reviewRepository.save(review);
    }

    // ------------------------ Read ------------------------ //

    public List<ReviewDto> getAllReviewsByUser(AppUser appUserId) {
        return reviewRepository.findByAppUserId(appUserId).stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());
    }

    public List<ReviewDto> getAllReviews(){
        return reviewRepository.findAll().stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());
    }



    // ----------------------- Update ----------------------- //
    // ----------------------- Create ----------------------- //
}
