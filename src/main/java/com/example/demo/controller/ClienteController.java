package com.example.demo.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
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

	private static final Logger LOG = Logger.getLogger(ClienteController.class);

	@Autowired
	private IClienteService clienteService;

	@Autowired
	private IVehiculoService vehiculoService;

	@Autowired
	private IReservaService reservaService;

	// http://localhost:8080/renta/clientes/opciones
	@GetMapping("/opciones")
	public String vistaCliente() {
		
		LOG.info("opciones");
		
		return "vistaCliente";
	}

	// http://localhost:8080/renta/clientes/registrarCli
	@GetMapping("/registrarCli")
	public String vistaRegistrarCliente(Cliente cliente) {
		
		LOG.info("registrarCli");
		
		return "vistaRegistrarCliente";
	}

	// http://localhost:8080/renta/clientes/insertar
	@PostMapping("/insertar")
	public String insertarCliente(Cliente cliente) {
		
		LOG.info("insertar");

		cliente.setRegistro("C");
		this.clienteService.registrarC(cliente);

		return "ClieGuardado";
	}

	// http://localhost:8080/renta/clientes/vehiculosDisponibles
	// @GetMapping("/vehiculosDisponibles")
	// public String vistaVehiculosDisponibles(Model model, Vehiculo vehiculo) {

	// List<Vehiculo> listaVehiculos = this.vehiculoService.buscarVehiDisponibles();
	// model.addAttribute("vehiculos", listaVehiculos);
	// return "vistaListaDisponibles";

	// }

	// buscar por placa y modelo
	@GetMapping("/busquedaMarcayModelo")
	public String vistaBuscarMarcayModelo(Model model, @Param("marca") String marca, @Param("modelo") String modelo) {

		LOG.info("busquedaMarcayModelo");
		
		List<Vehiculo> vehiculos = this.vehiculoService.buscarMarcayModeloList(marca, modelo);
		model.addAttribute("marca", marca);
		model.addAttribute("modelo", modelo);
		model.addAttribute("vehiculos", vehiculos);

		return "vistaBuscarVehiculoMarcayModelo";
	}

	// http://localhost:8080/renta/clientes/registrarReserva
	@GetMapping("/registrarReserva")
	public String vistaInsertarReserva(Model model) {
		
		LOG.info("registrarReserva");
		
		model.addAttribute("reserva", new ReservaDto());
		return "vistaRegistrarReserva";
	}

	// http://localhost:8080/renta/clientes/reservar
	@PostMapping("/reservar")
	public String insertarReserva(@ModelAttribute ReservaDto dto, RedirectAttributes attributes) {

		LOG.info("reservar");
		
		String mensaje = this.reservaService.reservarRetorno(dto.getPlaca(), dto.getCedula(), dto.getInicio(),
				dto.getFin(),
				dto.getNumeroTarjeta());

		if (mensaje.equals("Reserva Exitosa")) {
			// CREAR EN ESTE REDIRECT QUE NOS MANDE A UNA PAGINA NUEVA QUE DIGA RESERVA
			// EXITOSA
			return "redirect:/clientes/reservaExitosa"; // Redirige a la lista de reservas
		} else {
			attributes.addFlashAttribute("mensajeError", mensaje);
			return "redirect:/clientes/registrarReserva";// Redirige de vuelta al formulario
		}

	}

	// http://localhost:8080/renta/clientes/reservaExitosa
	@GetMapping("/reservaExitosa")
	public String vistaReservaExitosa() {
		
		LOG.info("reservaExitosa");
		
		return "vistaReservaExitosa";
	}
}
