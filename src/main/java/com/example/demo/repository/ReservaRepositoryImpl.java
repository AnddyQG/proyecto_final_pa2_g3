package com.example.demo.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.Reserva;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional

public class ReservaRepositoryImpl implements IReservaRepository{

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(Reserva reserva) {
		// TODO Auto-generated method stub
		this.entityManager.persist(reserva);
	}

	@Override
	public void actualizar(Reserva reserva) {
		// TODO Auto-generated method stub
		this.entityManager.merge(reserva);
	}

	@Override
	public Reserva encontrar(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Reserva.class, id);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		Reserva reserva = this.encontrar(id);
		this.entityManager.remove(reserva);
	}

	@Override
	public List<Reserva> encontrarTodasReserva() {

		TypedQuery<Reserva> query = this.entityManager.createQuery("SELECT r FROM Reserva r", Reserva.class);

		return query.getResultList();

	}

	@Override
	public Reserva encontrarPorNumero(String numeroReserva) {

		TypedQuery<Reserva> query = this.entityManager.createQuery("select r from Reserva r", Reserva.class);

		try {
			return query.getSingleResult();
		} catch (Exception e) {
			return query.getResultList().get(0);
		}

	}

	@Override
	public Reserva buscar(String numeroReserva) {

		Query query = this.entityManager.createNativeQuery("SELECT * FROM reserva WHERE rese_numero = :datoNumero",
				Reserva.class);
		query.setParameter("datoNumero", numeroReserva);
		try {
			return (Reserva) query.getSingleResult();
		} catch (Exception e) {
			return (Reserva) query.getResultList().get(0);
		}

	}

	@Override
	public Integer actEstado(String numeroReserva) {

		Query query = this.entityManager.createNativeQuery(
				"UPDATE public.reserva SET rese_estado = 'E' WHERE rese_numero = :datoNumero", Reserva.class);
		query.setParameter("datoNumero", numeroReserva);

		return query.executeUpdate();

	}

	@Override
	public List<Reserva> buscarList(String numeroReserva) {
		
		
		Query query = this.entityManager.createNativeQuery("SELECT * FROM reserva WHERE rese_numero = :datoNumero",
				Reserva.class);
		query.setParameter("datoNumero", numeroReserva);
		try {
			return (List<Reserva>) query.getResultList();
		} catch (Exception e) {
			return (List<Reserva>) query.getResultList().get(0);
		}
		
	}

	@Override
	public List<Reserva> encontrarRangoFecha(LocalDateTime inicio, LocalDateTime fin) {
	
		String jpql="SELECT r FROM Reserva r WHERE r.inicio>= :datoInicio AND r.fin<= :datoFin";
		TypedQuery<Reserva> query=this.entityManager.createQuery(jpql,Reserva.class);
		
		query.setParameter("datoInicio", inicio);
		query.setParameter("datoFin", fin);
		List<Reserva> reservas =query.getResultList();
		for (Reserva reserva : reservas) {
			reserva.getVehiculo().getEstado();
			reserva.getCliente().getFechaNacimiento();
		}
		return reservas;
		
		
		
	}

	@Override
	public List<Reserva> encontrarClientesVip() {
	String jpql="SELECT r FROM Reserva r JOIN r.cliente c ORDER BY r.total DESC";
		TypedQuery<Reserva>query=this.entityManager.createQuery(jpql,Reserva.class);
		
		List<Reserva>reservas= query.getResultList();
		reservas.forEach(a->a.getCliente().getCedula());
		//revisar este error la pagina web se cae
		// reservas.parallelStream().forEach(a->a.getCliente().getCedula());
		return reservas;
		
	}

	@Override
	public List<Reserva> encontrarReportePlaca(String placa) {
		
		String jpql="select r from Reserva r join fetch r.vehiculo v where v.placa= :datoPlaca";
		TypedQuery<Reserva>query=this.entityManager.createQuery(jpql,Reserva.class);
		query.setParameter("datoPlaca", placa);
		
		return query.getResultList();
	}

	
}
