package com.omnisyncapi.erpapi.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.omnisyncapi.erpapi.domain.dao.DaoClasse;
import com.omnisyncapi.erpapi.domain.dao.DaoGrupo;
import com.omnisyncapi.erpapi.domain.dao.DaoSubGrupo;
import com.omnisyncapi.erpapi.domain.entity.Classe;

import jakarta.transaction.Transactional;

@Service
public class ServiceClasse implements ServiceModel<Classe> {
	@Autowired
	private DaoClasse daoClasse;
	@Autowired
	private DaoGrupo daoGrupo;
	@Autowired
	private DaoSubGrupo daoSubGrupo;
	@Override
	public Page<Classe> buscar(String nome, Pageable pageable) {
		
		return daoClasse.findAll(pageable);
	}

	@Override
	public void excluir(Long codigo) {
		// TODO Auto-generated method stub

	}

	@Override
	public Classe buccarporid(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Transactional
	@Override
	public Classe salvar(Classe objeto) {
		 if (objeto.getSubGrupo().getGrupo() != null && objeto.getSubGrupo().getGrupo().getId() == null) {
		        var grupo  = daoGrupo.save(objeto.getSubGrupo().getGrupo());
		        objeto.getSubGrupo().setGrupo(grupo);
		    }

		    if (objeto.getSubGrupo() != null && objeto.getSubGrupo() != null && objeto.getSubGrupo().getId() == null) {
		        var subGrupo = daoSubGrupo.save(objeto.getSubGrupo());
		        objeto.setSubGrupo(subGrupo);
		    }

		    return daoClasse.save(objeto);
		}
}
