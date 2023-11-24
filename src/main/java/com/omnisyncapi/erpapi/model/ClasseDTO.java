package com.omnisyncapi.erpapi.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ClasseDTO {

	private String nomeClasse;
    
	private SubGrupoDTO subGrupo;

}
