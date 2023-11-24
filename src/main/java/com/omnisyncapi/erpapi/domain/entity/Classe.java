package com.omnisyncapi.erpapi.domain.entity;

import com.omnisyncapi.erpapi.util.Normalizacao;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Classe extends GeradorId {

	
	private static final long serialVersionUID = 1L;
	
	@Setter(value = AccessLevel.NONE)

	 @NotEmpty(message = "O nome da classe não pode estar vazio")
	 
	@Column(length = 45 , nullable = false)
	private String nomeClasse;                                                                                                                                                                
	public void setNomeClasse(String nomeClasse) {
		
		if (nomeClasse != null) {
			this.nomeClasse = Normalizacao.normalizarNome(nomeClasse);
		}
			else {
			this.nomeClasse = nomeClasse;
		}
		
	}
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn
	private SubGrupo subGrupo;   
}
