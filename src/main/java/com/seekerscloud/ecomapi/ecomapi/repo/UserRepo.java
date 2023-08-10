package com.seekerscloud.ecomapi.ecomapi.repo;

import com.seekerscloud.ecomapi.ecomapi.entity.User;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@EnableJpaRepositories
@Repository
public interface UserRepo extends JpaRepository<User,String> {
    @Query(value = "SELECT id,email,name,password FROM user_table where name like %?1% || id like %?1%",nativeQuery = true)
    public List<User> searchUser(String searchText, PageRequest pageable);

    @Query(value = "SELECT count(id) FROM user_table where name like %?1% || id like %?1%",nativeQuery = true)
    public int countUser(String searchText);

}
