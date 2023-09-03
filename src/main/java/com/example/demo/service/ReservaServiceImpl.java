package com.example.demo.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.IClienteRepository;
import com.example.demo.repository.IReservaRepository;
import com.example.demo.repository.IVehiculoRepository;
import com.example.demo.repository.modelo.Cliente;
import com.example.demo.repository.modelo.Reserva;
import com.example.demo.repository.modelo.Vehiculo;
import com.example.demo.repository.modelo.dto.ReporteVehiculoDto;

@Service

public class ReservaServiceImpl implements IReservaService{

	private static final Logger LOG = LoggerFactory.getLogger(ReservaServiceImpl.class);

	@Autowired
	private IReservaRepository iReservaRepo;

	@Autowired
	private IVehiculoRepository iVehiculoRepo;

	@Autowired
	private IClienteRepository clienteRepo;
	@Autowired
	private IPagoService iPagoService;

	@Override
	public void reservar(String placa, String cedula, LocalDateTime inicio, LocalDateTime fin, String numeroTarjeta) {
		// TODO Auto-generated method stub
		Vehiculo vehiculo = this.iVehiculoRepo.encontrarPlaca(placa);
		Cliente cliente = this.clienteRepo.encontrarPorCedula(cedula);

		List<Reserva>reservas =this.iReservaRepo.encontrarTodasReserva();
		

		
		
		Boolean valid=true;
		valid= validacionReserva(inicio, fin, reservas);
		if(valid !=true) {
			System.out.println("Fechas ocupadas");
		}else {

			if (vehiculo.getEstado().equals("I")) {
				System.out.println("Vehiculo Ya Reservado");
			} else {
				System.out.println("Vehiculo listo para reserva");
				Reserva reserva = new Reserva();
				reserva.setCliente(cliente);
				// G de generada
				reserva.setEstado("G");
				reserva.setFin(fin);
				reserva.setInicio(inicio);
				reserva.setVehiculo(vehiculo);

				// Calculo de dias y precio
				Integer dias;
				dias = Period.between(LocalDate.from(inicio), LocalDate.from(fin)).getDays();
				// Calculamos el periodo de dias entre la fecha de inicio y la de fin
				BigDecimal valorSubtotal = vehiculo.getValorPorDia().multiply(new BigDecimal(dias));
				BigDecimal ice = valorSubtotal.multiply(new BigDecimal(0.15));
				BigDecimal totalPrecio = valorSubtotal.add(ice);

				reserva.setIce(ice);
				reserva.setSubtotal(valorSubtotal);
				reserva.setTotal(totalPrecio);
				Integer n = 100;
				Integer numero = (int) (Math.random() * n) + 1;
				reserva.setNumero(numero.toString());
				LOG.info("Costo total : " + totalPrecio);
				this.iReservaRepo.insertar(reserva);

				this.iPagoService.realizarPago(numeroTarjeta, reserva);

				this.iVehiculoRepo.actualizar(vehiculo);

			}

		}






	}

	@Override
	public void actualizarR(Reserva reserva) {
		// TODO Auto-generated method stub
this.iReservaRepo.actualizar(reserva);
	}

	@Override
	public Reserva buscarR(Integer id) {
		// TODO Auto-generated method stub
		return this.iReservaRepo.encontrar(id)
				;
	}

	@Override
	public void borrarR(Integer id) {
		// TODO Auto-generated method stub
		this.iReservaRepo.eliminar(id);
	}

	@Override
	public List<Reserva> buscarTodasReserva() {
		// TODO Auto-generated method stub
		return this.iReservaRepo.encontrarTodasReserva();
	}

	@Override
	public Boolean validacionReserva(LocalDateTime inicio, LocalDateTime fin, List<Reserva> reservas) {

		Boolean valid = true;

		for (Reserva a : reservas) {

			if (a.getFin() != null && a.getInicio() != null) {

				if (a.getInicio().isBefore(inicio) && a.getFin().isBefore(fin) && a.getFin().isBefore(inicio)
						&& a.getFin().isBefore(fin)
						|| a.getInicio().isAfter(inicio) && a.getInicio().isAfter(fin) && a.getFin().isAfter(inicio)
								&& a.getFin().isAfter(fin)

				) {

					valid = true;

				} else {
					valid = false;
					break;
				}

			}
			valid = true;

		}

		return valid;
	}

	@Override
	public Reserva encontrarPorNumero(String numeroReserva) {
		// TODO Auto-generated method stub
		return this.iReservaRepo.encontrarPorNumero(numeroReserva);
	}


	
	@Override
	public String reservarRetorno(String placa, String cedula, LocalDateTime inicio, LocalDateTime fin, String numeroTarjeta) {
		// TODO Auto-generated method stub
		Vehiculo vehiculo = this.iVehiculoRepo.encontrarPlaca(placa);
		Cliente cliente = this.clienteRepo.encontrarPorCedula(cedula);
 
		
 
		List<Reserva>reservas =this.iReservaRepo.encontrarTodasReserva();
		
	
	
		
		Boolean valid=true;
		valid= this.validacionReserva(inicio, fin, reservas);
		
		
		
		if(valid !=true) {
			return "FECHA OCUPADA INTENTE DE NUEVO EN OTRAS FECHAS";
		}else {

			if (vehiculo.getEstado().equals("I")) {
				return "Vehiculo Ya Reservado";
			} else {
				System.out.println("Vehiculo listo para reserva");
				Reserva reserva = new Reserva();
				reserva.setCliente(cliente);
				// G de generada
				reserva.setEstado("G");
				reserva.setFin(fin);
				reserva.setInicio(inicio);
				reserva.setVehiculo(vehiculo);

				// Calculo de dias y precio
				Integer dias;
				dias = Period.between(LocalDate.from(inicio), LocalDate.from(fin)).getDays();
				// Calculamos el periodo de dias entre la fecha de inicio y la de fin
				BigDecimal valorSubtotal = vehiculo.getValorPorDia().multiply(new BigDecimal(dias+1));
				BigDecimal ice = valorSubtotal.multiply(new BigDecimal(0.15));
				BigDecimal totalPrecio = valorSubtotal.add(ice);

				reserva.setIce(ice);
				reserva.setSubtotal(valorSubtotal);
				reserva.setTotal(totalPrecio);
				Integer n = 100;
				Integer numero = (int) (Math.random() * n) + 1;
				reserva.setNumero(numero.toString());
				LOG.info("Costo total : " + totalPrecio);
				this.iReservaRepo.insertar(reserva);

				this.iPagoService.realizarPago(numeroTarjeta, reserva);

				this.iVehiculoRepo.actualizar(vehiculo);
				
				return "Reserva Exitosa";

			}

		}






	}

	@Override
	public List<Reserva> buscarList(String numeroReserva) {
		// TODO Auto-generated method stub
		return this.iReservaRepo.buscarList(numeroReserva);
	}

	@Override
	public void retirarVehiculo(String numero) {
		// TODO Auto-generated method stub
		Reserva reserva=this.iReservaRepo.buscar(numero);
		Vehiculo v=reserva.getVehiculo();
		v.setEstado("I");
		reserva.setEstado("E");
		this.iVehiculoRepo.actualizar(v);
		this.iReservaRepo.actualizar(reserva);
		
	}

	@Override
	public Reserva buscarNumero(String numeroReserva) {
		// TODO Auto-generated method stub
		return this.iReservaRepo.buscar(numeroReserva);
	}

	@Override
	public List<Reserva> buscarRangoFecha(LocalDateTime inicio, LocalDateTime fin) {
		// TODO Auto-generated method stub
		return this.iReservaRepo.encontrarRangoFecha(inicio, fin);
	}

	@Override
	public List<Reserva> buscarClientesVip() {
		// TODO Auto-generated method stub
		return this.iReservaRepo.encontrarClientesVip();
	}

	@Override
	public List<ReporteVehiculoDto> ReporteEncontrarVehi(List<Vehiculo> vehiculos) {
		
		
		BigDecimal valorF = new BigDecimal(0);
		BigDecimal valorT = new BigDecimal(0);
		BigDecimal valorIce = new BigDecimal(0);
		List<ReporteVehiculoDto> reporte = new ArrayList<>();
		
		for(Vehiculo vehiculo: vehiculos) {
			
			ReporteVehiculoDto dto= new ReporteVehiculoDto();
			List<Reserva>list= this.buscarReportePlaca(vehiculo.getPlaca());
			
			for(Reserva res : list) {
				valorIce= res.getIce();
				valorT= valorT.add(res.getSubtotal()).add(valorIce);
				
			}
			dto.setPlaca(vehiculo.getPlaca());
			dto.setModelo(vehiculo.getModelo());
			dto.setValorIva(valorIce);
			dto.setValoTotal(valorT);
			reporte.add(dto);
			
			
			
			valorT = new BigDecimal(0);
			
			
			
		}
		
		
		return reporte;
	}

	@Override
	public List<Reserva> buscarReportePlaca(String placa) {
		// TODO Auto-generated method stub
		return this.iReservaRepo.encontrarReportePlaca(placa);
	}

	
	
	
	
}
