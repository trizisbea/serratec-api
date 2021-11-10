package org.serratec.backend.trabalho.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.serratec.backend.trabalho.domain.Cliente;
import org.serratec.backend.trabalho.dto.ClienteDTO;
import org.serratec.backend.trabalho.repository.ClienteRepository;
import org.serratec.backend.trabalho.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteServiceImpl implements ClienteService {
	
	 @Autowired
	 private ClienteRepository clienteRepository;
	 
	 	@Override
	    public List<ClienteDTO> pesquisarTodos() {
	 		List<Cliente> clientes = clienteRepository.findAll();
	 		List<ClienteDTO> clientesDTO = new ArrayList<ClienteDTO>();
	 		
	 		for (Cliente cliente : clientes) {
	 			ClienteDTO clienteDTO = new ClienteDTO(cliente); 
	 			clientesDTO.add(clienteDTO);
	 		}
	        return clientesDTO;
	    }
	 	
	 	//método de setar o endereco a partir do cep
	 	
	 
	    @Override
	    public Optional<Cliente> pesquisarUm(Long idCliente) {
	        return clienteRepository.findById(idCliente);
	    }

	    @Override
	    public Cliente inserir(Cliente cliente) {
	        return clienteRepository.save(cliente);
	    }
	    

	    @Override
	    public boolean idExiste(Long idCliente) {
	        return clienteRepository.existsById(idCliente);
	    }

	    @Override
	    public void remover(Long idCliente) {
	    	clienteRepository.deleteById(idCliente);
	    }

	    
	    @Override
        public ClienteDTO atualizar(Long id,Cliente cliente) {
            cliente.setIdCliente(id);
            clienteRepository.save(cliente);
            ClienteDTO cDto = new ClienteDTO(cliente);
            return cDto;
	    }

		 	    
}
