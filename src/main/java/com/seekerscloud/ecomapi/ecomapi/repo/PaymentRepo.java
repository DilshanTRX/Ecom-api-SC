package com.seekerscloud.ecomapi.ecomapi.repo;

import com.seekerscloud.ecomapi.ecomapi.entity.Payment;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@EnableJpaRepositories
@Repository
public interface PaymentRepo extends JpaRepository<Payment,Integer> {
    @Query(value = "SELECT id,payment,payemnt_type,date,order_order_id FROM payment_table where payment like %?1% || id like %?1%",nativeQuery = true)
    public List<Payment> searchPayment(String searchText, PageRequest pageable);

    @Query(value = "SELECT count(id) FROM payment_table where payment like %?1% || id like %?1%",nativeQuery = true)
    public int countPayment(String searchText);

}
