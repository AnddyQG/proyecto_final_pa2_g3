package com.example.demo.service;

import com.example.demo.repository.modelo.Reserva;

public interface IPagoService {
	public void realizarPago(String numTarjeta,Reserva reserva);
	
}
