package uz.ecommerce.shoes.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.ecommerce.shoes.dto.OrderDto;
import uz.ecommerce.shoes.entity.Order;
import uz.ecommerce.shoes.entity.Product;
import uz.ecommerce.shoes.entity.Request;
import uz.ecommerce.shoes.exception.ResourceNotFound;
import uz.ecommerce.shoes.mapper.OrderMapper;
import uz.ecommerce.shoes.repository.OrderRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderMapper orderMapper;
    private final RequestService requestService;
    private final OrderRepository orderRepository;

    @Override
    public Order createOrder(OrderDto orderDto) {
        Order order = orderMapper.toEntity(orderDto);
        List<Request> requests = orderDto.requestsIds().stream().map(requestService::findRequestById).toList();
        order.setRequests(requests);
        order.setTotalPrice(sumTotalPrice(requests.stream().map(Request::getProduct).toList()));
        return orderRepository.save(order);
    }

    @Override
    public Order findOrderById(Long id) {
        return orderRepository.findById(id).orElseThrow(() -> new ResourceNotFound("Order not found by id :" + id));
    }

    @Override
    public List<Order> findAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Order updateOrder(Long id, OrderDto orderDto) {
        Order order = orderMapper.toEntity(orderDto);
        List<Request> requests = orderDto.requestsIds().stream().map(requestService::findRequestById).toList();
        order.setId(id);
        order.setRequests(requests);
        return orderRepository.save(order);
    }

    @Override
    public void deleteOrderById(Long id) {
        orderRepository.deleteById(id);
    }

    @Override
    public Double sumTotalPrice(List<Product> products) {
        Double sum = 0.0;
        for (Product product : products) {
            sum += product.getSalePrice();
        }
        return sum;
    }


}
