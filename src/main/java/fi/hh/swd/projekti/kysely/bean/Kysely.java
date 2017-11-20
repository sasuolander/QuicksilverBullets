package fi.hh.swd.projekti.kysely.bean;

import java.util.List;

public class Kysely {
	private int kyselyId;
	private String kyselyName;
	private String kyselyDesc;
	private List<Kysymys> kysymykset;
	
	public List<Kysymys> getKysymykset() {
		return kysymykset;
	}

	public void setKysymykset(List<Kysymys> kysymykset) {
		this.kysymykset = kysymykset;
	}
	
	

	public Kysely() {
		kyselyId = 0;
		kyselyName = null;
		kyselyDesc = null;
	}
	
	public Kysely(int kyselyId, String kyselyName, String kyselyDesc) {
		this.kyselyId = kyselyId;
		this.kyselyName = kyselyName;
		this.kyselyDesc = kyselyDesc;
	}
	
	public Kysely(int kyselyId, String kyselyName, String kyselyDesc, List<Kysymys> kysymykset) {
		this.kyselyId = kyselyId;
		this.kyselyName = kyselyName;
		this.kyselyDesc = kyselyDesc;
		this.kysymykset = kysymykset;
	}
	
	public Kysely(int kyselyId, List<Kysymys> kysymykset) {
		this.kyselyId = kyselyId;
		this.kysymykset = kysymykset;
	}

	public int getKyselyId() {
		return kyselyId;
	}

	public void setKyselyId(int kyselyId) {
		this.kyselyId = kyselyId;
	}

	public String getKyselyName() {
		return kyselyName;
	}

	public void setKyselyName(String kyselyName) {
		this.kyselyName = kyselyName;
	}

	public String getKyselyDesc() {
		return kyselyDesc;
	}

	public void setKyselyDesc(String kyselyDesc) {
		this.kyselyDesc = kyselyDesc;
	}

	@Override
	public String toString() {
		return "Kysely [kyselyId=" + kyselyId + ", kyselyName=" + kyselyName + ", kyselyDesc=" + kyselyDesc + "]";
	}
	
}
