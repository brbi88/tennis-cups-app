package ftn.informatika.org.test_app.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ftn.informatika.org.test_app.model.Takmicenje;

@Repository
public interface TakmicenjeRepository extends JpaRepository<Takmicenje, Long>{
	
	Takmicenje findOneById(Long id);
	
	@Query("SELECT t FROM Takmicenje t WHERE"
			+ "(:formatId IS NULL OR t.format.id = :formatId) AND "
			+ "(:mestoOdrz IS NULL OR t.mestoOdrz LIKE %:mestoOdrz%)")
	Page<Takmicenje> search(@Param("formatId") Long formatId, @Param("mestoOdrz") String mestoOdrz, Pageable pageble);
	

}
