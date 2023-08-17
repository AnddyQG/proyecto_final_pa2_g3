package com.example.demo.repository.modelo;

import java.math.BigDecimal;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "vehiculo")

public class Vehiculo {

	@Id
	@SequenceGenerator(name = "seq_vehi", sequenceName = "seq_vehi", allocationSize = 1)
	@GeneratedValue(generator = "seq_vehi", strategy = GenerationType.SEQUENCE)
	@Column(name = "vehi_id")

	private Integer id;
	@Column(name = "vehi_placa")
	private String placa;
	@Column(name = "vehi_modelo")
	private String modelo;
	@Column(name = "vehi_marca")
	private String marca;
	@Column(name = "vehi_anioF")
	private String anioF;
	@Column(name = "vehi_paisF")
	private String paisF;
	@Column(name = "vehi_estado")
	private String estado;
	@Column(name = "vehi_cilindraje")
	private String cilindraje;
	@Column(name = "vehi_evaluo")
	private BigDecimal evaluo;
	@Column(name = "vehi_valorPorDia")
	private BigDecimal valorPorDia;

	// relaciones
	@OneToMany(mappedBy = "vehiculo", fetch = FetchType.EAGER)
	private List<Reserva> reserva;

	@Override
	public String toString() {
		return " Placa=" + placa + ", Modelo=" + modelo + ", Marca=" + marca + ", anioF=" + anioF + ", Estado = "
				+ estado + ", valorPorDia=" + valorPorDia + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public String getCilindraje() {
		return cilindraje;
	}

	public void setCilindraje(String cilindraje) {
		this.cilindraje = cilindraje;
	}

	public BigDecimal getEvaluo() {
		return evaluo;
	}

	public void setEvaluo(BigDecimal evaluo) {
		this.evaluo = evaluo;
	}

	public BigDecimal getValorPorDia() {
		return valorPorDia;
	}

	public void setValorPorDia(BigDecimal valorPorDia) {
		this.valorPorDia = valorPorDia;
	}

	public List<Reserva> getReserva() {
		return reserva;
	}

	public void setReserva(List<Reserva> reserva) {
		this.reserva = reserva;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

}
