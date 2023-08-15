package com.example.demo.service;

import java.util.List;

import com.example.demo.repository.modelo.Cliente;

public interface IClienteService {

	
	public void registrarC(Cliente cliente);
	public void actualizarC(Cliente cliente);
	public Cliente encontrarC(Integer id);
	public void borrarC(Integer id);

	public Cliente encontrarPorCedula(String cedula);
	
	public List<Cliente> encontrarPorCedulaList(String cedula);
	
	//encontrar todos los clientes
	public List<Cliente> buscarTodos();
}
