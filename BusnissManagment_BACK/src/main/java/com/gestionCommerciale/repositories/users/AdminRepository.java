package com.gestionCommerciale.repositories.users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.gestionCommerciale.entities.users.Admin;

@CrossOrigin("*")
@Repository

public interface AdminRepository extends JpaRepository<Admin,Long> {

}

