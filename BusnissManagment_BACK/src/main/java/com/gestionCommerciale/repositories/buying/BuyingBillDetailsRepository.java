package com.gestionCommerciale.repositories.buying;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.gestionCommerciale.entities.buying.BuyingBillDetails;

@CrossOrigin("*")
@Repository

public interface BuyingBillDetailsRepository extends JpaRepository<BuyingBillDetails,Long>{

}
