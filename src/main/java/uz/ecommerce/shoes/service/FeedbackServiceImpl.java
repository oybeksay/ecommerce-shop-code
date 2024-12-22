package uz.ecommerce.shoes.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.ecommerce.shoes.dto.FeedbackDto;
import uz.ecommerce.shoes.entity.Feedback;
import uz.ecommerce.shoes.entity.Product;
import uz.ecommerce.shoes.entity.Users;
import uz.ecommerce.shoes.mapper.FeedbackMapper;
import uz.ecommerce.shoes.repository.FeedBackRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FeedbackServiceImpl implements FeedbackService {
    private final FeedbackMapper feedBackMapper;
    private final ProductService productService;
    private final FeedBackRepository feedBackRepository;
    private final UsersService usersService;

    @Override
    public Feedback createFeedBack(FeedbackDto feedBackDto) {
        Product product = productService.findProductById(feedBackDto.productId());
        Users user = usersService.findById(feedBackDto.userId());
        Feedback feedBack = feedBackMapper.toEntity(feedBackDto);
        feedBack.setProduct(product);
        feedBack.setUser(user);
        return feedBackRepository.save(feedBack);
    }

    @Override
    public List<Feedback> findAllFeedBacksByProductId(Long productId) {
        return feedBackRepository.findAllByProduct_Id(productId);
    }

    @Override
    public Feedback updateFeedBack(Long id, FeedbackDto feedBackDto) {
        Feedback feedBack = feedBackMapper.toEntity(feedBackDto);
        feedBack.setId(id);
        return feedBackRepository.save(feedBack);
    }

    @Override
    public void deleteFeedBackById(Long id) {
        feedBackRepository.deleteById(id);
    }
}
