package com.example.demo.repository;

import java.util.List;

import com.example.demo.repository.modelo.Vehiculo;

public interface IVehiculoRepository {

	public void insertar(Vehiculo vehiculo);

	public void actualizar(Vehiculo vehiculo);

	public Vehiculo encontrar(Integer id);

	public void eliminar(Integer id);

	// encontrar todos
	public List<Vehiculo> encontrarTodosVehi();

	// encontrar todos disponibles
	public List<Vehiculo> encontrarVehiDisponibles();

	// encontrar por marca y modelo
	public List<Vehiculo> encontrarMarcaModelo(String marca, String modelo);

	// encontrar por placa
	public Vehiculo encontrarPlaca(String placa);

	// encontrar por placa lista
	public List<Vehiculo> encontrarPlacaList(String placa);

	// encontrar por placa y modelo
	public List<Vehiculo> encontrarMarcayModeloList(String placa, String modelo);

	// actualizar el estadopor placa
	public Integer actEstado(String placa);

	// buscar vehiculo vip por año y mes
	public List<Vehiculo> encontrarVehiculoVip(String fecha);

}
