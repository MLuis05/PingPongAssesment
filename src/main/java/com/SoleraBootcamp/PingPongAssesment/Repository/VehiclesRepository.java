package com.SoleraBootcamp.PingPongAssesment.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.SoleraBootcamp.PingPongAssesment.Model.Vehicles;

@Repository
public interface VehiclesRepository extends CrudRepository<Vehicles, Long> {

}