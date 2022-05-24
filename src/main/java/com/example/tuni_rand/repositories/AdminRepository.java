package com.example.tuni_rand.repositories;

import com.example.tuni_rand.domain.Admin;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;


@Repository
public interface AdminRepository extends UserRepository<Admin>{
}
