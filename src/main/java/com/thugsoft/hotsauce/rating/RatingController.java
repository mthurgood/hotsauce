package com.thugsoft.hotsauce.rating;

import com.thugsoft.hotsauce.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RestController
@RequestMapping("/api/ratings")
public class RatingController {
    @Autowired
    private RatingRepository ratingRepository;

    @GetMapping
    public Iterable<Rating> getRatings() {
        return ratingRepository.findAll();
    }

    @GetMapping("/count")
    public Long countRatings() {
        return ratingRepository.count();
    }

    @GetMapping("/{id}")
    public Rating getRatingById(@PathVariable Long id) {
        return ratingRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Rating createRating(@RequestBody Rating rating) {
        return ratingRepository.save(rating);
    }

    @PutMapping("/{id}")
    public Rating updateRating(@PathVariable Long id, @RequestBody Rating rating) {
        Rating existingRating = ratingRepository.findById(id).orElse(null);
        if (existingRating == null) {
            return null;
        }
        existingRating.setSauceId(rating.getSauceId());
        existingRating.setUserId(rating.getUserId());
        existingRating.setRating(rating.getRating());
        existingRating.setNotes(rating.getNotes());
        return ratingRepository.save(existingRating);
    }
    @DeleteMapping("/{id}")
    public String deleteRating(@PathVariable Long id) {
        try {
            ratingRepository.deleteById(id);
            return "Deleted rating with id: " + id;
        } catch (Exception e) {
            return "Rating not found.";
        }
    }
}
