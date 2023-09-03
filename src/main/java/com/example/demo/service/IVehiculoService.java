package com.example.demo.service;

import java.util.List;

import com.example.demo.repository.modelo.Vehiculo;

public interface IVehiculoService {

	public void ingresarV(Vehiculo vehiculo);

	public void actualizarV(Vehiculo vehiculo);

	public Vehiculo buscarV(Integer id);

	public void borrarV(Integer id);

	public List<Vehiculo> buscarTodosVehi();

	public List<Vehiculo> buscarVehiDisponibles();

	public List<Vehiculo> buscarMarcaModelo(String marca, String modelo);

	public Vehiculo encontrarPlaca(String placa);

	// encontrar por placa lista
	public List<Vehiculo> encontrarPlacaList(String placa);

	// encontrar por placa y modelo
	public List<Vehiculo> buscarMarcayModeloList(String placa, String modelo);

	// encontrar vehiculo vip
	public List<Vehiculo> buscarVehiculoVip(String fecha);

}
