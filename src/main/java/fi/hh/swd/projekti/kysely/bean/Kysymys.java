package fi.hh.swd.projekti.kysely.bean;

import java.util.List;

public class Kysymys  {
	private int kysymysId;
	private String kysymys;
	private List<Vastaus> vastaukset;
	
	
	public List<Vastaus> getVastaukset() {
		return vastaukset;
	}

	public void setVastaukset(List<Vastaus> vastaukset) {
		this.vastaukset = vastaukset;
	}

	public Kysymys() {
		kysymysId = 0;
		kysymys = null;
	}
	
	public Kysymys(int kysymysId, String kysymys) {
		super();
		this.kysymysId = kysymysId;
		this.kysymys = kysymys;
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
	
}
