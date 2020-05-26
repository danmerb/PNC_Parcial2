package com.uca.capas.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.uca.capas.domain.Categoria;

@Repository
public class CategoriaDAOImpl implements CategoriaDAO{

	@PersistenceContext(unitName = "capas")
	EntityManager entityManager;

	@Override
	public List<Categoria> findAll() throws DataAccessException {
		StringBuffer sb = new StringBuffer();
		sb.append("select * from public.cat_categoria");
		Query query = entityManager.createNativeQuery(sb.toString(), Categoria.class);
		List<Categoria> res = query.getResultList();
		return res;
	}

	@Override
	public void save(Categoria categoria) throws DataAccessException {
		entityManager.persist(categoria);		
	}

	@Override
	public Categoria findOne(Integer codigo) throws DataAccessException {
		Categoria i = entityManager.find(Categoria.class, codigo);
		return i;
	}
	
	
}

