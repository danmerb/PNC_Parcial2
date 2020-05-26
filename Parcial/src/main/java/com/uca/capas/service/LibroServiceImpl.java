package com.uca.capas.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.uca.capas.dao.LibroDAO;
import com.uca.capas.domain.Libro;

@Service
public class LibroServiceImpl implements LibroService {
	@Autowired
	LibroDAO libroDao;
	
	@Autowired
	CategoriaService categoriaService;
	
	
	@Override
	public List<Libro> findAll() throws DataAccessException {
		return libroDao.findAll();
	}

	@Transactional
	@Override
	public void save(Libro libro) throws DataAccessException {

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDateTime now = LocalDateTime.now();
		
		String fecha = dtf.format(now);
		
		try {
			libro.setFechaIngreso(new SimpleDateFormat("dd/MM/yyyy").parse(fecha));
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		
		try {
			libro.setCategoria(categoriaService.findOne(libro.getCategoriaLibro()));
			libroDao.save(libro);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
