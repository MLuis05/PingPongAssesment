package com.SoleraBootcamp.PingPongAssesment.Repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.SoleraBootcamp.PingPongAssesment.Model.Workshops;

@Repository
public interface WorkshopsRepository extends JpaRepository<Workshops, Long> {

}
