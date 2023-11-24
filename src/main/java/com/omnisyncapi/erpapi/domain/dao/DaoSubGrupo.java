package com.omnisyncapi.erpapi.domain.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.omnisyncapi.erpapi.domain.entity.SubGrupo;

@Repository
public interface DaoSubGrupo extends JpaRepository<SubGrupo, Long>{

}
