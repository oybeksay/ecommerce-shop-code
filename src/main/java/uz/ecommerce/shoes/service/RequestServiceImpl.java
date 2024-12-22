package uz.ecommerce.shoes.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.ecommerce.shoes.entity.Product;
import uz.ecommerce.shoes.entity.Request;
import uz.ecommerce.shoes.entity.RequestDto;
import uz.ecommerce.shoes.entity.Users;
import uz.ecommerce.shoes.exception.ResourceNotFound;
import uz.ecommerce.shoes.repository.RequestRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RequestServiceImpl implements RequestService {
    private final UsersService usersService;
    private final ProductService productService;
    private final RequestRepository requestRepository;

    @Override
    public Request createRequest(RequestDto requestDto) {
        Product product = productService.findProductById(requestDto.productId());
        Users user = usersService.findById(requestDto.userId());
        if (product.getStockQuantity() < requestDto.productCount()) {
            throw new RuntimeException("Product stock quantity is not enough");
        }
        Request request = Request.builder()
                .productCount(requestDto.productCount())
                .product(product)
                .user(user)
                .build();
        return requestRepository.save(request);
    }

    @Override
    public Request findRequestById(Long id) {
        return requestRepository.findById(id).orElseThrow(() -> new ResourceNotFound("Request not found by id :" + id));
    }

    @Override
    public List<Request> findAllRequestsByUserId(Long userId) {
        return requestRepository.findAllByUser_Id(userId);
    }

    @Override
    public List<Request> findAllRequestsByProductId(Long productId) {
        return requestRepository.findAllByProduct_Id(productId);
    }

    @Override
    public void deleteRequestById(Long id) {
        requestRepository.deleteById(id);
    }

    @Override
    public void deleteRequestByUserId(Long userId) {
        requestRepository.deleteAllByUser_Id(userId);
    }


}
