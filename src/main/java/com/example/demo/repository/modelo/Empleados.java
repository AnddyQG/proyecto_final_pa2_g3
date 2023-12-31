package com.example.demo.repository.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "empleado")

public class Empleados {


	@Id



	@SequenceGenerator(name = "seq_empl", sequenceName = "seq_empl", allocationSize = 1)
	@GeneratedValue(generator = "seq_empl", strategy = GenerationType.SEQUENCE)
	@Column(name = "empl_id")
	private Integer id;
	@Column(name = "empl_nombre")

	private String nombre;
	@Column(name = "empl_cedula")
	private String cedula;
	@Override
	public String toString() {
		return "Empleados [id=" + id + ", nombre=" + nombre + ", cedula=" + cedula + "]";
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}




}
	

