package com.example.tuni_rand.repositories;

import com.example.tuni_rand.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;


@NoRepositoryBean
@Repository
public interface UserRepository<T extends User> extends CrudRepository<T,Long> {
}
