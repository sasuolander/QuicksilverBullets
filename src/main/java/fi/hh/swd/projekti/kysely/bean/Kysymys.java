package fi.hh.swd.projekti.kysely.bean;

import java.util.List;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

public class Kysymys  {
	private int kysymysId;
	private String kysymys;
	private String kysymysType;
	private List<Vastaus> vastaukset;
	private List<Valinta> valinnat;
	private int kyselyId;
	
	
	public int getKyselyId() {
		return kyselyId;
	}

	public void setKyselyId(int id) {
		this.kyselyId= id;
	}

	public void lisaa(Vastaus vastaus){
		this.vastaukset.add(vastaus);
	}
	
	public void lisaa(Valinta valinta) {
		this.valinnat.add(valinta);
	}
	
	public Kysymys() {
		kysymysId = 0;
		kysymys = null;
		kysymysType = null;
		
	}
	
	public Kysymys(int kysymysId, String kysymys, String kysymysType) {
		super();
		this.kysymysId = kysymysId;
		this.kysymys = kysymys;
		this.kysymysType = kysymysType;
		
	}
	
	public Kysymys(int kysymysId,List<Vastaus> vastaukset) {
		super();
		this.kysymysId = kysymysId;
		this.vastaukset = vastaukset;
	}

	public int getKysymysId() {
		return kysymysId;
	}

	public void setKysymysId(int kysymysId) {
		this.kysymysId = kysymysId;
	}

	public String getKysymys() {
		return kysymys;
	}

	public void setKysymys(String kysymys) {
		this.kysymys = kysymys;
	}

	@Override
	public String toString() {
		return "Kysymys [kysymysId=" + kysymysId + ", kysymys=" + kysymys + "]";
	}

	public String getKysymysType() {
		return kysymysType;
	}

	public void setKysymysType(String kysymysType) {
		this.kysymysType = kysymysType;
	}
	
	public List<Vastaus> getVastaukset() {
		return vastaukset;
	}
	
	public void setVastaukset(List<Vastaus> vastaukset) {
		this.vastaukset = vastaukset;
	}

	public List<Valinta> getValinnat() {
		return valinnat;
	}

	public void setValinnat(List<Valinta> valinnat) {
		this.valinnat = valinnat;
	}

}
