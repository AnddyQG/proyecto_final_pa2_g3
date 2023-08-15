package com.example.demo.repository.modelo.dto;

import java.time.LocalDateTime;

public class ReservaDto {

	private String placa;
	private String cedula;
	private LocalDateTime inicio;
	private LocalDateTime fin;
	private String numeroTarjeta;
	
	public ReservaDto() {
		
	}
	
	
	public ReservaDto(String placa, String cedula, LocalDateTime inicio, LocalDateTime fin, String numeroTarjeta) {
		super();
		this.placa = placa;
		this.cedula = cedula;
		this.inicio = inicio;
		this.fin = fin;
		this.numeroTarjeta = numeroTarjeta;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	public LocalDateTime getInicio() {
		return inicio;
	}
	public void setInicio(LocalDateTime inicio) {
		this.inicio = inicio;
	}
	public LocalDateTime getFin() {
		return fin;
	}
	public void setFin(LocalDateTime fin) {
		this.fin = fin;
	}
	public String getNumeroTarjeta() {
		return numeroTarjeta;
	}
	public void setNumeroTarjeta(String numeroTarjeta) {
		this.numeroTarjeta = numeroTarjeta;
	}
	
	

}
