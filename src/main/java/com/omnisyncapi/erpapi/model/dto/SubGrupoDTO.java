package com.omnisyncapi.erpapi.model.dto;

import lombok.Data;

@Data
public class SubGrupoDTO {
	private Long id;
	private String nomeSubgrupo;

	private GrupoDto  grupo = new GrupoDto();

}
