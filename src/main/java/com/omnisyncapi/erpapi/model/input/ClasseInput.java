package com.omnisyncapi.erpapi.model.input;

import lombok.Data;

@Data

public class ClasseInput {
	private Long id;
	private String nomeClasse;

	private SubGrupoInput subGrupo ;

	@Override
	public String toString() {
		return "ClasseInput [id=" + id + ", nomeClasse=" + nomeClasse + ", subGrupo=" + subGrupo + "]";
	}

}
