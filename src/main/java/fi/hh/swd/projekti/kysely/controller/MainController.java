package fi.hh.swd.projekti.kysely.controller;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
	@Inject
	private KysymysDAO daoKysymys;
	@Inject
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
		return "form";
	}
	
	//
	//Viltsu: Muokkasin tämän lisaaKysymys Getin sillei että ottaa mukaan tuolta list.jsp sivulta kyselyId:n 
	//jota tarvitaan tuolla tietokannassa kysymys taulussa.
	//
	
	@RequestMapping(value="lisaaKysymys", method=RequestMethod.GET)
	public String getCreateFormKysymys(Model model, @RequestParam(value="kyselyId") int kyselyId) {
		Kysymys kysymys = new Kysymys();
		kysymys.setKyselyId(kyselyId);
		model.addAttribute("kysymys", kysymys);
		return "addkysymys";
	}
	
	@RequestMapping(value="uusi", method=RequestMethod.POST)
	public String createKysely(@ModelAttribute(value="kysely") Kysely kysely, Model model) {
		daoKysely.kyselySave(kysely);
		List<Kysely> kyselyt = daoKysely.kyselyGetAll();
		model.addAttribute("kyselyt", kyselyt);
		return "list";
	}
	
	/*
	 * Viltsu: muokkasin tätä lisaaKysymys POSTia myös sillei että tuo formin kohta kyselyId tulee mukaan tuohon
	 * kysymysSave metodiin ja kysymysGetAll metodiin. Muokkauksen alla oli MainController, Kysymys bean, list.jsp ja addkysymys.jsp.
	 */
	
	@RequestMapping(value="lisaaKysymys", method=RequestMethod.POST)
	public String createKysymys(@ModelAttribute(value="kysymys") Kysymys kysymys, @RequestParam(value="kyselyId") int kyselyId, Model model){
		daoKysymys.kysymysSave(kyselyId ,kysymys);
		List<Kysely> kysymykset = daoKysymys.kysymysGetAll(kyselyId);
		model.addAttribute("kysymykset", kysymykset);
		return "/kysymysList";
	}
	
	@RequestMapping(value="uusiVastaus", method=RequestMethod.POST)
	public String createVastaus(@ModelAttribute(value="vastaus") Kysymys kysymys, Model model){
		int kysymysId = kysymys.getKysymysId();
		Vastaus vastaus = kysymys.getVastaukset().get(0);
		daoVastaus.vastausSave(kysymysId, vastaus);
		List<Kysymys> vastaukset = daoVastaus.vastausGetAll(vastaus.getVastausId());
		model.addAttribute("vastaukset", vastaukset);
		return "/list";
		
	}
	
	@RequestMapping(value="lista", method = RequestMethod.GET)
	public String getAll(Model model) {
		List<Kysely> kyselyt = daoKysely.kyselyGetAll();
		model.addAttribute("kyselyt", kyselyt);
		return "list";
	}
	

	@RequestMapping(value="kysymykset", method = RequestMethod.GET)
	public String getAllKysymykset(Model model) {
		List<Kysely> kysymykset2 = daoKysymys.kysymysGetAll(1);
		List<Kysymys> kysymykset = null;
		Kysely kysely;
		for (int i = 0; i < kysymykset2.size(); i++) {
			kysely = kysymykset2.get(i);
			kysymykset = kysely.getKysymykset();
		}
		model.addAttribute("kysymykset", kysymykset);
		return "/listKysymykset";
	}
  
	@RequestMapping(value="listaVastaukset", method = RequestMethod.GET)
	public String getAllVastaus(Model model) {
		//List<Vastaus> vastaukset = new ArrayList<Vastaus>();
		//List<Integer> kysymysIdList =new ArrayList<Integer>();
		//List<Kysely> kysymykset = new ArrayList<Kysely>();
		
		//List<Kysely> KyselyList= daoKysely.kyselyGetAll();
		
		/*for (int i=0;i< KyselyList.size();i++){
//Tämä saattaa toimia mutta ei ole testattu	List<Kysely> kysymyksetvali=daoKysymys.kysymysGetAll(i+1); 
			kysymykset.addAll(kysymyksetvali);
			for (int v =0;v<kysymykset.get(0).getKysymykset().size();v++){
				Kysymys kysymys= kysymykset.get(0).getKysymykset().get(v);
				int id =kysymys.getKysymysId();
				kysymysIdList.add(id); 
				} 
		}
		for (int i=0;i< kysymysIdList.size();i++){
			List<Kysymys> vastausetVali = daoVastaus.vastausGetAll(i+1);
			List<Vastaus>vastaukset2= vastausetVali.get(0).getVastaukset();
			vastaukset.addAll(vastaukset2);}*/
		//Kysely p = kysymykset.get(0);
		//List<Kysymys> b = kysymykset.get(0).getKysymykset();
		//Kysymys c = kysymykset.get(0).getKysymykset().get(0);
		
		List<Vastaus> vastaukset2=daoVastaus.vastausGetAllObject();
		
		model.addAttribute("vastauksetObject", vastaukset2);
		return "/vastaukset";
	}
	
	@RequestMapping(value="lista.json", method=RequestMethod.GET)
	public @ResponseBody List<Kysely> haeKyselytjson(){
		List<Kysely> kyselytjson = daoKysely.kyselyGetAll();
		return kyselytjson;
	}
  }