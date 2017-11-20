package fi.hh.swd.projekti.kysely.bean;

public class Vastaus extends Kysymys {
	private int vastausId;
	private String vastaus;
	private String vastausType;
	
	public Vastaus() {
		super.getKysymysId();
		vastausId = 0;
		vastaus = null;
		vastausType = null;
	}
	
	public Vastaus(int vastausId, String vastaus, String vastausType) {
		super();
		this.vastausId = vastausId;
		this.vastaus = vastaus;
		this.vastausType = vastausType;
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

	public String getVastausType() {
		return vastausType;
	}

	public void setVastausType(String vastausType) {
		this.vastausType = vastausType;
	}
	
}
