package com.example.demo.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import com.example.demo.repository.modelo.Reserva;
import com.example.demo.repository.modelo.Vehiculo;
import com.example.demo.repository.modelo.dto.ReporteVehiculoDto;

public interface IReservaService {


	public void reservar(String placa,String cedula, LocalDateTime inicio, LocalDateTime fin,String numeroTarjeta);
	public void actualizarR(Reserva reserva);
	public Reserva buscarR(Integer id);
	public void borrarR(Integer id);


	public List<Reserva> buscarTodasReserva();

	//validar si hay en estas fechas reservas
	public Boolean validacionReserva(LocalDateTime inicio,LocalDateTime fin, List<Reserva>reservas);


	public Reserva encontrarPorNumero(String numeroReserva);
	
	public String reservarRetorno(String placa,String cedula, LocalDateTime inicio, LocalDateTime fin,String numeroTarjeta);
	
	public List<Reserva> buscarList(String numeroReserva);
	
	//retirar vehiculo
	public void retirarVehiculo(String numero);
	
	public Reserva buscarNumero(String numeroReserva);
	
	
	public List<Reserva> buscarRangoFecha(LocalDateTime inicio,LocalDateTime fin);
	
	public List<Reserva> buscarClientesVip();
	
	
	//buscar reporte de vehiculo
	
	public List<ReporteVehiculoDto> ReporteEncontrarVehi(List<Vehiculo> vehiculos);

	public List<Reserva> buscarReportePlaca(String placa);
	
	
}
