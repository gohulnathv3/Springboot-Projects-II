package com.msdemo.moviecatalogservice.resources;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.msdemo.moviecatalogservice.models.CatalogItem;
import com.msdemo.moviecatalogservice.models.Movie;
import com.msdemo.moviecatalogservice.models.Rating;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {
	
	@RequestMapping("/{userId}")
	public List<CatalogItem> getCatalog(@PathVariable("userId")String userID){
	
		
		RestTemplate restTemplate = new RestTemplate();
		
		List<Rating> ratings = Arrays.asList(
				new Rating("1234",4),
				new Rating("3", 5),
				new Rating("FastFive", 5)
				);
		
		 return ratings.stream().map(rating ->
		 {
			 Movie movie = restTemplate.getForObject("http://localhost:8082/movies/"+rating.getMovieId(), Movie.class);
			 return new CatalogItem(movie.getName(), "Desc", rating.getRating());
		 }).collect(Collectors.toList()); 
		 
		
	}
	
}
