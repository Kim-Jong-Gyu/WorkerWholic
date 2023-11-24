package com.example.workerwholic.location.repository;

import com.example.workerwholic.location.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location, Long> {

}
