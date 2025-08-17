package com.sbt.exercies.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sbt.exercies.models.Order;
import com.sbt.exercies.models.OrderStatus;

public interface OrderRepository extends JpaRepository<Order, Long> {
    
    // Buscar órdenes por cliente
    List<Order> findByClientId(Long clientId);
    
    // Buscar órdenes por estado
    List<Order> findByStatus(OrderStatus status);
    
    // Buscar órdenes por cliente y estado
    List<Order> findByClientIdAndStatus(Long clientId, OrderStatus status);
    
    // Buscar órdenes por rango de fechas
    @Query("SELECT o FROM Order o WHERE o.createdDate BETWEEN :startDate AND :endDate")
    List<Order> findByDateRange(@Param("startDate") java.util.Date startDate, 
                                @Param("endDate") java.util.Date endDate);
    
    // Buscar órdenes por rango de total
    @Query("SELECT o FROM Order o WHERE o.total BETWEEN :minTotal AND :maxTotal")
    List<Order> findByTotalRange(@Param("minTotal") Double minTotal, 
                                 @Param("maxTotal") Double maxTotal);
    
    // Buscar órdenes activas (isActive = true)
    @Query("SELECT o FROM Order o WHERE o.client.isActive = true")
    List<Order> findActiveOrders();
    
    // Contar órdenes por estado
    @Query("SELECT o.status, COUNT(o) FROM Order o GROUP BY o.status")
    List<Object[]> countOrdersByStatus();
    
    // Obtener el total de ventas por cliente
    @Query("SELECT o.client.id, SUM(o.total) FROM Order o GROUP BY o.client.id")
    List<Object[]> getTotalSalesByClient();
}
