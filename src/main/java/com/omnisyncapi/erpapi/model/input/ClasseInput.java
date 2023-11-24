package com.omnisyncapi.erpapi.model.input;

import lombok.Data;

@Data
public class ClasseInput {
	private Long id;
	private String nomeClasse;

	private SubGrupoInput subGrupo ;

}
