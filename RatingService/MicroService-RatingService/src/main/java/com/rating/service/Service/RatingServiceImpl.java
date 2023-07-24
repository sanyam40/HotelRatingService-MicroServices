package com.rating.service.Service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rating.service.entity.Rating;
import com.rating.service.repo.RatingRepo;

@Service
public class RatingServiceImpl implements RatingService {

	@Autowired
	private RatingRepo ratingRepo;

	public Rating addRating(Rating rating) {
		UUID uuid=UUID.randomUUID();
        rating.setRatingId(uuid.toString());
		return ratingRepo.save(rating);
	}

	public List<Rating> getRating() {
		return ratingRepo.findAll();
	}

	public List<Rating> getRatingbyUserId(String userId) {
		return ratingRepo.findByUserId(userId);
	}

	public List<Rating> getRatingbyHotelId(String hotelId) {
		return ratingRepo.findByHotelId(hotelId);
	}

}
