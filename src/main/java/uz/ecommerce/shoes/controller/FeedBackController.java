package uz.ecommerce.shoes.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.ecommerce.shoes.dto.FeedbackDto;
import uz.ecommerce.shoes.entity.Feedback;
import uz.ecommerce.shoes.service.FeedbackService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/feedback")
public class FeedBackController {

    private final FeedbackService feedBackService;

    @PostMapping("/create")
    public ResponseEntity<Feedback> createFeedBack(@RequestBody FeedbackDto feedBackDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(feedBackService.createFeedBack(feedBackDto));
    }

    @GetMapping("/findAllByProductId/{productId}")
    public ResponseEntity<List<Feedback>> findAllFeedBacksByProductId(@PathVariable Long productId) {
        return ResponseEntity.ok(feedBackService.findAllFeedBacksByProductId(productId));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteFeedBackById(@PathVariable Long id) {
        feedBackService.deleteFeedBackById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Feedback> updateFeedBack(@PathVariable Long id, @RequestBody FeedbackDto feedBackDto) {
        return ResponseEntity.status(200).body(feedBackService.updateFeedBack(id, feedBackDto));
    }

}
