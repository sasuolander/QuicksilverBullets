package fi.hh.swd.projekti.kysely.controller;

import java.util.List;

import javax.inject.Inject;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import fi.hh.swd.projekti.kysely.bean.Kysely;
import fi.hh.swd.projekti.kysely.dao.KyselyDAO;

@RestController
@RequestMapping (value="/api")
public class KyselyControllerRest {
	
	@Inject
	private KyselyDAO dao;
	
	public KyselyDAO getDao() {
		return dao;
	}

	public void setDao(KyselyDAO dao) {
		this.dao = dao;
	}

	
	@RequestMapping(value="kyselyt", method=RequestMethod.GET)
	public @ResponseBody List<Kysely> haeKyselytjson(){
		List<Kysely> kyselytjson = dao.kyselyGetAll();
		return kyselytjson ;
	}
	
}
