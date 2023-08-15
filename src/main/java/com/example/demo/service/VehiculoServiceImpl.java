package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.IVehiculoRepository;
import com.example.demo.repository.modelo.Vehiculo;

@Service
public class VehiculoServiceImpl implements IVehiculoService{


	@Autowired
	private IVehiculoRepository iVehiculoRepo;

	@Override
	public void ingresarV(Vehiculo vehiculo) {
		// TODO Auto-generated method stub
		this.iVehiculoRepo.insertar(vehiculo);
	}

	@Override
	public void actualizarV(Vehiculo vehiculo) {
		// TODO Auto-generated method stub
		this.iVehiculoRepo.actualizar(vehiculo);
	}

	@Override
	public Vehiculo buscarV(Integer id) {
		// TODO Auto-generated method stub
		return this.iVehiculoRepo.encontrar(id);
	}

	@Override
	public void borrarV(Integer id) {
		// TODO Auto-generated method stub
		this.iVehiculoRepo.eliminar(id);
	}

	@Override
	public List<Vehiculo> buscarVehiDisponibles() {
		// TODO Auto-generated method stub
		return this.iVehiculoRepo.encontrarVehiDisponibles();
	}

	@Override
	public List<Vehiculo> buscarTodosVehi() {
		// TODO Auto-generated method stub
		return this.iVehiculoRepo.encontrarTodosVehi();
	}

	@Override
	public List<Vehiculo> buscarMarcaModelo(String marca, String modelo) {
		// TODO Auto-generated method stub
		return this.iVehiculoRepo.encontrarMarcaModelo(marca, modelo)
				;
	}

	@Override
	public Vehiculo encontrarPlaca(String placa) {
		// TODO Auto-generated method stub
		return this.iVehiculoRepo.encontrarPlaca(placa);
	}

	@Override
	public List<Vehiculo> encontrarPlacaList(String placa) {
		// TODO Auto-generated method stub
		return this.iVehiculoRepo.encontrarPlacaList(placa);
	}
	
	
}
