package com.uca.capas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import com.uca.capas.dao.CategoriaDAO;
import com.uca.capas.domain.Categoria;


@Service
public class CategoriaServiceImpl implements CategoriaService {
	
	@Autowired
	CategoriaDAO categoriaDao;

	@Override
	public List<Categoria> findAll() throws DataAccessException {
		return categoriaDao.findAll();
	}

	@Transactional
	@Override
	public void save(Categoria categoria) throws DataAccessException {
		try {			
			categoriaDao.save(categoria);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public Categoria findOne(Integer codigo) throws DataAccessException {
		return categoriaDao.findOne(codigo);
	}
	
	

}
