package com.example.demo.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.Cliente;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional

public class ClienteRepositoryImpl implements IClienteRepository{


	@PersistenceContext
	private EntityManager entityManager;

	

	
	
	@Override
	public void insertar(Cliente cliente) {
		// TODO Auto-generated method stub
		this.entityManager.persist(cliente);
	}

	@Override
	public void actualizar(Cliente cliente) {
		// TODO Auto-generated method stub
		this.entityManager.merge(cliente);
	}

	@Override
	public Cliente buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Cliente.class, id);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		Cliente cliente= this.buscar(id);
		this.entityManager.remove(cliente);

	}

	@Override
	public Cliente encontrarPorCedula(String cedula) {
	TypedQuery<Cliente> query=this.entityManager.createQuery("SELECT e FROM Cliente e WHERE e.cedula = :datoCedula",Cliente.class);
	query.setParameter("datoCedula", cedula);
	return query.getSingleResult();

	}
	
	@Override
	public List<Cliente> encontrarPorCedulaList(String cedula) {
	TypedQuery<Cliente> query=this.entityManager.createQuery("SELECT e FROM Cliente e WHERE e.cedula = :datoCedula",Cliente.class);
	query.setParameter("datoCedula", cedula);
	return query.getResultList();

	}

	@Override
	public List<Cliente> encontrarTodos() {
	Query query=this.entityManager.createQuery("SELECT c FROM Cliente c",Cliente.class);
	return query.getResultList();
	}
	
	
}
