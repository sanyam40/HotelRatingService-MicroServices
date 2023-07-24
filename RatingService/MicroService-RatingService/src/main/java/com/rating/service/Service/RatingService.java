package com.rating.service.Service;

import java.util.List;

import com.rating.service.entity.Rating;

public interface RatingService {
	
	Rating addRating(Rating rating);
	
	List<Rating>getRating();
	
	List<Rating>getRatingbyUserId(String userId);
	
	List<Rating>getRatingbyHotelId(String hotelId);
	
}
