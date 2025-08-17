package com.sbt.exercies.service.impls;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sbt.exercies.models.Order;
import com.sbt.exercies.models.OrderStatus;
import com.sbt.exercies.repositories.OrderRepository;
import com.sbt.exercies.service.OrderService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ImOrderService implements OrderService {
    
    private final OrderRepository orderRepository;
    
    // Operaciones CRUD básicas
    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }
    
    @Override
    public Optional<Order> getOrderById(Long id) {
        return orderRepository.findById(id);
    }
    
    @Override
    public Order createOrder(Order order) {
        if (validateOrder(order)) {
            order.setCreatedDate(new Date());
            if (order.getStatus() == null) {
                order.setStatus(OrderStatus.PENDING);
            }
            return orderRepository.save(order);
        }
        throw new IllegalArgumentException("La orden no es válida");
    }
    
    @Override
    public Order updateOrder(Long id, Order order) {
        Optional<Order> existingOrder = orderRepository.findById(id);
        if (existingOrder.isPresent()) {
            Order orderToUpdate = existingOrder.get();
            orderToUpdate.setTotal(order.getTotal());
            orderToUpdate.setStatus(order.getStatus());
            orderToUpdate.setClient(order.getClient());
            return orderRepository.save(orderToUpdate);
        }
        throw new IllegalArgumentException("Orden no encontrada con ID: " + id);
    }
    
    @Override
    public void deleteOrder(Long id) {
        if (orderRepository.existsById(id)) {
            orderRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("Orden no encontrada con ID: " + id);
        }
    }
    
    // Búsquedas por criterios
    @Override
    public List<Order> getOrdersByClientId(Long clientId) {
        return orderRepository.findByClientId(clientId);
    }
    
    @Override
    public List<Order> getOrdersByStatus(OrderStatus status) {
        return orderRepository.findByStatus(status);
    }
    
    @Override
    public List<Order> getOrdersByClientIdAndStatus(Long clientId, OrderStatus status) {
        return orderRepository.findByClientIdAndStatus(clientId, status);
    }
    
    // Búsquedas por rangos
    @Override
    public List<Order> getOrdersByDateRange(Date startDate, Date endDate) {
        return orderRepository.findByDateRange(startDate, endDate);
    }
    
    @Override
    public List<Order> getOrdersByTotalRange(Double minTotal, Double maxTotal) {
        return orderRepository.findByTotalRange(minTotal, maxTotal);
    }
    
    // Consultas de negocio
    @Override
    public List<Order> getActiveOrders() {
        return orderRepository.findActiveOrders();
    }
    
    @Override
    public List<Object[]> getOrderCountByStatus() {
        return orderRepository.countOrdersByStatus();
    }
    
    @Override
    public List<Object[]> getTotalSalesByClient() {
        return orderRepository.getTotalSalesByClient();
    }
    
    // Operaciones especiales
    @Override
    public Order changeOrderStatus(Long orderId, OrderStatus newStatus) {
        Optional<Order> order = orderRepository.findById(orderId);
        if (order.isPresent()) {
            Order orderToUpdate = order.get();
            orderToUpdate.setStatus(newStatus);
            return orderRepository.save(orderToUpdate);
        }
        throw new IllegalArgumentException("Orden no encontrada con ID: " + orderId);
    }
    
    @Override
    public Double calculateOrderTotal(Long orderId) {
        Optional<Order> order = orderRepository.findById(orderId);
        if (order.isPresent()) {
            return order.get().getTotal();
        }
        throw new IllegalArgumentException("Orden no encontrada con ID: " + orderId);
    }
    
    @Override
    public boolean validateOrder(Order order) {
        return order != null && 
               order.getClient() != null && 
               order.getTotal() != null && 
               order.getTotal() > 0;
    }
}
