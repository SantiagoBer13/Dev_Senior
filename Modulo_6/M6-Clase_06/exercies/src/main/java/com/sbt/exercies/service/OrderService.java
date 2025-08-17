package com.sbt.exercies.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.sbt.exercies.models.Order;
import com.sbt.exercies.models.OrderStatus;

public interface OrderService {
    
    // Operaciones CRUD básicas
    List<Order> getAllOrders();
    Optional<Order> getOrderById(Long id);
    Order createOrder(Order order);
    Order updateOrder(Long id, Order order);
    void deleteOrder(Long id);
    
    // Búsquedas por criterios
    List<Order> getOrdersByClientId(Long clientId);
    List<Order> getOrdersByStatus(OrderStatus status);
    List<Order> getOrdersByClientIdAndStatus(Long clientId, OrderStatus status);
    
    // Búsquedas por rangos
    List<Order> getOrdersByDateRange(Date startDate, Date endDate);
    List<Order> getOrdersByTotalRange(Double minTotal, Double maxTotal);
    
    // Consultas de negocio
    List<Order> getActiveOrders();
    List<Object[]> getOrderCountByStatus();
    List<Object[]> getTotalSalesByClient();
    
    // Operaciones especiales
    Order changeOrderStatus(Long orderId, OrderStatus newStatus);
    Double calculateOrderTotal(Long orderId);
    boolean validateOrder(Order order);
}
