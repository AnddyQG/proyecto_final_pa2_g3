package com.example.demo.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.Vehiculo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional

public class VehiculoRepositoryImpl implements IVehiculoRepository{

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(Vehiculo vehiculo) {
		this.entityManager.persist(vehiculo);
	}

	@Override
	public void actualizar(Vehiculo vehiculo) {
		this.entityManager.merge(vehiculo);
	}

	@Override
	public Vehiculo encontrar(Integer id) {
		return this.entityManager.find(Vehiculo.class, id);
	}

	@Override
	public void eliminar(Integer id) {
		Vehiculo vehiculo= this.encontrar(id);
		this.entityManager.remove(vehiculo);
	}

	@Override
	public List<Vehiculo> encontrarVehiDisponibles() {

		Query query=this.entityManager.createQuery("SELECT v FROM Vehiculo v WHERE v.estado =: datoEstado");
		query.setParameter("datoEstado", "D");
		return query.getResultList();

	}

	@Override
	public List<Vehiculo> encontrarTodosVehi() {

		Query query =this.entityManager.createQuery("SELECT v FROM Vehiculo v");
		return query.getResultList();

	}

	@Override
	public List<Vehiculo> encontrarMarcaModelo(String marca, String modelo) {
		TypedQuery<Vehiculo> query =this.entityManager.createQuery("SELECT v FROM Vehiculo v WHERE v.marca = :datoMarca AND v.modelo =: datoModelo",Vehiculo.class);
		query.setParameter("datoMarca", marca);
		query.setParameter("datoModelo", modelo);
		return query.getResultList();
	}

	@Override
	public Vehiculo encontrarPlaca(String placa) {

		TypedQuery<Vehiculo>query=this.entityManager.createQuery("SELECT v FROM Vehiculo v WHERE v.placa = :datoPlaca",Vehiculo.class);
		query.setParameter("datoPlaca", placa);


		return query.getSingleResult();
	}

	@Override
	public Integer actEstado(String placa) {

		Query query=this.entityManager.createNativeQuery("UPDATE vehiculo SET vehi_estado = 'I' WHERE vehi_placa =:datoPlaca",Vehiculo.class);
		query.setParameter("datoPlaca", placa);
		return query.executeUpdate();

	}

	@Override
	public List<Vehiculo> encontrarPlacaList(String placa) {

		TypedQuery<Vehiculo>query=this.entityManager.createQuery("SELECT v FROM Vehiculo v WHERE v.placa = :datoPlaca",Vehiculo.class);
		query.setParameter("datoPlaca", placa);


		return query.getResultList();
	}

	@Override
	public List<Vehiculo> encontrarVehiculoVip(String fecha) {
		String jpql="SELECT v FROM Vehiculo v JOIN v.reserva r WHERE concat(r.inicio, '') LIKE :datoFecha AND concat(r.fin, '') LIKE :datoFecha";
		TypedQuery<Vehiculo>query=this.entityManager.createQuery(jpql,Vehiculo.class);
		query.setParameter("datoFecha", fecha);
		
		
		
		return query.getResultList();
	}

	@Override
	public List<Vehiculo> encontrarMarcayModeloList(String marca, String modelo) {
		String jpql="SELECT v FROM Vehiculo v WHERE v.marca = :datoMarca AND v.modelo =: datoModelo";
		TypedQuery<Vehiculo>query=this.entityManager.createQuery(jpql,Vehiculo.class);
		query.setParameter("datoMarca", marca);
		query.setParameter("datoModelo", modelo);
		return query.getResultList();
	}
	
	
}
