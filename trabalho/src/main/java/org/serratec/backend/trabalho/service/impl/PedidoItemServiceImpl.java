package org.serratec.backend.trabalho.service.impl;

import java.util.List;
import java.util.Optional;

import org.serratec.backend.trabalho.domain.PedidoItem;
import org.serratec.backend.trabalho.repository.PedidoItemRepository;
import org.serratec.backend.trabalho.service.PedidoItemService;
import org.springframework.beans.factory.annotation.Autowired;

public class PedidoItemServiceImpl implements PedidoItemService {
	
	 @Autowired
	    private PedidoItemRepository pedidoItemRepository;

	    @Override
	    public List<PedidoItem> pesquisarTodos() {
	        return pedidoItemRepository.findAll();
	    }

	    @Override
	    public Optional<PedidoItem> pesquisarUm(Long idPedidoItem) {
	        return pedidoItemRepository.findById(idPedidoItem);
	    }

	    @Override
	    public PedidoItem inserir(PedidoItem produto) {
	        return pedidoItemRepository.save(produto);
	    }

	    @Override
	    public boolean idExiste(Long idPedidoItem) {
	        return pedidoItemRepository.existsById(idPedidoItem);
	    }

	    @Override
	    public void remover(Long idPedidoItem) {
	    	pedidoItemRepository.deleteById(idPedidoItem);
	    }


}
