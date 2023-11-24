package com.omnisyncapi.erpapi.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import com.omnisyncapi.erpapi.domain.entity.Classe;
import com.omnisyncapi.erpapi.model.dto.ClasseDTO;
import com.omnisyncapi.erpapi.model.input.ClasseInput;

@Component
public class ClasseConverter {
	@Autowired
	private ModelMapper modelMapper;

	public ClasseDTO toDto(Classe objeto) {

		return modelMapper.map(objeto, ClasseDTO.class);
	}

	public Classe toEntity(ClasseInput objeto) {

		return modelMapper.map(objeto, Classe.class);
	}

	public List<ClasseDTO> toCollectionDto(List<Classe> subcategorias) {
		return subcategorias.stream().map(this::toDto).collect(Collectors.toList());
	}

	public Page<ClasseDTO> topage(Page<Classe> objetos) {

		return objetos.map(obj -> toDto(obj));
	}

}