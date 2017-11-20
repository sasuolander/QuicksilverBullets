package fi.hh.swd.projekti.kysely.bean;

public class Kysymys extends Kysely {
	private int kysymysId;
	private String kysymys;
	private String kysymysType;
	
	public Kysymys() {
		super.getKyselyId();
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
	
}
