package tn.esprit.spring.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entity.Rating;
import tn.esprit.spring.service.RatingService;

@RestController  
@RequestMapping("/rating")
public class RatingController {
	
	@Autowired  
	RatingService RatingService ;
	
	@GetMapping("/getAll")  
	@ResponseBody
	private List<Rating> getAllRatings()   
	{  
		return RatingService.getAll();  
	}  
	 
	@PostMapping("/add")  
	@ResponseBody
	private int saveRating(@RequestBody Rating Ratings)   
	{  
		RatingService.save(Ratings);  
		return Ratings.getId();  
	}  
	
	@GetMapping("/get/{Ratingid}")
	@ResponseBody
	private Rating getRating(@PathVariable("Ratingid") int Ratingid) {
		return RatingService.getById(Ratingid);
	}
	
	@GetMapping("/getSumCount/{Ratingid}")
	@ResponseBody
	private String getRatingSumCount(@PathVariable("Ratingid") int Ratingid) {
		return "Sum : " + RatingService.getRatingSum(Ratingid) + " // Count : " +  RatingService.getRatingCount(Ratingid);
	}

	@DeleteMapping("/{Ratingid}")
	@ResponseBody
	private void deleteRating(@PathVariable("Ratingid") int Ratingid) {
		RatingService.delete(Ratingid);
	}

	@PutMapping("/")
	@ResponseBody
	private Rating updateRating(@RequestBody Rating Ratings) {
		RatingService.update(Ratings);
		return Ratings;
	}
	
}  