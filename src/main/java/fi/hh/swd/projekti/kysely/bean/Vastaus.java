package fi.hh.swd.projekti.kysely.bean;

public class Vastaus extends Kysymys {
	private int vastausId;
	private String vastaus;
	
	public Vastaus() {
		super.getKysymysId();
		vastausId = 0;
		vastaus = null;
	}
	
	public Vastaus(int vastausId, String vastaus) {
		super();
		this.vastausId = vastausId;
		this.vastaus = vastaus;
	}

	public int getVastausId() {
		return vastausId;
	}

	public void setVastausId(int vastausId) {
		this.vastausId = vastausId;
	}

	public String getVastaus() {
		return vastaus;
	}

	public void setVastaus(String vastaus) {
		this.vastaus = vastaus;
	}

	@Override
	public String toString() {
		return "Vastaus [vastausId=" + vastausId + ", vastaus=" + vastaus + "]";
	}
	
}
