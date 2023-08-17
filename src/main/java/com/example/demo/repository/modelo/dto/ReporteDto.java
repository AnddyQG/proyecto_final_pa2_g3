package com.example.demo.repository.modelo.dto;


public class ReporteDto {
	
	private String numero;
	private String estado;
	private String inicio;
	private String fin;
	private String subtotal;
	private String ice;
	private String total;
	public ReporteDto(String numero, String estado, String inicio, String fin, String subtotal, String ice,
			String total) {
		super();
		this.numero = numero;
		this.estado = estado;
		this.inicio = inicio;
		this.fin = fin;
		this.subtotal = subtotal;
		this.ice = ice;
		this.total = total;
	}
	
	public ReporteDto() {
		
	}

	@Override
	public String toString() {
		return "ReporteDto [numero=" + numero + ", estado=" + estado + ", inicio=" + inicio + ", fin=" + fin
				+ ", subtotal=" + subtotal + ", ice=" + ice + ", total=" + total + "]";
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getInicio() {
		return inicio;
	}

	public void setInicio(String inicio) {
		this.inicio = inicio;
	}

	public String getFin() {
		return fin;
	}

	public void setFin(String fin) {
		this.fin = fin;
	}

	public String getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(String subtotal) {
		this.subtotal = subtotal;
	}

	public String getIce() {
		return ice;
	}

	public void setIce(String ice) {
		this.ice = ice;
	}

	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}
	
	
	

}
