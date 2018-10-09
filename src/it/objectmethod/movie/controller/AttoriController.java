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



@Controller
public class AttoriController {
	@Autowired
	ICategoryDao cd;
	@Autowired
	IAttoriDao ad;
	
	@Autowired
	IFilmDao fd;
	
	@RequestMapping("/cercaattori")
	public String cercaAttori(ModelMap map,@RequestParam("actor") String actor) {
		List<AttoriBean> actorlist=ad.getActors(actor);
		map.addAttribute("attori", actorlist);
		return "forward:listagenere";
	}

	@RequestMapping("/listaattorifilm")
	public String attoriFilm(ModelMap map,@RequestParam("Film") String film ) {
		List<AttoriBean> actorsFilmList=ad.getActorsByFilm(film);
		map.addAttribute("actorsfilm", actorsFilmList);
		return "forward:listagenere";
	}
	
}
