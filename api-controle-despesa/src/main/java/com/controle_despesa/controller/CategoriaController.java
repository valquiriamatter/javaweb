package com.controle_despesa.controller;

import com.controle_despesa.model.dto.CategoriaDTO;
import com.controle_despesa.model.entity.Categoria;
import com.controle_despesa.model.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {

    @Autowired
    private CategoriaRepository repository;

//    @GetMapping //find
//    public List<Categoria> listarTudo(){
//        return repository.findAll();
//    }

    @GetMapping //find
    public List<CategoriaDTO> listarTudo(){
        List<Categoria> categoriaList = repository.findAll();
        return CategoriaDTO.converter(categoriaList);
    }

    @PostMapping //save   //vai no corpo
    public void salvar(@RequestBody Categoria categoria){
        repository.save(categoria);
    }

    @DeleteMapping("/{id}") //delete
    public void excluir(@PathVariable Long id){ //vai na URL
        repository.deleteById(id);
    }

//    @PutMapping("/{id}")
//    public void merge(@PathVariable Long id, @RequestBody Categoria categoria){
//        Categoria categoriaPesquisada = repository.getOne(id);
//        if(categoriaPesquisada != null){
//            categoriaPesquisada.setDataCadastro(categoria.getDataCadastro());
//            repository.save(categoriaPesquisada);
//        }
//
//    }


    @PutMapping("/{id}") //merge
    public Categoria alterar(@PathVariable Long id, @RequestBody Categoria categoria){

        //recebe do banco de dados
        Optional<Categoria> categoriaBuscada = repository.findById(id);

        if(!categoriaBuscada.isPresent()){
            return null;
        }

        //converte o Option
        Categoria categoriaNew = categoriaBuscada.get();
        categoriaNew.setDescricao(categoria.getDescricao());
        repository.save(categoriaNew);

        System.out.println(categoria);

        return categoria;

    }

    //@PatchMapping ?
}
