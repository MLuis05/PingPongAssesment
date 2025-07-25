package com.SoleraBootcamp.PingPongAssesment.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.SoleraBootcamp.PingPongAssesment.Model.Vehicles;

@Repository
public interface VehiclesRepository extends JpaRepository<Vehicles, Long> {

}