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
import it.objectmethod.movie.domain.FilmBean;



@Controller
public class FilmController {
	@Autowired
	ICategoryDao cd;
	
	@Autowired
	IAttoriDao ad;
	
	@Autowired
	IFilmDao fd;
	
	@RequestMapping("/cercafilm")
	public String cercaFilm(ModelMap map,@RequestParam("film") String film) {
		List<FilmBean> filmList=fd.getFilm(film);
		map.addAttribute("films", filmList);
		return "forward:listagenere";
	}

	@RequestMapping("/listafilmattore")
	public String listaFilmAttore(ModelMap map, @RequestParam("Attore") String attore) {
		List<FilmBean> actorFilmList=fd.getFilmByActor(attore);
		map.addAttribute("filmsattore",actorFilmList);
		return "forward:listagenere";
	}
	
	@RequestMapping("/cercagenere")
	public String setCategory(ModelMap map, @RequestParam("filmgenere") String filmGenere) {
		System.out.println("filmgenere: "+filmGenere);
		List<FilmBean> categoryFilmList=fd.getFilmByCategory(filmGenere);
		map.addAttribute("categoryFilm", categoryFilmList);
		return "forward:listagenere";
	}
	
}
