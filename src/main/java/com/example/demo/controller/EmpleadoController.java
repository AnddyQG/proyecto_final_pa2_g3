package com.example.demo.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.repository.modelo.Cliente;
import com.example.demo.repository.modelo.Reserva;
import com.example.demo.repository.modelo.Vehiculo;
import com.example.demo.service.IClienteService;
import com.example.demo.service.IReservaService;
import com.example.demo.service.IVehiculoService;

@Controller
@RequestMapping("/empleados")
public class EmpleadoController {
	
	private static final Logger LOG = Logger.getLogger(EmpleadoController.class);
	
	@Autowired
	private IVehiculoService iVehiculoService;
	
	@Autowired
	private IClienteService clienteService;
	
	@Autowired
	private IReservaService iReservaService;
	
	// http://localhost:8080/renta/empleados/opciones
	@GetMapping("/opciones")
	public String vistaEmpleados() {
		
		LOG.info("opciones");
		
		return "vistaEmpleados";
	}
	
	//insertarCliente desde Empleado
	// http://localhost:8080/renta/empleados/registrarCliEmpleado
	@GetMapping("/registrarCliEmpleado")
	public String vistaRegistrarCliente(Cliente cliente) {
		
		LOG.info("registrarCliEmpleado");
		
		return "vistaEmpleadoRegistrarCliente";
	}

	@PostMapping("/insertar")
	public String insertarCliente(Cliente cliente) {
		
		LOG.info("insertar");
		
		cliente.setRegistro("E");
		this.clienteService.registrarC(cliente);
		return "EmplClieGuardado";
	}
	
	@GetMapping("/registrarVehiculo")
	public String nuevoVehiculo(Vehiculo vehiculo) {
	
		LOG.info("registrarVehiculo");
		
		return "nuevoVehiculoEmpleado";
	}
	
	@PostMapping("/insertarVehiculo")
	public String insertarVehiculo(Vehiculo vehiculo) {
		
		LOG.info("insertarVehiculo");
		
		this.iVehiculoService.ingresarV(vehiculo);
		return "vehiGuardar";
	}
	
	//buscar por cedula
	@GetMapping("/vistaBusqueda")
	public String paginaBuscarCliente(Model model,@Param("cedula")String cedula) {
		
		LOG.info("vistaBusqueda");
		
		List<Cliente>clientes=this.clienteService.encontrarPorCedulaList(cedula);
		model.addAttribute("cedula",cedula);
		model.addAttribute("clientes",clientes);
		
		return "vistaBuscrClienteIngresar";
	}
	
	//buscar por placa
	@GetMapping("vistaBusquedaPlaca")
	public String paginaBuscarPlaca(Model model,@Param("placa")String placa) {
		
		LOG.info("vistaBusquedaPlaca");
		
		List<Vehiculo>vehiculos =this.iVehiculoService.encontrarPlacaList(placa);
		model.addAttribute("placa",placa);
		model.addAttribute("vehiculos",vehiculos);
		
		return "vistaBuscarVehiculoPlaca";
	}
	
	//buscar Por reserva
	@GetMapping("/vistaBuscarReserva")
	public String paginaBuscarReserva(Model model,@Param("numero")String numero) {
		
		LOG.info("vistaBuscarReserva");
		
		List<Reserva> reservas=this.iReservaService.buscarList(numero);
		model.addAttribute("reservas",reservas);
		model.addAttribute("numero",numero);
		
		return "vistaBuscarReserva";
		
	}
	
	//retirar un vehiculo con reserva
	@PutMapping("/retirarReserva/{numero}")
	public String retirarReserva(@PathVariable("numero")String numero,Reserva reserva) {
		
		LOG.info("retirarReserva");
		
		this.iReservaService.retirarVehiculo(numero);
		
		return "vistaRetiroRealizado";
		
		
	}
	
	@GetMapping("/retirarVehiculo")
	public String retirarVehiculoReserva(Reserva r,Model model) {
		
		LOG.info("retirarVehiculo");
		
		Reserva reserva=this.iReservaService.buscarNumero(r.getNumero());
		
		if(reserva.getEstado().equals("G")) {
			
			LocalDateTime fechaIni=reserva.getInicio();
			LocalDateTime fechaFin=reserva.getFin();
			DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
			
			String fecha=fechaIni.format(dateTimeFormatter)+ " - " + fechaFin.format(dateTimeFormatter);
			model.addAttribute("reserva", reserva);
			model.addAttribute("fecha",fecha);
			
			return "vistaRetirarVehiculo";
			
			
			
		}else {
			//redireccionar a otra clase donde busco otra reserva para retirar
			return "redirect:/empleados/buscarNumeroReserva";
		}
		
	}

	//vista buscar vehiculo para retirar
	@GetMapping("/buscarNumeroReserva")
	public String buscarNumeroRese(Reserva reserva) {
		
		LOG.info("buscarNumeroReserva");
		
		return "vistaBuscarNumReserva";
	}
	
	@GetMapping("/vistaRetirarSinReserva")
	public String vistaRetirarSinReserva() {
		
		LOG.info("vistaRetirarSinReserva");
		
		return "vistaSinReserva";
	}
	
	
}
