package fi.hh.swd.projekti.kysely.bean;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

public class Valinta {
	private int valintaId;
	private String valintaName;
	
	public Valinta() {
		valintaId = 0;
		valintaName = null;
	}
	
	public Valinta(int valintaId, String valintaName) {
		super();
		this.valintaId = valintaId;
		this.valintaName = valintaName;
	}

	public int getValintaId() {
		return valintaId;
	}

	public void setValintaId(int valintaId) {
		this.valintaId = valintaId;
	}

	public String getValintaName() {
		return valintaName;
	}

	public void setValintaName(String valintaName) {
		this.valintaName = valintaName;
	}

	@Override
	public String toString() {
		return "Valinta [valintaId=" + valintaId + ", valintaName=" + valintaName + "]";
	}
	
}
