package com.omnisyncapi.erpapi.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.omnisyncapi.erpapi.domain.dao.DaoClasse;
import com.omnisyncapi.erpapi.domain.dao.DaoGrupo;
import com.omnisyncapi.erpapi.domain.dao.DaoSubGrupo;
import com.omnisyncapi.erpapi.domain.entity.Classe;
import com.omnisyncapi.erpapi.domain.service.exeption.NegocioException;
import com.omnisyncapi.erpapi.util.Normalizacao;

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
       nome=Normalizacao.normalizarNome(nome);
		return daoClasse.search(nome, pageable);
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
		Classe classeExistente = daoClasse.buscar(objeto.getNomeClasse());
		if (classeExistente != null && !classeExistente.equals(objeto)) {
		    throw new NegocioException("Classe já cadastrada no banco de dados");
		}

		if (classeExistente == null) {
		    return daoClasse.save(objeto);
		} else {
		    return classeExistente;
		}

	}

	
}
