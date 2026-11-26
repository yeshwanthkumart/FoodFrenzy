package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entities.Review;
import com.example.demo.services.ReviewService;

import jakarta.validation.Valid;

@Controller
public class ReviewController {

    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping("/reviews")
    public String reviews(Model model) {
        model.addAttribute("review", new Review());
        model.addAttribute("reviews", reviewService.getNewestFirst());
        return "Reviews";
    }

    @PostMapping("/reviews")
    public String addReview(@Valid @ModelAttribute("review") Review review, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("reviews", reviewService.getNewestFirst());
            return "Reviews";
        }

        reviewService.addReview(review);
        return "redirect:/reviews?submitted";
    }
}
