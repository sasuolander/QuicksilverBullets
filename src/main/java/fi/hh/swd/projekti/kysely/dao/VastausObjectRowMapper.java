package fi.hh.swd.projekti.kysely.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;

import fi.hh.swd.projekti.kysely.bean.Kysymys;
import fi.hh.swd.projekti.kysely.bean.Vastaus;

public class VastausObjectRowMapper implements RowMapper<Vastaus> {

	public Vastaus mapRow(ResultSet rs, int rowNum) throws SQLException {
		Vastaus vastaus = new Vastaus();
		//List<Vastaus> vastaukset= new ArrayList<Vastaus>();
		vastaus.setVastausId(rs.getInt("vastausId"));
		vastaus.setVastaus(rs.getString("vastaus"));
		return vastaus;
	}

}