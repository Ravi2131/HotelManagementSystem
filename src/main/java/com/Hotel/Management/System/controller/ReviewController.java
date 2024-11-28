package com.Hotel.Management.System.controller;


import com.Hotel.Management.System.entity.AppUser;
import com.Hotel.Management.System.entity.Review;
import com.Hotel.Management.System.payload.ReviewDto;
import com.Hotel.Management.System.service.ReviewService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/review")
public class ReviewController {

    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    // ----------------------- Create ----------------------- //

    @PostMapping("/add-review")
    public ResponseEntity<?> addReviews(@RequestBody Review review,
                                          @RequestParam Long propertyId,
                                          @AuthenticationPrincipal AppUser appUserId) {
        if (reviewService.verifyUniqueReview(propertyId, appUserId)) {
            return new ResponseEntity<>("Review already exists for this property and user", HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(reviewService.addNewReviews(review,propertyId,appUserId), HttpStatus.CREATED);
    }

    // ------------------------ Read ------------------------ //

    @GetMapping("/get-reviews-id")
    public ResponseEntity<List<ReviewDto>> getAllReviews(@AuthenticationPrincipal AppUser appUserId) {
        return new ResponseEntity<>(reviewService.getAllReviewsByUser(appUserId), HttpStatus.OK);
    }

    @GetMapping("/get-all-review")
    public ResponseEntity<List<ReviewDto>> getAllReviews(){
        return new ResponseEntity<>(reviewService.getAllReviews(),HttpStatus.OK);
    }

    // ----------------------- Update ----------------------- //
    // ----------------------- Delete ----------------------- //
}
