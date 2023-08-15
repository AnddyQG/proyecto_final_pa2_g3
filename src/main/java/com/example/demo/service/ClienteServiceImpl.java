package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.IClienteRepository;
import com.example.demo.repository.modelo.Cliente;

@Service
public class ClienteServiceImpl implements IClienteService{

	
	@Autowired
	private IClienteRepository clienteRepo;

	@Override
	public void registrarC( Cliente cliente) {
		// TODO Auto-generated method stub
		
		this.clienteRepo.insertar(cliente);
	}

	@Override
	public void actualizarC(Cliente cliente) {
		// TODO Auto-generated method stub
		this.clienteRepo.actualizar(cliente);
	}

	@Override
	public Cliente encontrarC(Integer id) {
		// TODO Auto-generated method stub
		return this.clienteRepo.buscar(id);
	}

	@Override
	public void borrarC(Integer id) {
		// TODO Auto-generated method stub
		this.clienteRepo.eliminar(id);
	}

	@Override
	public Cliente encontrarPorCedula(String cedula) {
		// TODO Auto-generated method stub
		return this.clienteRepo.encontrarPorCedula(cedula);
	}

	@Override
	public List<Cliente> encontrarPorCedulaList(String cedula) {
		// TODO Auto-generated method stub
		return this.clienteRepo.encontrarPorCedulaList(cedula);
	}

	@Override
	public List<Cliente> buscarTodos() {
		// TODO Auto-generated method stub
		return this.clienteRepo.encontrarTodos();
	}
	
}
