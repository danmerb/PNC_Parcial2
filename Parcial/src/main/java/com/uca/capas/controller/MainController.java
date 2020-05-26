package com.uca.capas.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.uca.capas.domain.Categoria;
import com.uca.capas.domain.Libro;
import com.uca.capas.service.CategoriaService;
import com.uca.capas.service.LibroService;

@Controller
public class MainController {
	@Autowired
	CategoriaService categoriaService;
	
	@Autowired
	LibroService libroService;
	
	@RequestMapping("/index")
	public ModelAndView index() {		
		ModelAndView mav = new ModelAndView();		
		mav.setViewName("inicio");		
		return mav;
	}
	
	@RequestMapping("/formCategoria")
	public ModelAndView form() {
		
		ModelAndView mav = new ModelAndView();		
		mav.addObject("categoria", new Categoria());
		mav.setViewName("InsCategoria");
		
		return mav;
	}
	
	@RequestMapping("/InsCategoria")
	public ModelAndView insertar(@Valid @ModelAttribute Categoria categoria, BindingResult result) {
		ModelAndView mav = new ModelAndView();		
		if(result.hasErrors()) {
			mav.setViewName("InsCategoria");
			return mav;
		}else {
			try {
				categoriaService.save(categoria);
			}catch(Exception e) {
				e.printStackTrace();			}
			
			mav.addObject("categoria", new Categoria());
			String mensaje ="Categoría guardada con éxito";		
			mav.addObject("mens2", mensaje);
			mav.setViewName("inicio");
		}
		
		return mav;
	}
	@RequestMapping("/formLibro")
	public ModelAndView formL() {
		ModelAndView mav = new ModelAndView();		
		mav.addObject("libro", new Libro());
		mav.addObject("categorias", categoriaService.findAll());
		mav.setViewName("InsLibro");
		return mav;
	}
	
	@RequestMapping("/InsLibro")
	public ModelAndView insertar(@Valid @ModelAttribute Libro libro, BindingResult result) {
		ModelAndView mav = new ModelAndView();		
		if(result.hasErrors()) {
			mav.addObject("categorias", categoriaService.findAll());
			mav.setViewName("InsLibro");
			return mav;
		}else {
			try {
				libroService.save(libro);
			}catch(Exception e) {
				e.printStackTrace();			}
			
			mav.addObject("libro", new Libro());
			String mensaje ="Libro guardado con éxito";		
			mav.addObject("mens3", mensaje);
			mav.setViewName("inicio");
		}
		
		return mav;
	}
	
	@RequestMapping("/listado")
	public ModelAndView listado() {
		
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("libros", libroService.findAll());
		mav.setViewName("listado");
		
		return mav;
	}
	
	
	
}
