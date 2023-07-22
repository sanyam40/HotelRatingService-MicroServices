package com.user.service.services;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.user.service.entity.Hotel;
import com.user.service.entity.Rating;
import com.user.service.entity.User;
import com.user.service.exceptions.ResourceNotFoundException;
import com.user.service.externalServices.HotelService;
import com.user.service.repository.UserRepo;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepo userRepo;

	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private HotelService hotelService;

	
	// private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

	@Override
	public User saveUser(User user) {
		// generate random user id
		UUID uuid = UUID.randomUUID();
		user.setUserId(uuid.toString());
		return userRepo.save(user);
	}

	@Override
	public List<User> getUsers() {
		return userRepo.findAll();
	}

	@Override
	public User getUser(String id) {

		User user = userRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("User not found by id : " + id));
		// fetching rating from rating service

		Rating[] ratingOfUser = restTemplate.getForObject("http://RATING-SERVICE/api/rating/user/" + user.getUserId(),
				Rating[].class);
		// logger.info("{} ", ratingOfUser);

		List<Rating> ratings = Arrays.stream(ratingOfUser).toList();

		List<Rating> ratingList = ratings.stream().map(rating -> {
			// API call to hotelService to get the hotel
			
//			ResponseEntity<Hotel> forEntity = restTemplate
//					.getForEntity("http://HOTEL-SERVICE/api/hotels/" + rating.getHotelId(), Hotel.class);
//			Hotel hotel = forEntity.getBody();
			
			Hotel hotel=hotelService.getHotel(rating.getHotelId());
			rating.setHotel(hotel);

			return rating;
		}).collect(Collectors.toList());

		user.setRatings(ratingList);

		return user;
	}
}
