package com.controle_despesa.model.dto;

import com.controle_despesa.model.entity.Categoria;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class CategoriaDTO {  //NÃO USAR ATRIBUTOS DE TIPO COMPLEXO

    private String descricao;

    public CategoriaDTO(Categoria categoria) {
        this.descricao = descricao;
    }

    //metodo que converte a entidade para DTO
    public static List<CategoriaDTO> converter(List<Categoria> categorias){
        return categorias.stream().map(CategoriaDTO::new).collect(Collectors.toList());
    }


    public Categoria toColaborador() {

        Categoria categoria = new Categoria();
        categoria.setDescricao(descricao);

        return categoria;
    }

}
