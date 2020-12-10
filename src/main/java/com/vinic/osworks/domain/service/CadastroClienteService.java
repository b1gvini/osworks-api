package com.vinic.osworks.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vinic.osworks.domain.exception.NegocioException;
import com.vinic.osworks.domain.model.Cliente;
import com.vinic.osworks.domain.repository.ClienteRepository;

@Service
public class CadastroClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	public Cliente salvar(Cliente cliente){
		Cliente clienteExistente = clienteRepository.findByEmail(cliente.getEmail());
		if (clienteExistente != null && !clienteExistente.equals(cliente)) {
			throw new NegocioException("erro ao processar cadastro (email, mas n deveria mostrar isso aqui)");
		}
		
		
		return clienteRepository.save(cliente);
	}
	
	public void excluir(Long clienteId) {
		clienteRepository.deleteById(clienteId);
	}
}
