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

import com.sbt.exercies.models.Order;
import com.sbt.exercies.models.OrderStatus;
import com.sbt.exercies.service.OrderService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/orders")
@RequiredArgsConstructor
public class OrderController {
    
    private final OrderService orderService;
    
    // ==================== OPERACIONES CRUD BÁSICAS ====================
    
    @GetMapping("")
    public ResponseEntity<List<Order>> getAllOrders() {
        List<Order> orders = orderService.getAllOrders();
        return ResponseEntity.ok(orders);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable Long id) {
        Optional<Order> order = orderService.getOrderById(id);
        return order.map(ResponseEntity::ok)
                   .orElse(ResponseEntity.notFound().build());
    }
    
    @PostMapping("")
    public ResponseEntity<Order> createOrder(@Valid @RequestBody Order order) {
        try {
            Order createdOrder = orderService.createOrder(order);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdOrder);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Order> updateOrder(@PathVariable Long id, @Valid @RequestBody Order order) {
        try {
            Order updatedOrder = orderService.updateOrder(id, order);
            return ResponseEntity.ok(updatedOrder);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable Long id) {
        try {
            orderService.deleteOrder(id);
            return ResponseEntity.noContent().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }
    
    // ==================== BÚSQUEDAS POR CRITERIOS ====================
    
    @GetMapping("/client/{clientId}")
    public ResponseEntity<List<Order>> getOrdersByClientId(@PathVariable Long clientId) {
        List<Order> orders = orderService.getOrdersByClientId(clientId);
        return ResponseEntity.ok(orders);
    }
    
    @GetMapping("/status/{status}")
    public ResponseEntity<List<Order>> getOrdersByStatus(@PathVariable OrderStatus status) {
        List<Order> orders = orderService.getOrdersByStatus(status);
        return ResponseEntity.ok(orders);
    }
    
    @GetMapping("/client/{clientId}/status/{status}")
    public ResponseEntity<List<Order>> getOrdersByClientIdAndStatus(
            @PathVariable Long clientId, 
            @PathVariable OrderStatus status) {
        List<Order> orders = orderService.getOrdersByClientIdAndStatus(clientId, status);
        return ResponseEntity.ok(orders);
    }
    
    // ==================== BÚSQUEDAS POR RANGOS ====================
    
    @GetMapping("/date-range")
    public ResponseEntity<List<Order>> getOrdersByDateRange(
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate) {
        List<Order> orders = orderService.getOrdersByDateRange(startDate, endDate);
        return ResponseEntity.ok(orders);
    }
    
    @GetMapping("/total-range")
    public ResponseEntity<List<Order>> getOrdersByTotalRange(
            @RequestParam Double minTotal,
            @RequestParam Double maxTotal) {
        List<Order> orders = orderService.getOrdersByTotalRange(minTotal, maxTotal);
        return ResponseEntity.ok(orders);
    }
    
    // ==================== CONSULTAS DE NEGOCIO ====================
    
    @GetMapping("/active")
    public ResponseEntity<List<Order>> getActiveOrders() {
        List<Order> orders = orderService.getActiveOrders();
        return ResponseEntity.ok(orders);
    }
    
    @GetMapping("/stats/count-by-status")
    public ResponseEntity<List<Object[]>> getOrderCountByStatus() {
        List<Object[]> stats = orderService.getOrderCountByStatus();
        return ResponseEntity.ok(stats);
    }
    
    @GetMapping("/stats/sales-by-client")
    public ResponseEntity<List<Object[]>> getTotalSalesByClient() {
        List<Object[]> stats = orderService.getTotalSalesByClient();
        return ResponseEntity.ok(stats);
    }
    
    // ==================== OPERACIONES ESPECIALES ====================
    
    @PutMapping("/{id}/status")
    public ResponseEntity<Order> changeOrderStatus(
            @PathVariable Long id, 
            @RequestParam OrderStatus newStatus) {
        try {
            Order updatedOrder = orderService.changeOrderStatus(id, newStatus);
            return ResponseEntity.ok(updatedOrder);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }
    
    @GetMapping("/{id}/total")
    public ResponseEntity<Double> calculateOrderTotal(@PathVariable Long id) {
        try {
            Double total = orderService.calculateOrderTotal(id);
            return ResponseEntity.ok(total);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
