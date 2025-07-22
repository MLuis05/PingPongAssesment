package com.SoleraBootcamp.PingPongAssesment.Repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;
import com.SoleraBootcamp.PingPongAssesment.Model.Workshops;

@Repository
public interface WorkshopsRepository extends CrudRepository<Workshops, Long> {

}
