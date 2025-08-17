package com.sbt.exercies.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sbt.exercies.models.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
    
    // Buscar items por orden
    List<OrderItem> findByOrderId(Long orderId);
    
    // Buscar items por producto
    List<OrderItem> findByProductId(Long productId);
    
    // Buscar items por orden y producto
    List<OrderItem> findByOrderIdAndProductId(Long orderId, Long productId);
    
    // Buscar items con cantidad mayor a un valor
    List<OrderItem> findByQuantityGreaterThan(Integer quantity);
    
    // Buscar items con precio unitario mayor a un valor
    List<OrderItem> findByUnitPriceGreaterThan(Double unitPrice);
    
    // Buscar items por rango de subtotal
    @Query("SELECT oi FROM OrderItem oi WHERE oi.subtotal BETWEEN :minSubtotal AND :maxSubtotal")
    List<OrderItem> findBySubtotalRange(@Param("minSubtotal") Double minSubtotal, 
                                       @Param("maxSubtotal") Double maxSubtotal);
    
    // Obtener el total de ventas por producto
    @Query("SELECT oi.product.id, SUM(oi.subtotal), COUNT(oi) FROM OrderItem oi GROUP BY oi.product.id")
    List<Object[]> getTotalSalesByProduct();
    
    // Obtener productos más vendidos (por cantidad)
    @Query("SELECT oi.product.id, SUM(oi.quantity) as totalQuantity FROM OrderItem oi GROUP BY oi.product.id ORDER BY totalQuantity DESC")
    List<Object[]> getTopSellingProducts();
    
    // Obtener productos más rentables (por subtotal)
    @Query("SELECT oi.product.id, SUM(oi.subtotal) as totalRevenue FROM OrderItem oi GROUP BY oi.product.id ORDER BY totalRevenue DESC")
    List<Object[]> getTopRevenueProducts();
    
    // Buscar items de órdenes en un rango de fechas
    @Query("SELECT oi FROM OrderItem oi WHERE oi.order.createdDate BETWEEN :startDate AND :endDate")
    List<OrderItem> findByOrderDateRange(@Param("startDate") java.util.Date startDate, 
                                        @Param("endDate") java.util.Date endDate);
    
    // Obtener estadísticas de ventas por período
    @Query("SELECT DATE(oi.order.createdDate), SUM(oi.subtotal), COUNT(oi) FROM OrderItem oi " +
           "WHERE oi.order.createdDate BETWEEN :startDate AND :endDate " +
           "GROUP BY DATE(oi.order.createdDate) ORDER BY DATE(oi.order.createdDate)")
    List<Object[]> getSalesStatisticsByDate(@Param("startDate") java.util.Date startDate, 
                                           @Param("endDate") java.util.Date endDate);
}
