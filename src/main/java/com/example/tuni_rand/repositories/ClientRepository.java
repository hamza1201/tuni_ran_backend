package com.example.tuni_rand.repositories;

import com.example.tuni_rand.domain.Client;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface ClientRepository extends UserRepository<Client>{
}
