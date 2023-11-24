package com.omnisyncapi.erpapi.model;

import lombok.Builder;
import lombok.Data;
@Builder
@Data
public class SubGrupoDTO {

	private String nomeClasse;

	private GrupoDto  grupo;

}
