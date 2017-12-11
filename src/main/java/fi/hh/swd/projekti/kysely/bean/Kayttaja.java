package fi.hh.swd.projekti.kysely.bean;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

public class Kayttaja {
	private int kayttajaId;
	private String kayttajaName;
	private String kayttajaPassword;
	private String kayttajaRole;
	
	public Kayttaja() {
		kayttajaId = 0;
		kayttajaName = null;
		kayttajaPassword = null;
		kayttajaRole = null;
	}
	
	public Kayttaja( int kayttajaId, String kayttajaName, String kayttajaPassword, String kayttajaRole ) {
		this.kayttajaId = kayttajaId;
		this.kayttajaName = kayttajaName;
		this.kayttajaPassword = kayttajaPassword;
		this.kayttajaRole = kayttajaRole;
	}

	public int getKayttajaId() {
		return kayttajaId;
	}

	public void setKayttajaId(int kayttajaId) {
		this.kayttajaId = kayttajaId;
	}

	public String getKayttajaName() {
		return kayttajaName;
	}

	public void setKayttajaName(String kayttajaName) {
		this.kayttajaName = kayttajaName;
	}

	public String getKayttajaPassword() {
		return kayttajaPassword;
	}

	public void setKayttajaPassword(String kayttajaPassword) {
		this.kayttajaPassword = kayttajaPassword;
	}

	public String getKayttajaRole() {
		return kayttajaRole;
	}

	public void setKayttajaRole(String kayttajaRole) {
		this.kayttajaRole = kayttajaRole;
	}

	@Override
	public String toString() {
		return "Kayttaja [kayttajaId=" + kayttajaId + ", kayttajaName=" + kayttajaName + ", kayttajaPassword="
				+ kayttajaPassword + ", kayttajaRole=" + kayttajaRole + "]";
	}
	
}
