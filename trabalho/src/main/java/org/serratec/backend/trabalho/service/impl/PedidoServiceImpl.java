package org.serratec.backend.trabalho.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.serratec.backend.trabalho.domain.Cliente;
import org.serratec.backend.trabalho.domain.Pedido;
import org.serratec.backend.trabalho.dto.ClienteDTO;
import org.serratec.backend.trabalho.dto.PedidoDTO;
import org.serratec.backend.trabalho.repository.PedidoRepository;
import org.serratec.backend.trabalho.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PedidoServiceImpl implements PedidoService {
	
	@Autowired
    private PedidoRepository pedidoRepository;

	@Override
    public List<PedidoDTO> pesquisarTodos() {
 		List<Pedido> pedidos = pedidoRepository.findAll();
 		List<PedidoDTO> pedidosDTO = new ArrayList<PedidoDTO>();
 		
 		for (Pedido pedido : pedidos) {
 			PedidoDTO pedidoDTO = new PedidoDTO(pedido); 
 			pedidosDTO.add(pedidoDTO);
 		}
        return pedidosDTO;
    }
 		
 
    @Override
    public Optional<Pedido> pesquisarUm(Long idPedido) {
        return pedidoRepository.findById(idPedido);
    }

    @Override
    public Pedido inserir(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }
    

    @Override
    public boolean idExiste(Long idPedido) {
        return pedidoRepository.existsById(idPedido);
    }

    @Override
    public void remover(Long idPedido) {
    	pedidoRepository.deleteById(idPedido);
    }

    
    @Override
    public PedidoDTO atualizar(Long id,Pedido pedido) {
        pedido.setIdPedido(id);
        pedidoRepository.save(pedido);
        PedidoDTO pDto = new PedidoDTO(pedido);
        return pDto;
    }


}
