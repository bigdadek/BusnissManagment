package com.gestionCommerciale.repositories.saling;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.gestionCommerciale.entities.saling.SalingPayment;

@CrossOrigin("*")
@Repository

public interface SalingPaymentRepository extends JpaRepository<SalingPayment,Long>{

}
