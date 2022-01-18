package com.ibe.ibe.services;

import com.ibe.ibe.models.Pessoa;
import com.ibe.ibe.models.Visitante;
import com.ibe.ibe.repositories.PessoaRepository;
import com.ibe.ibe.repositories.VisitanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PessoaService {

        @Autowired
        private PessoaRepository pessoaRepository;

        public Pessoa salvar(Pessoa pessoa) {
            return pessoaRepository.save(pessoa);
        }

//        public Visitante buscarPorId(Integer id) {
//            Optional<Visitante> clienteOptional = visitanteRepository.findById(id);
//            if (clienteOptional.isPresent()) {
//                return clienteOptional.get();
//            }
//
//            return null;
//        }

//
//        public List<ClienteDTO> listarTudoDTO() {
//            List<Cliente> listaClientes = visitanteRepository.findAll();
//            return ClienteDTO.converter(listaClientes);
//        }
//
//        public Page<ClienteDTO> listarTudoDTOPaginacao(Pageable paginacao) {
//            Page<Cliente> listaClientes = visitanteRepository.findAll(paginacao);
//            return ClienteDTO.converterPaginacao(listaClientes);
//        }

    }

