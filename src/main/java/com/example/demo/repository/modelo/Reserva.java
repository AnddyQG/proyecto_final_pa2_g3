package com.example.demo.repository.modelo;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "reserva")

public class Reserva {

	
	@Id
	@SequenceGenerator(name = "seq_rese", sequenceName = "seq_rese", allocationSize = 1)
	@GeneratedValue(generator = "seq_rese", strategy = GenerationType.SEQUENCE)
	@Column(name = "rese_id")

	private Integer id;
	@Column(name = "rese_numero")
	private String numero;
	@Column(name = "rese_estado")
	private String estado;
	@Column(name = "rese_inicio")
	private LocalDateTime inicio;
	@Column(name = "rese_fin")
	private LocalDateTime fin;
	@Column(name = "rese_subtotal")
	private BigDecimal subtotal;
	@Column(name = "rese_ice")
	private BigDecimal ice;
	@Column(name = "rese_total")
	private BigDecimal total;


	//relacion
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "rese_id_cliente")
	private Cliente cliente;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "rese_id_vehiculo")
	private Vehiculo vehiculo;

	@OneToOne(mappedBy = "reserva",cascade = CascadeType.REMOVE,fetch = FetchType.EAGER)
	private Pago pago;


	@Override
	public String toString() {
		return "Reserva [id=" + id + ", numero=" + numero + ", estado=" + estado + ", inicio=" + inicio + ", fin=" + fin
				+ ", subtotal=" + subtotal + ", ice=" + ice + ", total=" + total + "]";
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
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


	public BigDecimal getSubtotal() {
		return subtotal;
	}


	public void setSubtotal(BigDecimal subtotal) {
		this.subtotal = subtotal;
	}




	public BigDecimal getIce() {
		return ice;
	}


	public void setIce(BigDecimal ice) {
		this.ice = ice;
	}


	public BigDecimal getTotal() {
		return total;
	}


	public void setTotal(BigDecimal total) {
		this.total = total;
	}


	public Cliente getCliente() {
		return cliente;
	}


	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}


	public Vehiculo getVehiculo() {
		return vehiculo;
	}


	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}


	public Pago getPago() {
		return pago;
	}


	public void setPago(Pago pago) {
		this.pago = pago;
	}
	
}
