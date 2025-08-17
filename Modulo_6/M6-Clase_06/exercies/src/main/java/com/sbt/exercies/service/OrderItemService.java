package com.sbt.exercies.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.sbt.exercies.models.OrderItem;

public interface OrderItemService {
    
    // Operaciones CRUD básicas
    List<OrderItem> getAllOrderItems();
    Optional<OrderItem> getOrderItemById(Long id);
    OrderItem createOrderItem(OrderItem orderItem);
    OrderItem updateOrderItem(Long id, OrderItem orderItem);
    void deleteOrderItem(Long id);
    
    // Búsquedas por criterios
    List<OrderItem> getOrderItemsByOrderId(Long orderId);
    List<OrderItem> getOrderItemsByProductId(Long productId);
    List<OrderItem> getOrderItemsByOrderIdAndProductId(Long orderId, Long productId);
    
    // Búsquedas por valores
    List<OrderItem> getOrderItemsByQuantityGreaterThan(Integer quantity);
    List<OrderItem> getOrderItemsByUnitPriceGreaterThan(Double unitPrice);
    List<OrderItem> getOrderItemsBySubtotalRange(Double minSubtotal, Double maxSubtotal);
    
    // Análisis de ventas
    List<Object[]> getTotalSalesByProduct();
    List<Object[]> getTopSellingProducts();
    List<Object[]> getTopRevenueProducts();
    
    // Estadísticas temporales
    List<OrderItem> getOrderItemsByOrderDateRange(Date startDate, Date endDate);
    List<Object[]> getSalesStatisticsByDate(Date startDate, Date endDate);
    
    // Operaciones especiales
    Double calculateOrderItemSubtotal(Long orderItemId);
    boolean validateOrderItem(OrderItem orderItem);
    void recalculateOrderTotal(Long orderId);
}
