package com.netcracker.order.service;

import com.netcracker.order.domain.Order;
import com.netcracker.order.domain.OrderItem;
import com.netcracker.order.service.exception.OrderItemNotFoundException;
import com.netcracker.order.service.exception.OrderNotFoundException;
import com.netcracker.order.service.exception.OrderPaidException;

import java.util.List;

public interface OrderService {
    Order createOrder(Order order);

    OrderItem createOrderItem(OrderItem orderItem);

    Order getOrder(int orderId);

    void deleteOrder(int orderId);

    List<Order> getOrders(int limit, int page);

    void updateOrder(Order order, int orderId);

    List<Order> searchOrdersByEmail(String email, int page, int limit);

    List<Order> searchOrdersByStatus(boolean paid, int page, int limit);

    void deleteOrderItem(int orderItemId) throws OrderItemNotFoundException, OrderPaidException;

    int getTotalOrderCount(String email);

    double getTotalPrice(String email);

    void payForOrder(int orderId) throws OrderNotFoundException, OrderPaidException;
}