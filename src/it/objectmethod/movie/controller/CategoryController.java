package it.objectmethod.movie.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.objectmethod.movie.dao.IAttoriDao;
import it.objectmethod.movie.dao.ICategoryDao;
import it.objectmethod.movie.dao.IFilmDao;
import it.objectmethod.movie.domain.AttoriBean;
import it.objectmethod.movie.domain.CategoryBean;



@Controller
public class CategoryController {
	
	@Autowired
	ICategoryDao cd;
	
	@Autowired
	IAttoriDao ad;
	
	@Autowired
	IFilmDao fd;
	
	@RequestMapping("/listagenere")
	public String getCategory(ModelMap map) {
		List<CategoryBean> categorylist=cd.getCategory();
		map.addAttribute("category", categorylist);
		return "Ricerca";
	}

	
	
}
