package com.example.tuni_rand.repositories;

import com.example.tuni_rand.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository<T extends User> extends CrudRepository<T,Long> {
    User findByUsername(String username);

    User getById(Long id);
}
