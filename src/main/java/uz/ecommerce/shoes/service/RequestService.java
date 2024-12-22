package uz.ecommerce.shoes.service;

import uz.ecommerce.shoes.entity.Request;
import uz.ecommerce.shoes.entity.RequestDto;

import java.util.List;

public interface RequestService {

    Request createRequest(RequestDto requestDto);

    Request findRequestById(Long id);

    List<Request> findAllRequestsByUserId(Long userId);

    List<Request> findAllRequestsByProductId(Long productId);

    void deleteRequestById(Long id);

    void deleteRequestByUserId(Long userId);

}
