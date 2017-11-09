package fi.hh.swd.projekti.kysely.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import fi.hh.swd.projekti.kysely.bean.Kysymys;
import fi.hh.swd.projekti.kysely.dao.KysymysDAO;

@RestController
@RequestMapping(value="/kysymysRest")
public class KysymysControllerRest {
	
	@Inject
	private KysymysDAO dao;
	
	public KysymysDAO getDAO(){
		return dao;
	}

	public void setDAO(KysymysDAO dao){
		this.dao = dao;
	}
	
	@RequestMapping(value="kysymyksetJson", method=RequestMethod.GET)
	public @ResponseBody List<Kysymys> haeKysymyksetjson(){
		List<Kysymys> kysymysjson = dao.kysymysGetAll();
		return kysymysjson;
	}
}
