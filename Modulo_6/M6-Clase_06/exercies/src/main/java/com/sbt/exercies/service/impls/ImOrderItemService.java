package com.sbt.exercies.service.impls;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sbt.exercies.models.OrderItem;
import com.sbt.exercies.repositories.OrderItemRepository;
import com.sbt.exercies.service.OrderItemService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ImOrderItemService implements OrderItemService {
    
    private final OrderItemRepository orderItemRepository;
    
    // Operaciones CRUD básicas
    @Override
    public List<OrderItem> getAllOrderItems() {
        return orderItemRepository.findAll();
    }
    
    @Override
    public Optional<OrderItem> getOrderItemById(Long id) {
        return orderItemRepository.findById(id);
    }
    
    @Override
    public OrderItem createOrderItem(OrderItem orderItem) {
        if (validateOrderItem(orderItem)) {
            // Calcular subtotal automáticamente
            orderItem.setSubtotal(orderItem.getQuantity() * orderItem.getUnitPrice());
            return orderItemRepository.save(orderItem);
        }
        throw new IllegalArgumentException("El item de orden no es válido");
    }
    
    @Override
    public OrderItem updateOrderItem(Long id, OrderItem orderItem) {
        Optional<OrderItem> existingItem = orderItemRepository.findById(id);
        if (existingItem.isPresent()) {
            OrderItem itemToUpdate = existingItem.get();
            itemToUpdate.setQuantity(orderItem.getQuantity());
            itemToUpdate.setUnitPrice(orderItem.getUnitPrice());
            itemToUpdate.setProduct(orderItem.getProduct());
            itemToUpdate.setOrder(orderItem.getOrder());
            // Recalcular subtotal
            itemToUpdate.setSubtotal(itemToUpdate.getQuantity() * itemToUpdate.getUnitPrice());
            return orderItemRepository.save(itemToUpdate);
        }
        throw new IllegalArgumentException("Item de orden no encontrado con ID: " + id);
    }
    
    @Override
    public void deleteOrderItem(Long id) {
        if (orderItemRepository.existsById(id)) {
            orderItemRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("Item de orden no encontrado con ID: " + id);
        }
    }
    
    // Búsquedas por criterios
    @Override
    public List<OrderItem> getOrderItemsByOrderId(Long orderId) {
        return orderItemRepository.findByOrderId(orderId);
    }
    
    @Override
    public List<OrderItem> getOrderItemsByProductId(Long productId) {
        return orderItemRepository.findByProductId(productId);
    }
    
    @Override
    public List<OrderItem> getOrderItemsByOrderIdAndProductId(Long orderId, Long productId) {
        return orderItemRepository.findByOrderIdAndProductId(orderId, productId);
    }
    
    // Búsquedas por valores
    @Override
    public List<OrderItem> getOrderItemsByQuantityGreaterThan(Integer quantity) {
        return orderItemRepository.findByQuantityGreaterThan(quantity);
    }
    
    @Override
    public List<OrderItem> getOrderItemsByUnitPriceGreaterThan(Double unitPrice) {
        return orderItemRepository.findByUnitPriceGreaterThan(unitPrice);
    }
    
    @Override
    public List<OrderItem> getOrderItemsBySubtotalRange(Double minSubtotal, Double maxSubtotal) {
        return orderItemRepository.findBySubtotalRange(minSubtotal, maxSubtotal);
    }
    
    // Análisis de ventas
    @Override
    public List<Object[]> getTotalSalesByProduct() {
        return orderItemRepository.getTotalSalesByProduct();
    }
    
    @Override
    public List<Object[]> getTopSellingProducts() {
        return orderItemRepository.getTopSellingProducts();
    }
    
    @Override
    public List<Object[]> getTopRevenueProducts() {
        return orderItemRepository.getTopRevenueProducts();
    }
    
    // Estadísticas temporales
    @Override
    public List<OrderItem> getOrderItemsByOrderDateRange(Date startDate, Date endDate) {
        return orderItemRepository.findByOrderDateRange(startDate, endDate);
    }
    
    @Override
    public List<Object[]> getSalesStatisticsByDate(Date startDate, Date endDate) {
        return orderItemRepository.getSalesStatisticsByDate(startDate, endDate);
    }
    
    // Operaciones especiales
    @Override
    public Double calculateOrderItemSubtotal(Long orderItemId) {
        Optional<OrderItem> orderItem = orderItemRepository.findById(orderItemId);
        if (orderItem.isPresent()) {
            return orderItem.get().getSubtotal();
        }
        throw new IllegalArgumentException("Item de orden no encontrado con ID: " + orderItemId);
    }
    
    @Override
    public boolean validateOrderItem(OrderItem orderItem) {
        return orderItem != null && 
               orderItem.getOrder() != null && 
               orderItem.getProduct() != null && 
               orderItem.getQuantity() != null && 
               orderItem.getQuantity() > 0 && 
               orderItem.getUnitPrice() != null && 
               orderItem.getUnitPrice() > 0;
    }
    
    @Override
    public void recalculateOrderTotal(Long orderId) {
        List<OrderItem> items = getOrderItemsByOrderId(orderId);
        double total = items.stream()
                           .mapToDouble(OrderItem::getSubtotal)
                           .sum();
        
        // Aquí necesitarías actualizar la orden con el nuevo total
        // Esto requeriría inyectar OrderService o usar un evento
        // Por ahora solo calculamos el total
    }
}
