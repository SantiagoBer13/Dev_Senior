package com.sbt.exercies.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sbt.exercies.models.Client;

public interface ClientRepository extends JpaRepository<Client,Long>{

}
