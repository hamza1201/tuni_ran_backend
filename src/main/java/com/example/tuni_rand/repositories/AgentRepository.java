package com.example.tuni_rand.repositories;

import com.example.tuni_rand.domain.Agent;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface AgentRepository extends UserRepository<Agent>{
}
