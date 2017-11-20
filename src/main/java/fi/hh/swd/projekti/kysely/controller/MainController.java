package fi.hh.swd.projekti.kysely.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import fi.hh.swd.projekti.kysely.bean.Kysely;
import fi.hh.swd.projekti.kysely.bean.Kysymys;
import fi.hh.swd.projekti.kysely.bean.Vastaus;
import fi.hh.swd.projekti.kysely.dao.KyselyDAO;
import fi.hh.swd.projekti.kysely.dao.KysymysDAO;
import fi.hh.swd.projekti.kysely.dao.VastausDAO;

@Controller
@RequestMapping (value="/kyselyt")
public class MainController {

	@Inject
	private KyselyDAO daoKysely;
	private KysymysDAO daoKysymys;
	private VastausDAO daoVastaus;
	
	public KyselyDAO getKysely() {
		return daoKysely;
	}

	public void setKysely(KyselyDAO daoKysely) {
		this.daoKysely = daoKysely;
	}
	
	public KysymysDAO getKysymys() {
		return daoKysymys;
	}

	public void setKysymys(KysymysDAO daoKysymys) {
		this.daoKysymys = daoKysymys;
	}
	
	public VastausDAO getVastaus() {
		return daoVastaus;
	}
	public void setVastaus(VastausDAO daoVastaus) {
		this.daoVastaus = daoVastaus;
	}
	
	
	@RequestMapping(value="uusi", method=RequestMethod.GET)
	public String getCreateForm(Model model) {
		Kysely kyselyBasic = new Kysely();
		kyselyBasic.setKyselyName("Input name");
		kyselyBasic.setKyselyDesc("Input description");
		model.addAttribute("kysely", kyselyBasic);
		return "/form";
	}
	
	@RequestMapping(value="uusiKysely", method=RequestMethod.POST)
	public String createKysely(@ModelAttribute(value="kysely") Kysely kysely, Model model) {
		daoKysely.kyselySave(kysely);
		List<Kysely> kyselyt = daoKysely.kyselyGetAll();
		model.addAttribute("kyselyt", kyselyt);
		return "/list";
	}
	
	@RequestMapping(value="uusiKysymys", method=RequestMethod.POST)
	public String createKysymys(@ModelAttribute(value="kysymys") Kysymys kysymys, Model model){
		
		daoKysymys.kysymysSave(kysymys);
		List<Kysymys> kysymykset = daoKysymys.kysymysGetAll(kysymys.getKyselyId());
		model.addAttribute("kysymykset", kysymykset);
		return "/list";
		
	}
	
	@RequestMapping(value="uusiVastaus", method=RequestMethod.POST)
	public String createVastaus(@ModelAttribute(value="vastaus") Vastaus vastaus, Model model){
		daoVastaus.vastausSave(vastaus);
		List<Vastaus> vastaukset = daoVastaus.vastausGetAll(vastaus.getVastausId());
		model.addAttribute("vastaukset", vastaukset);
		return "/list";
		
	}
	
	@RequestMapping(value="lista", method = RequestMethod.GET)
	public String getAll(Model model) {
		List<Kysely> kyselyt = daoKysely.kyselyGetAll();
		model.addAttribute("kyselyt", kyselyt);
		return "/list";
	}
	
	@RequestMapping(value="lista.json", method=RequestMethod.GET)
	public @ResponseBody List<Kysely> haeKyselytjson(){
		List<Kysely> kyselytjson = daoKysely.kyselyGetAll();
		return kyselytjson;
	}
	

}