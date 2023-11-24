package com.omnisyncapi.erpapi.model.dto;

import lombok.Data;

@Data

public class ClasseDTO {

	private String nomeClasse;
    
	private SubGrupoDTO subGrupo =new SubGrupoDTO();

}
