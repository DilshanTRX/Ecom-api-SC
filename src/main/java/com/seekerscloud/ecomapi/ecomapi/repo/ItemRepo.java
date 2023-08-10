package com.seekerscloud.ecomapi.ecomapi.repo;

import com.seekerscloud.ecomapi.ecomapi.entity.Item;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@EnableJpaRepositories
@Repository
public interface ItemRepo extends JpaRepository<Item,Integer> {
    @Query(value = "SELECT code,barcode,description,qty,unit_price as unitPrice,barcode FROM item_table where description like %?1% || code like %?1%",nativeQuery = true)
    public List<Item> searchItem(String searchText, PageRequest pageable);

    @Query(value = "SELECT count(code) FROM program where description like %?1% || code like %?1%",nativeQuery = true)
    public int countItem(String searchText);

}
