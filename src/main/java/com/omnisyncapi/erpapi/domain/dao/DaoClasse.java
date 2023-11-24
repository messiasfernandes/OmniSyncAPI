package com.omnisyncapi.erpapi.domain.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.omnisyncapi.erpapi.domain.entity.Classe;

public interface DaoClasse extends JpaRepository<Classe, Long> {
	 
	
	@Query("SELECT DISTINCT c FROM Classe c LEFT JOIN FETCH c.subGrupo s LEFT JOIN FETCH s.grupo " +
		       "WHERE (c.nomeClasse) like %:parametro% " +
		       "OR (s.nomeSubgrupo) like %:parametro%  ORDER BY c.nomeClasse")
		Page<Classe> search(
		    @Param("parametro") String parametro,
		    Pageable pageable);
	
	@Query("from Classe c where c.nomeClasse = :nome")
	Classe  buscar(String nome);
}
