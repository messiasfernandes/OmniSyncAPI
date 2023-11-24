package com.omnisyncapi.erpapi.domain.entity;

import com.omnisyncapi.erpapi.util.Normalizacao;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Grupo extends GeradorId{
	
	private static final long serialVersionUID = 1L;
	@Setter(value = AccessLevel.NONE)
	@NotBlank
	@Column(length = 45 , nullable = false)
	private String nomeGrupo;
	public void setNomeGrupo(String nomeGrupo) {
		this.nomeGrupo = Normalizacao.normalizarNome(nomeGrupo);
	}
	
  
}
