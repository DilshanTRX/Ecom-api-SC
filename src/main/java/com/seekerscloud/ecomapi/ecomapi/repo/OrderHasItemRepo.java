package com.seekerscloud.ecomapi.ecomapi.repo;

import com.seekerscloud.ecomapi.ecomapi.entity.OrderHasItem;
import com.seekerscloud.ecomapi.ecomapi.entity.compositekey.OrderHasItemId;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@EnableJpaRepositories
@Repository
public interface OrderHasItemRepo extends JpaRepository<OrderHasItem, OrderHasItemId> {
    @Query(value = "SELECT order_order_id as orderOrderId,item_code as itemCode,unit_price as unitPrice,qty FROM orders_has_item_table where  order_order_id like %?1%",nativeQuery = true)
     List<OrderHasItem> searchOrderHasItem(String searchText, PageRequest pageable);

    @Query(value = "SELECT count(*) FROM orders_has_item_table where order_order_id like %?1%",nativeQuery = true)
     int countOrderHasItem(String searchText);
    Optional<OrderHasItem> findByOrderOrderId(String order);

    void deleteByOrderHasItemId(OrderHasItemId orderHasItemId);

}
