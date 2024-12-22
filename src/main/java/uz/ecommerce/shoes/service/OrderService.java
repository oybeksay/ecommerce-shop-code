package uz.ecommerce.shoes.service;

import uz.ecommerce.shoes.dto.OrderDto;
import uz.ecommerce.shoes.entity.Order;
import uz.ecommerce.shoes.entity.Product;

import java.util.List;

public interface OrderService {

    Order createOrder(OrderDto orderDto);

    Order findOrderById(Long id);

    List<Order> findAllOrders();

    Order updateOrder(Long id, OrderDto orderDto);

    void deleteOrderById(Long id);

    Double sumTotalPrice(List<Product> products);

}
