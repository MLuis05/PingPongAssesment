package com.SoleraBootcamp.PingPongAssesment.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.SoleraBootcamp.PingPongAssesment.Model.Parts;

@Repository
public interface PartsRepository extends CrudRepository<Parts, Long> {

}