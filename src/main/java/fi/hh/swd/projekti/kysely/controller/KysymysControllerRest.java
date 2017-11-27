package fi.hh.swd.projekti.kysely.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import fi.hh.swd.projekti.kysely.bean.Kysely;
import fi.hh.swd.projekti.kysely.bean.Kysymys;
import fi.hh.swd.projekti.kysely.bean.Valinta;
import fi.hh.swd.projekti.kysely.dao.KysymysDAO;

@RestController
@RequestMapping(value="/api")
public class KysymysControllerRest {
	
	@Inject
	private KysymysDAO dao;
	
	public KysymysDAO getDAO(){
		return dao;
	}

	public void setDAO(KysymysDAO dao){
		this.dao = dao;
	}
	
	@RequestMapping(value="kysymykset/{kyselyId}", method=RequestMethod.GET)
	public @ResponseBody List<Kysely> haeKysymyksetjson(@PathVariable (value="kyselyId") int kyselyId){
		Kysely kysely;
		Kysymys kysymys;
		List<Valinta> valinnatjson = null;
		List<Kysely> kysymysjson = dao.kysymysGetAll(kyselyId);
		for(int i = 0; i < kysymysjson.size(); i++) {
			kysely = kysymysjson.get(i);
			List<Kysymys> kysymykset = kysely.getKysymykset();
			for (int ii = 0; ii < kysymykset.size(); ii++) {
				kysymys = kysymykset.get(ii);
				System.out.println("KYSYMYS ID ON: " + kysymys.getKysymysId());
				valinnatjson = dao.valintaGetAll(kysymys.getKysymysId());
				
				kysymys.setValinnat(valinnatjson);
			}
		}
		return kysymysjson;
	}
}