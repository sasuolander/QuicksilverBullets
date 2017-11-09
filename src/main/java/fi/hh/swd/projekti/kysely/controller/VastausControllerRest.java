package fi.hh.swd.projekti.kysely.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import fi.hh.swd.projekti.kysely.bean.Vastaus;
import fi.hh.swd.projekti.kysely.dao.VastausDAO;

@RestController
@RequestMapping(value="/vastausRest")
public class VastausControllerRest {
	
	@Inject
	private VastausDAO dao;
	
	public VastausDAO getDAO(){
		return dao;
	}
	
	public void setDAO(VastausDAO dao){
		this.dao = dao;
	}
	
	@RequestMapping(value="vastausJson", method=RequestMethod.GET)
	public @ResponseBody List<Vastaus> haeVastausjson(){
		List<Vastaus> vastausjson = dao.vastausGetAll();
		return vastausjson;
	}

}
