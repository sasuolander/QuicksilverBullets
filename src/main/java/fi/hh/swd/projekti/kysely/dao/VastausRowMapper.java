package fi.hh.swd.projekti.kysely.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import fi.hh.swd.projekti.kysely.bean.Vastaus;


public class VastausRowMapper implements RowMapper<Vastaus> {

	public Vastaus mapRow(ResultSet rs, int rowNum) throws SQLException {
		Vastaus vastaus = new Vastaus();
		vastaus.setVastausId(rs.getInt("vastausid"));//muutin vastausid koska taulussa vastausid ei Id :)
		vastaus.setVastaus(rs.getString("vastaus"));
		vastaus.setKysymysId(rs.getInt("kysymysId"));
		
		return vastaus;
	}

}