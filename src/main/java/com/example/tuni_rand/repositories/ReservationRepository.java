package com.example.tuni_rand.repositories;

import com.example.tuni_rand.domain.Reservation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends CrudRepository<Reservation,Long> {
}
