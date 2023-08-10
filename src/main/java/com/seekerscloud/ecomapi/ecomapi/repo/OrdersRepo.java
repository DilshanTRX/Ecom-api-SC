package com.seekerscloud.ecomapi.ecomapi.repo;

import com.seekerscloud.ecomapi.ecomapi.entity.Orders;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@EnableJpaRepositories
@Repository
public interface OrdersRepo extends JpaRepository<Orders,String> {
    @Query(value = "SELECT order_id as orderId,order_date as orderDate,cost,user_id as UserId,customer_id as customerId FROM orders_table where  order_id like %?1%",nativeQuery = true)
    public List<Orders> searchOrders(String searchText, PageRequest pageable);

    @Query(value = "SELECT count(order_id) FROM program where order_id like %?1%",nativeQuery = true)
    public int countOrders(String searchText);
}
