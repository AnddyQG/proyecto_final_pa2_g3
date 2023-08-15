package com.example.demo.repository.modelo;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "pago")

public class Pago {

	@Id
	@SequenceGenerator(name = "seq_pago", sequenceName = "seq_pago", allocationSize = 1)
	@GeneratedValue(generator = "seq_pago", strategy = GenerationType.SEQUENCE)
	@Column(name = "pago_id")

	private Integer id;
	@Column(name = "pago_fecha")
	private LocalDate fecha;

	@Column(name = "pago_num_tarjeta")
	private String numTarjeta;

	@OneToOne()
	@JoinColumn(name = "pago_id_reserva")
	private Reserva reserva;

	@Override
	public String toString() {
		return "Pago [id=" + id + ", fecha=" + fecha + ", numTarjeta=" + numTarjeta + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public Reserva getReserva() {
		return reserva;
	}

	public void setReserva(Reserva reserva) {
		this.reserva = reserva;
	}

	public String getNumTarjeta() {
		return numTarjeta;
	}

	public void setNumTarjeta(String numTarjeta) {
		this.numTarjeta = numTarjeta;
	}

}
