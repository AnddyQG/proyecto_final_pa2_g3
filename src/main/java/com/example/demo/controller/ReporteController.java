package com.example.demo.controller;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.repository.modelo.Reserva;
import com.example.demo.repository.modelo.Vehiculo;
import com.example.demo.repository.modelo.dto.ReporteDto;
import com.example.demo.repository.modelo.dto.ReporteVehiculoDto;
import com.example.demo.repository.modelo.dto.VehiculoDto;
import com.example.demo.service.IReservaService;
import com.example.demo.service.IVehiculoService;

@Controller
@RequestMapping("/reportes")

public class ReporteController {

	private static final Logger LOG = Logger.getLogger(ReporteController.class);

	@Autowired
	private IReservaService iReservaService;
	@Autowired
	private IVehiculoService iVehiculoService;

	@GetMapping("/opciones")
	public String vistaReporte() {
		
		LOG.info("opciones");
		
		return "vistaReporte";
	}

	@GetMapping("/buscar")
	public String buscarR(ReporteDto dto, VehiculoDto dto2) {
		
		LOG.info("buscar");
		
		return "vistaBuscarReporte";
	}

	@GetMapping("/consultarRangoFechas")
	public String buscarRangoFechas(ReporteDto dto, Model model) {
		
		LOG.info("consultarRangoFechas");
		
		List<Reserva> reservas = this.iReservaService.buscarRangoFecha(LocalDateTime.parse(dto.getInicio()),
				LocalDateTime.parse(dto.getFin()));
		model.addAttribute("reservas", reservas);
		return "vistaRangoFechasReserva";
	}

	// buscar Clientes vip
	@GetMapping("/buscarVip")
	public String buscarCliVip(Model model) {
		
		LOG.info("buscarVip");
		
		List<Reserva> reservas = this.iReservaService.buscarClientesVip();
		model.addAttribute("reservas", reservas);
		return "vistaBuscarCliVip";
	}

	// reporte vehiculos Vip
	@GetMapping("/reporteVehiculo")
	public String reporteVehiculosVip(Reserva reserva) {
		
		LOG.info("reporteVehiculo");
		
		return "vistaReporteVehiVip";
	}

	@GetMapping("/buscarVipVehiculo")
	public String buscarVehiculosVip(Reserva dto, Model model) {
		
		LOG.info("buscarVipVehiculo");

		String fecha = "%" + dto.getEstado() + "%";
		List<Vehiculo> vehiculos = this.iVehiculoService.buscarVehiculoVip(fecha);
		LOG.info(fecha);
		List<ReporteVehiculoDto> dtos = this.iReservaService
				.ReporteEncontrarVehi(this.iVehiculoService.buscarVehiculoVip(fecha));
		String pag;

		if (dtos.isEmpty()) {
			return "redirect:/reportes/reporteVehiculo";
		} else {
			model.addAttribute("reporte",
					dtos.stream().sorted(Comparator.comparing(ReporteVehiculoDto::getValoTotal).reversed())
							.collect(Collectors.toList()));
		}

		return "vistaVehiculosVip";
	}

}
