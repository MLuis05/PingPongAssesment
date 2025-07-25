package com.SoleraBootcamp.PingPongAssesment.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.SoleraBootcamp.PingPongAssesment.Model.Parts;

@Repository
public interface PartsRepository extends JpaRepository<Parts, Long> {

}