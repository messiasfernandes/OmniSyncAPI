package com.omnisyncapi.erpapi;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.omnisyncapi.erpapi.domain.entity.Grupo;

@SpringBootTest
class DemoApplicationTests {

	@Test
	void contextLoads() {
		
		var grupo = new Grupo();
		grupo.setNomeGrupo("fdsjflsdajflj");
		System.out.println(grupo.getNomeGrupo());
	}
	private String normalizarNome(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            return nome;  // ou lançar uma exceção, dependendo dos requisitos
        }

        String[] palavras = nome.trim().split("\\s+");
        StringBuilder nomeNormalizado = new StringBuilder();

        for (String palavra : palavras) {
            if (!palavra.isEmpty()) {
                if (nomeNormalizado.length() > 0) {
                    nomeNormalizado.append(" ");
                }
                nomeNormalizado.append(palavra.substring(0, 1).toUpperCase())
                               .append(palavra.substring(1).toLowerCase());
            }
        }

        return nomeNormalizado.toString();
    }

}
