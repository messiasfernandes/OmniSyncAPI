package com.omnisyncapi.erpapi.model.input;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data

public class SubGrupoInput {
	private Long id;

	private String nomeSubgrupo;                                                                                                                                                                
	
    private GrupoInput grupo= new GrupoInput();

	@Override
	public String toString() {
		return "SubGrupoInput [id=" + id + ", nomeSubgrupo=" + nomeSubgrupo + ", grupo=" + grupo + "]";
	}
}
