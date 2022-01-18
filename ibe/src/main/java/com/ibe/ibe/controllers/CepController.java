package com.ibe.ibe.controllers;

import com.ibe.ibe.configurations.viaCep.ServicoCep;
import com.ibe.ibe.models.EnderecoViaCep;
import com.ibe.ibe.models.dtos.EnderecoViaCepDTO;
import com.ibe.ibe.services.EnderecoViaCepService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.Scanner;

@RestController
@RequestMapping("/cep")
public class CepController {

    @Autowired
    private EnderecoViaCepService service;

    @Autowired
    private ModelMapper mapper;

    @PostMapping
    public ResponseEntity<EnderecoViaCep> salvar(@RequestBody @Valid EnderecoViaCepDTO enderecoViaCepDTO, UriComponentsBuilder uriBuilder) throws Exception {

        //fazendo a conversao de dto para entidade
        EnderecoViaCep enderecoViaCep = ServicoCep.buscaEnderecoPelo(enderecoViaCepDTO.getCep());
        //EnderecoViaCep enderecoViaCep = mapper.map(enderecoViaCepDTO, EnderecoViaCep.class);

        EnderecoViaCep enderecoCriado = service.salvar(enderecoViaCep);

        URI uri = uriBuilder.path("/cep/{id}").buildAndExpand(enderecoCriado.getId()).toUri();

//        EnderecoViaCepDTO enderecoOK = mapper.map(enderecoCriado, EnderecoViaCepDTO.class);

        return ResponseEntity.created(uri).body(enderecoCriado);
    }


//    @GetMapping("/{id}")
//    public ResponseEntity<ClienteDTO> detalhar(@PathVariable Long id) {
//
//        Cliente cliente = service.buscarPorId(id);
//
//        if (cliente != null) {
//            return ResponseEntity.ok(new ClienteDTO(cliente));
//        }
//
//        return ResponseEntity.notFound().build();
//    }
//
//    @GetMapping
//    public List<ClienteDTO> listarTudo() {
//        return service.listarTudoDTO();
//    }
//
//    @GetMapping("pageable")                     //setando uma ordenacao default, se não passar parametros
//    public Page<ClienteDTO> listarTudoPaginacao(@PageableDefault(sort = "nome", direction = Sort.Direction.ASC, page = 0, size = 6) Pageable paginacao) {
//        return service.listarTudoDTOPaginacao(paginacao);
//    }
//
//*/

}
