package com.ibe.ibe.services;

import com.ibe.ibe.models.Visitante;
import com.ibe.ibe.repositories.VisitanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VisitanteService {

        @Autowired
        private VisitanteRepository visitanteRepository;

        public Visitante salvar(Visitante visitante) {
            return visitanteRepository.save(visitante);
        }

        public Visitante buscarPorId(Integer id) {
            Optional<Visitante> clienteOptional = visitanteRepository.findById(id);
            if (clienteOptional.isPresent()) {
                return clienteOptional.get();
            }

            return null;
        }

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

