package com.ibe.ibe.controllers;

import com.ibe.ibe.models.Pessoa;
import com.ibe.ibe.models.Visitante;
import com.ibe.ibe.models.dtos.VisitanteRequest;
import com.ibe.ibe.services.VisitanteService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/visitantes")
public class VisitanteController {

    @Autowired
    private VisitanteService service;

    @Autowired
    private ModelMapper mapper;

    @PostMapping
    public ResponseEntity<VisitanteRequest> salvar(@RequestBody @Valid VisitanteRequest visitanteDTO, UriComponentsBuilder uriBuilder) {

        //fazendo a conversao de dto para entidade
        Pessoa pessoa = mapper.map(visitanteDTO, Pessoa.class);

        Visitante visitante = new Visitante();
        visitante.setPessoa(pessoa);

        Visitante visitanteCriado = service.salvar(visitante);
        //Visitante visitante = mapper.map(visitanteDTO, Visitante.class);


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

        URI uri = uriBuilder.path("/visitantes/{id}").buildAndExpand(visitante.getId()).toUri();

        VisitanteRequest visitanteDTOOK = mapper.map(visitanteCriado, VisitanteRequest.class);

        return ResponseEntity.created(uri).body(visitanteDTOOK);
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
