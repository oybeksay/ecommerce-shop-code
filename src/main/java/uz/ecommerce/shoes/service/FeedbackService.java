package uz.ecommerce.shoes.service;

import uz.ecommerce.shoes.dto.FeedbackDto;
import uz.ecommerce.shoes.entity.Feedback;

import java.util.List;

public interface FeedbackService {

    Feedback createFeedBack(FeedbackDto feedBackDto);

    List<Feedback> findAllFeedBacksByProductId(Long productId);

    Feedback updateFeedBack(Long id, FeedbackDto feedBackDto);

    void deleteFeedBackById(Long id);

}
