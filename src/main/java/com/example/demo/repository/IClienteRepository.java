package com.example.demo.repository;

import java.util.List;

import com.example.demo.repository.modelo.Cliente;

public interface IClienteRepository {

	public void insertar(Cliente cliente);
	public void actualizar(Cliente cliente);
	public Cliente buscar(Integer id);
	public void eliminar(Integer id);

	//encontrar por cedula
	public Cliente encontrarPorCedula(String cedula);
	//encontrar por cedula List
	public List<Cliente> encontrarPorCedulaList(String cedula);
	//encontrar todos los clientes
	public List<Cliente> encontrarTodos();
}
