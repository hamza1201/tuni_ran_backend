package com.example.tuni_rand.repositories;

import com.example.tuni_rand.domain.Offre;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface OffreRepository extends CrudRepository<Offre,Long> {
}
