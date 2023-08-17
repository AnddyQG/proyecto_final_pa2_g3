package com.example.demo.repository;

import java.time.LocalDateTime;
import java.util.List;

import com.example.demo.repository.modelo.Reserva;

public interface IReservaRepository {

	public void insertar(Reserva reserva);
	
	//actualizar estado
	public void actualizar(Reserva reserva);
	public Reserva encontrar(Integer id);
	public void eliminar(Integer id);

	public List<Reserva> encontrarTodasReserva();
	//buscar la reserva normal
	public Reserva buscar(String numeroReserva);

	//Buscar La reserva por numerodeReserva
	public Reserva encontrarPorNumero(String numeroReserva);

	//Actualizar el estado de la reserva
	public Integer actEstado(String numeroReserva);
	
	//buscar por numero reserva List
	public List<Reserva> buscarList(String numeroReserva);
	//consulta de reservas por fechas
	public List<Reserva> encontrarRangoFecha(LocalDateTime inicio,LocalDateTime fin);
	
	//Consultar valores vip
	public List<Reserva> encontrarClientesVip();
	
	//buscar reserva por placa
	public List<Reserva> encontrarReportePlaca(String placa);
	
	
}
