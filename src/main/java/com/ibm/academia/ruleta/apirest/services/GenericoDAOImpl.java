package com.ibm.academia.ruleta.apirest.services;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public class GenericoDAOImpl<E, R extends CrudRepository<E, Long>>implements GenericoDAO<E>
{
	protected final R repository;
	
	public GenericoDAOImpl(R repository) 
	{
		this.repository= repository;
	}
	
	@Override
	@Transactional(readOnly = true)
	public Optional<E> buscarPorId(Long id) {
		
		return repository.findById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public Iterable<E> buscarTodos() {
		
		return repository.findAll();
	}

	@Override
	@Transactional
	public void eliminarPorId(Long id) 
	{
		repository.deleteById(id);
		
	}

	@Override
	public void crear(E entidad) {
		repository.save(entidad);
	}

}
