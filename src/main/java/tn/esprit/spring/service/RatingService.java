package tn.esprit.spring.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Rating;
import tn.esprit.spring.repository.RatingRepository;

//defining the business logic  
@Service
public class RatingService {
	@Autowired
	RatingRepository ratingRepository;

	public List<Rating> getAll() {
		List<Rating> ratings = new ArrayList<Rating>();
		ratingRepository.findAll().forEach(rating1 -> ratings.add(rating1));
		return ratings;
	}

	public void save(Rating ratings) {
		System.out.println("teesssss_Repo");
		ratingRepository.save(ratings);
	}

	public Rating getById(int id) {
		return ratingRepository.findById(id).get();
	}

	public void update(Rating ratings) {
		ratingRepository.save(ratings);
	}

	public void delete(int id) {
		ratingRepository.deleteById(id);
	}
}