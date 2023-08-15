package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.repository.modelo.Cliente;
import com.example.demo.repository.modelo.Reserva;
import com.example.demo.repository.modelo.Vehiculo;
import com.example.demo.service.IClienteService;
import com.example.demo.service.IReservaService;
import com.example.demo.service.IVehiculoService;

@Controller
@RequestMapping("/empleados")
public class EmpleadoController {

	@Autowired
	private IVehiculoService iVehiculoService;
	
	@Autowired
	private IClienteService clienteService;
	
	@Autowired
	private IReservaService iReservaService;
	
	
	@GetMapping("/opciones")
	public String vistaEmpleados() {
		
		return "vistaEmpleados";
		
	}
	
	//insertarCliente desde Empleado
	
	@GetMapping("/registrarCliEmpleado")
	public String vistaRegistrarCliente(Cliente cliente) {

		return "vistaEmpleadoRegistrarCliente";

	}

	@PostMapping("/insertar")
	public String insertarCliente(Cliente cliente) {

		cliente.setRegistro("E");
		this.clienteService.registrarC(cliente);

		return "EmplClieGuardado";
	}
	
	
	
	
	
	@GetMapping("/registrarVehiculo")
	public String nuevoVehiculo(Vehiculo vehiculo) {
		return "nuevoVehiculoEmpleado";
	}
	
	@PostMapping("/insertarVehiculo")
	public String insertarVehiculo(Vehiculo vehiculo) {
		this.iVehiculoService.ingresarV(vehiculo);
		
		return "vehiGuardar";
	}
	
	//buscar por cedula
	@GetMapping("/vistaBusqueda")
	public String paginaBuscarCliente(Model model,@Param("cedula")String cedula) {
		List<Cliente>clientes=this.clienteService.encontrarPorCedulaList(cedula);
		model.addAttribute("cedula",cedula);
		model.addAttribute("clientes",clientes);
		
		
		return "vistaBuscrClienteIngresar";
	}
	
	//buscar por placa
	@GetMapping("vistaBusquedaPlaca")
	public String paginaBuscarPlaca(Model model,@Param("placa")String placa) {
		
		List<Vehiculo>vehiculos =this.iVehiculoService.encontrarPlacaList(placa);
		model.addAttribute("placa",placa);
		model.addAttribute("vehiculos",vehiculos);
		
		return "vistaBuscarVehiculoPlaca";
	}
	
	//buscar Por reserva
	@GetMapping("/vistaBuscarReserva")
	public String paginaBuscarReserva(Model model,@Param("numero")String numero) {
		
		List<Reserva> reservas=this.iReservaService.buscarList(numero);
		model.addAttribute("reservas",reservas);
		model.addAttribute("numero",numero);
		
		return "vistaBuscarReserva";
		
	}
	

	
	
}
