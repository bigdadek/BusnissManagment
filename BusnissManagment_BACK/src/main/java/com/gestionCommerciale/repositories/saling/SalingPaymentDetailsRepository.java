package com.gestionCommerciale.repositories.saling;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.gestionCommerciale.entities.saling.SalingPaymentDetails;

@CrossOrigin("*")
@Repository

public interface SalingPaymentDetailsRepository  extends JpaRepository<SalingPaymentDetails,Long>{

}
