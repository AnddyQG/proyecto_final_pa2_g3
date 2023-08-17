package com.example.demo.repository.modelo.dto;

public class VehiculoDto {

	
	private String placa;
	private String modelo;
	private String marca;
	private String anioF;
	private String paisF;
	private String estado;
	private String cilindraje;
	private String evaluo;
	private String valorPorDia;
	public VehiculoDto(String placa, String modelo, String marca, String anioF, String paisF, String estado,
			String cilindraje, String evaluo, String valorPorDia) {
		super();
		this.placa = placa;
		this.modelo = modelo;
		this.marca = marca;
		this.anioF = anioF;
		this.paisF = paisF;
		this.estado = estado;
		this.cilindraje = cilindraje;
		this.evaluo = evaluo;
		this.valorPorDia = valorPorDia;
	}
	
	public VehiculoDto() {
		
	}

	@Override
	public String toString() {
		return "VehiculoDto [placa=" + placa + ", modelo=" + modelo + ", marca=" + marca + ", anioF=" + anioF
				+ ", paisF=" + paisF + ", estado=" + estado + ", cilindraje=" + cilindraje + ", evaluo=" + evaluo
				+ ", valorPorDia=" + valorPorDia + "]";
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getAnioF() {
		return anioF;
	}

	public void setAnioF(String anioF) {
		this.anioF = anioF;
	}

	public String getPaisF() {
		return paisF;
	}

	public void setPaisF(String paisF) {
		this.paisF = paisF;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCilindraje() {
		return cilindraje;
	}

	public void setCilindraje(String cilindraje) {
		this.cilindraje = cilindraje;
	}

	public String getEvaluo() {
		return evaluo;
	}

	public void setEvaluo(String evaluo) {
		this.evaluo = evaluo;
	}

	public String getValorPorDia() {
		return valorPorDia;
	}

	public void setValorPorDia(String valorPorDia) {
		this.valorPorDia = valorPorDia;
	}
	
	
	
}
