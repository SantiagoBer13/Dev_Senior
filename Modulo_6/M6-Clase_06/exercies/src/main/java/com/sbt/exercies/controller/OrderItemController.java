package com.sbt.exercies.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sbt.exercies.models.OrderItem;
import com.sbt.exercies.service.OrderItemService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/order-items")
@RequiredArgsConstructor
public class OrderItemController {
    
    private final OrderItemService orderItemService;
    
    // ==================== OPERACIONES CRUD BÁSICAS ====================
    
    @GetMapping("")
    public ResponseEntity<List<OrderItem>> getAllOrderItems() {
        List<OrderItem> orderItems = orderItemService.getAllOrderItems();
        return ResponseEntity.ok(orderItems);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<OrderItem> getOrderItemById(@PathVariable Long id) {
        Optional<OrderItem> orderItem = orderItemService.getOrderItemById(id);
        return orderItem.map(ResponseEntity::ok)
                       .orElse(ResponseEntity.notFound().build());
    }
    
    @PostMapping("")
    public ResponseEntity<OrderItem> createOrderItem(@Valid @RequestBody OrderItem orderItem) {
        try {
            OrderItem createdOrderItem = orderItemService.createOrderItem(orderItem);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdOrderItem);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<OrderItem> updateOrderItem(@PathVariable Long id, @Valid @RequestBody OrderItem orderItem) {
        try {
            OrderItem updatedOrderItem = orderItemService.updateOrderItem(id, orderItem);
            return ResponseEntity.ok(updatedOrderItem);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrderItem(@PathVariable Long id) {
        try {
            orderItemService.deleteOrderItem(id);
            return ResponseEntity.noContent().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }
    
    // ==================== BÚSQUEDAS POR CRITERIOS ====================
    
    @GetMapping("/order/{orderId}")
    public ResponseEntity<List<OrderItem>> getOrderItemsByOrderId(@PathVariable Long orderId) {
        List<OrderItem> orderItems = orderItemService.getOrderItemsByOrderId(orderId);
        return ResponseEntity.ok(orderItems);
    }
    
    @GetMapping("/product/{productId}")
    public ResponseEntity<List<OrderItem>> getOrderItemsByProductId(@PathVariable Long productId) {
        List<OrderItem> orderItems = orderItemService.getOrderItemsByProductId(productId);
        return ResponseEntity.ok(orderItems);
    }
    
    @GetMapping("/order/{orderId}/product/{productId}")
    public ResponseEntity<List<OrderItem>> getOrderItemsByOrderIdAndProductId(
            @PathVariable Long orderId, 
            @PathVariable Long productId) {
        List<OrderItem> orderItems = orderItemService.getOrderItemsByOrderIdAndProductId(orderId, productId);
        return ResponseEntity.ok(orderItems);
    }
    
    // ==================== BÚSQUEDAS POR VALORES ====================
    
    @GetMapping("/quantity-greater-than")
    public ResponseEntity<List<OrderItem>> getOrderItemsByQuantityGreaterThan(
            @RequestParam Integer quantity) {
        List<OrderItem> orderItems = orderItemService.getOrderItemsByQuantityGreaterThan(quantity);
        return ResponseEntity.ok(orderItems);
    }
    
    @GetMapping("/unit-price-greater-than")
    public ResponseEntity<List<OrderItem>> getOrderItemsByUnitPriceGreaterThan(
            @RequestParam Double unitPrice) {
        List<OrderItem> orderItems = orderItemService.getOrderItemsByUnitPriceGreaterThan(unitPrice);
        return ResponseEntity.ok(orderItems);
    }
    
    @GetMapping("/subtotal-range")
    public ResponseEntity<List<OrderItem>> getOrderItemsBySubtotalRange(
            @RequestParam Double minSubtotal,
            @RequestParam Double maxSubtotal) {
        List<OrderItem> orderItems = orderItemService.getOrderItemsBySubtotalRange(minSubtotal, maxSubtotal);
        return ResponseEntity.ok(orderItems);
    }
    
    // ==================== ANÁLISIS DE VENTAS ====================
    
    @GetMapping("/analytics/sales-by-product")
    public ResponseEntity<List<Object[]>> getTotalSalesByProduct() {
        List<Object[]> analytics = orderItemService.getTotalSalesByProduct();
        return ResponseEntity.ok(analytics);
    }
    
    @GetMapping("/analytics/top-selling-products")
    public ResponseEntity<List<Object[]>> getTopSellingProducts() {
        List<Object[]> analytics = orderItemService.getTopSellingProducts();
        return ResponseEntity.ok(analytics);
    }
    
    @GetMapping("/analytics/top-revenue-products")
    public ResponseEntity<List<Object[]>> getTopRevenueProducts() {
        List<Object[]> analytics = orderItemService.getTopRevenueProducts();
        return ResponseEntity.ok(analytics);
    }
    
    // ==================== ESTADÍSTICAS TEMPORALES ====================
    
    @GetMapping("/date-range")
    public ResponseEntity<List<OrderItem>> getOrderItemsByOrderDateRange(
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate) {
        List<OrderItem> orderItems = orderItemService.getOrderItemsByOrderDateRange(startDate, endDate);
        return ResponseEntity.ok(orderItems);
    }
    
    @GetMapping("/analytics/sales-statistics-by-date")
    public ResponseEntity<List<Object[]>> getSalesStatisticsByDate(
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate) {
        List<Object[]> statistics = orderItemService.getSalesStatisticsByDate(startDate, endDate);
        return ResponseEntity.ok(statistics);
    }
    
    // ==================== OPERACIONES ESPECIALES ====================
    
    @GetMapping("/{id}/subtotal")
    public ResponseEntity<Double> calculateOrderItemSubtotal(@PathVariable Long id) {
        try {
            Double subtotal = orderItemService.calculateOrderItemSubtotal(id);
            return ResponseEntity.ok(subtotal);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }
    
    @PostMapping("/order/{orderId}/recalculate-total")
    public ResponseEntity<Void> recalculateOrderTotal(@PathVariable Long orderId) {
        try {
            orderItemService.recalculateOrderTotal(orderId);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
