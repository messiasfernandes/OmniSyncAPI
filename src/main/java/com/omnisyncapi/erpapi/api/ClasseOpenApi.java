package com.omnisyncapi.erpapi.api;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;

import com.omnisyncapi.erpapi.domain.entity.Classe;
import com.omnisyncapi.erpapi.model.ClasseDTO;
import com.omnisyncapi.erpapi.model.input.ClasseInput;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletResponse;

@Tag(name = "Classes")
public interface ClasseOpenApi extends ContrrollerOrigin {

	@Operation(summary = "Listar Subcategoria")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Subcategoria  Encotrada", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = Classe.class)) }),
			@ApiResponse(responseCode = "400", description = "Requisão Invaldia", content = @Content),
			@ApiResponse(responseCode = "404", description = "Classe  não encontrada", content = @Content) })
	ResponseEntity<Page<ClasseDTO>> listar(String parametro, Integer pagina, Integer size, Pageable page);

	@Operation(summary = "Excluid um Subcategoria por ID")
	@ApiResponses(value = { @ApiResponse(responseCode = "204", description = "Subcategoria excluído"),
			@ApiResponse(responseCode = "404", description = "Subcategoria não encontrado") })

	ResponseEntity<Void> remover(@Param(value = "ID de uma Classe") Long id);

	ResponseEntity<ClasseDTO> buscar(@Param(value = "ID de um Subcategoria") Long id);

	@Operation(summary = "Atualizar um Classe ")
	@ApiResponses(value = { @ApiResponse(responseCode = "204", description = "Classe Atualizado com sucesso"),
			@ApiResponse(responseCode = "400", description = "problema com resquisão") })
	ResponseEntity<ClasseDTO> Atualizar(@Param(value = "id") Long id,
			@Param(value = "corpo") ClasseInput classeInput, HttpServletResponse response);

	@Operation(summary = "Salvar um Subcategoria ")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Classe salvo com sucesso"),
			@ApiResponse(responseCode = "400", description = "problema com resquisão") })
	public ResponseEntity<ClasseDTO> criar(@Param(value = "corpo") ClasseInput classeInput,
			HttpServletResponse response);

}
