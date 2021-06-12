package ftn.informatika.org.test_app.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ftn.informatika.org.test_app.model.Prijava;

@Repository
public interface PrijavaRepository extends JpaRepository<Prijava, Long>{
	

}
