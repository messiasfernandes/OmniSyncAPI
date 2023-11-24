package com.omnisyncapi.erpapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.omnisyncapi.erpapi.api.ClasseOpenApi;
import com.omnisyncapi.erpapi.converter.ClasseConverter;
import com.omnisyncapi.erpapi.domain.service.ServiceClasse;
import com.omnisyncapi.erpapi.model.ClasseDTO;
import com.omnisyncapi.erpapi.model.input.ClasseInput;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
@RestController
@RequestMapping("/classes")
public class ClasseController implements ClasseOpenApi{
	@Autowired
   private ClasseConverter classeConverter;
	@Autowired
	private ServiceClasse serviceClasse;
	@Override
	public ResponseEntity<Page<ClasseDTO>> listar(String parametro, Integer pagina, Integer size, Pageable page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<Void> remover(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<ClasseDTO> buscar(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
   @PutMapping
	@Override
	public ResponseEntity<ClasseDTO> Atualizar(Long id, ClasseInput classeInput, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return null;
	}
   @PostMapping
	@Override
	public ResponseEntity<ClasseDTO> criar(@Valid @RequestBody ClasseInput classeInput, HttpServletResponse response) {
	   System.out.println( "minha call0"+ classeInput.getNomeClasse());
		var classeSalva= serviceClasse.salvar(classeConverter.toEntity(classeInput));
		return ResponseEntity.status(HttpStatus.CREATED).body(classeConverter.toDto(classeSalva));
	}

}
