package com.seekerscloud.ecomapi.ecomapi.repo;

import com.seekerscloud.ecomapi.ecomapi.entity.Customer;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@EnableJpaRepositories
@Repository
public interface CustomerRepo extends JpaRepository<Customer,String> {
    @Query(value = "SELECT id,name,address,salary FROM customer_table where name like %?1% || id like %?1%",nativeQuery = true)
    public List<Customer> searchCustomer(String searchText, PageRequest pageable);

    @Query(value = "SELECT count(id) FROM program where name like %?1% || id like %?1%",nativeQuery = true)
    public int countCustomer(String searchText);

}
