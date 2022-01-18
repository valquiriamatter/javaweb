package com.ibe.ibe.services;

import com.ibe.ibe.models.EnderecoViaCep;
import com.ibe.ibe.models.Pessoa;
import com.ibe.ibe.repositories.EnderecoViaCepRepository;
import com.ibe.ibe.repositories.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EnderecoViaCepService {

        @Autowired
        private EnderecoViaCepRepository enderecoViaCepRepository;

        public EnderecoViaCep salvar(EnderecoViaCep enderecoViaCep) {
            return enderecoViaCepRepository.save(enderecoViaCep);
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

