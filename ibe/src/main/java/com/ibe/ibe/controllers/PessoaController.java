package com.ibe.ibe.controllers;

import com.ibe.ibe.models.Pessoa;
import com.ibe.ibe.models.dtos.PessoaDTO;
import com.ibe.ibe.services.PessoaService;
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

@RestController
@RequestMapping("/pessoas")
public class PessoaController {

    @Autowired
    private PessoaService service;

    @Autowired
    private ModelMapper mapper;

    @PostMapping
    public ResponseEntity<PessoaDTO> salvar(@RequestBody @Valid PessoaDTO pessoaRequestDTO, UriComponentsBuilder uriBuilder) {

        //fazendo a conversao de dto para entidade
        Pessoa pessoa = mapper.map(pessoaRequestDTO, Pessoa.class);

        Pessoa pessoaCriada = service.salvar(pessoa);

        //jeito Lilian

        //mapeando de DTO para Entidade
        //UserEntity userEntity = mapper.map(userDTO, UserEntity.class);
        //UserEntity userCreated = service.create(userEntity);

        //mapeando de Entidade para DTO         //entidade     //dto
        //UserDTO userDtoResponse = mapper.map(userCreated, UserDTO.class);

        //jeito antigo
        //Cliente cliente = clienteForm.converteFormClienteParaCliente(enderecoService);
        //service.salvar(cliente);
        //return ResponseEntity.created(uri).body(new VisitanteDTO(visitante));

        URI uri = uriBuilder.path("/pessoas/{id}").buildAndExpand(pessoa.getId()).toUri();

        PessoaDTO pessoaOK = mapper.map(pessoaCriada, PessoaDTO.class);

        return ResponseEntity.created(uri).body(pessoaOK);
    }

//    @PostMapping("/viacep")
//    public ResponseEntity<PessoaDTO> salvarViaCep(@RequestBody @Valid PessoaDTO pessoaRequestDTO, UriComponentsBuilder uriBuilder) {
//
//        //fazendo a conversao de dto para entidade
//        Pessoa pessoa = mapper.map(pessoaRequestDTO, Pessoa.class);
//
//        Pessoa pessoaCriada = service.salvar(pessoa);
//
//        //jeito Lilian
//
//        //mapeando de DTO para Entidade
//        //UserEntity userEntity = mapper.map(userDTO, UserEntity.class);
//        //UserEntity userCreated = service.create(userEntity);
//
//        //mapeando de Entidade para DTO         //entidade     //dto
//        //UserDTO userDtoResponse = mapper.map(userCreated, UserDTO.class);
//
//        //jeito antigo
//        //Cliente cliente = clienteForm.converteFormClienteParaCliente(enderecoService);
//        //service.salvar(cliente);
//        //return ResponseEntity.created(uri).body(new VisitanteDTO(visitante));
//
//        URI uri = uriBuilder.path("/pessoas/{id}").buildAndExpand(pessoa.getId()).toUri();
//
//        PessoaDTO pessoaOK = mapper.map(pessoaCriada, PessoaDTO.class);
//
//        return ResponseEntity.created(uri).body(pessoaOK);
//    }


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
