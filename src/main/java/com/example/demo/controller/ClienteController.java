package com.example.demo.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.repository.modelo.Cliente;
import com.example.demo.repository.modelo.Vehiculo;
import com.example.demo.repository.modelo.dto.ReservaDto;
import com.example.demo.service.IClienteService;
import com.example.demo.service.IReservaService;
import com.example.demo.service.IVehiculoService;

@Controller
@RequestMapping("/clientes")

public class ClienteController {

	private static final Logger LOG = LoggerFactory.getLogger(ClienteController.class);

	@Autowired
	private IClienteService clienteService;

	@Autowired
	private IVehiculoService iVehiculoService;

	@Autowired
	private IReservaService iReservaService;

	LocalDateTime fInicio = null;
	LocalDateTime fFin = null;
	String ced = null;
	String tarj = null;

	@GetMapping("/opciones")
	public String vistaCliente() {

		return "vistaCliente";
	}

	@GetMapping("/registrarCli")
	public String vistaRegistrarCliente(Cliente cliente) {

		return "vistaRegistrarCliente";

	}

	@PostMapping("/insertar")
	public String insertarCliente(Cliente cliente) {

		cliente.setRegistro("C");
		this.clienteService.registrarC(cliente);

		return "ClieGuardado";
	}

	@GetMapping("/vehiculosDisponibles")
	public String vistaVehiculosDisponibles(Model model, Vehiculo vehiculo) {

		List<Vehiculo> listaVehiculos = this.iVehiculoService.buscarTodosVehi();
		model.addAttribute("vehiculos", listaVehiculos);
		return "vistaListaDisponibles";

	}

	@GetMapping("/registrarReserva")
	public String vistaInsertarReserva(Model model) {

		model.addAttribute("reserva", new ReservaDto());

		return "vistaRegistrarReserva";
	}
//sin logi ca
	/*
	@PostMapping("/reservar")
	public String insertarReserva(@ModelAttribute ReservaDto dto) {

	this.iReservaService.reservar(dto.getPlaca(), dto.getCedula(), dto.getInicio(), dto.getFin(),
				dto.getNumeroTarjeta());

		return "redirect:/clientes/registrarReserva";
	}
*/
	
	@PostMapping("/reservar")
	public String insertarReserva(@ModelAttribute ReservaDto dto, RedirectAttributes attributes) {

	String mensaje =this.iReservaService.reservarRetorno(dto.getPlaca(), dto.getCedula(), dto.getInicio(), dto.getFin(),
			dto.getNumeroTarjeta());

		
		if (mensaje.equals("Reserva Exitosa")) {
			//CREAR EN ESTE REDIRECT QUE NOS MANDE A UNA PAGINA NUEVA QUE DIGA RESERVA EXITOSA
			return "redirect:/clientes/reservaExitosa"; // Redirige a la lista de reservas
        } else {
            attributes.addFlashAttribute("mensajeError", mensaje);
            return "redirect:/clientes/registrarReserva";// Redirige de vuelta al formulario
        }
		
	}
	
	@GetMapping("/reservaExitosa")
	public String vistaReservaExitosa() {
		
		return "vistaReservaExitosa";
	}
}
