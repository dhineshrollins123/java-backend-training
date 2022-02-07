package com.RedBusApplication.repository;

import com.RedBusApplication.domain.RedBusReservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RedBusRepository extends JpaRepository<RedBusReservation, Long> {



}
