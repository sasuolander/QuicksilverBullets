package fi.hh.swd.projekti.kysely.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import fi.hh.swd.projekti.kysely.bean.Kysymys;
import fi.hh.swd.projekti.kysely.bean.Vastaus;
import fi.hh.swd.projekti.kysely.dao.VastausDAO;

@RestController
@RequestMapping(value="/api")
public class VastausControllerRest {
	
	@Inject
	private VastausDAO dao;
	
	public VastausDAO getDAO(){
		return dao;
	}
	
	public void setDAO(VastausDAO dao){
		this.dao = dao;
	}
	
	@RequestMapping(value="vastaukset/{kysymysId}", method=RequestMethod.GET)
	public @ResponseBody List<Kysymys> haeVastausjson(@PathVariable (value="kysymysId") int kysymysId){
		List<Kysymys> vastausjson = dao.vastausGetAll(kysymysId);
		return vastausjson;
	}
	
	@RequestMapping(value="lisaa", method=RequestMethod.POST)
	public @ResponseBody Vastaus lisaaVastaus(@RequestBody Vastaus vastaus){
		dao.vastausSave(vastaus);
		return vastaus;
	}

}
