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
import fi.hh.swd.projekti.kysely.dao.KyselyDAO;

@Controller
@RequestMapping (value="/kyselyt")
public class KyselyController {

	@Inject
	private KyselyDAO dao;
	
	public KyselyDAO getDao() {
		return dao;
	}

	public void setDao(KyselyDAO dao) {
		this.dao = dao;
	}
	
	@RequestMapping(value="uusi", method=RequestMethod.GET)
	public String getCreateForm(Model model) {
		Kysely kyselyBasic = new Kysely();
		kyselyBasic.setKyselyName("Input name");
		kyselyBasic.setKyselyDesc("Input description");
		model.addAttribute("kysely", kyselyBasic);
		return "/form";
	}
	
	@RequestMapping(value="uusi", method=RequestMethod.POST)
	public String create( @ModelAttribute(value="kysely") Kysely kysely, Model model) {
		dao.kyselySave(kysely);
		List<Kysely> kyselyt = dao.kyselyGetAll();
		model.addAttribute("kyselyt", kyselyt);
		return "/list";
	}
	
	@RequestMapping(value="lista", method = RequestMethod.GET)
	public String getAll(Model model) {
		List<Kysely> kyselyt = dao.kyselyGetAll();
		model.addAttribute("kyselyt", kyselyt);
		return "/list";
	}
	
	@RequestMapping(value="lista.json", method=RequestMethod.GET)
	public @ResponseBody List<Kysely> haeKyselytjson(){
		List<Kysely> kyselytjson = dao.kyselyGetAll();
		return kyselytjson ;
	}

}
