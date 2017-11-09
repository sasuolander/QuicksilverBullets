package fi.hh.swd.projekti.kysely.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import fi.hh.swd.projekti.kysely.bean.Kysymys;


public class KysymysRowMapper implements RowMapper<Kysymys> {

	public Kysymys mapRow(ResultSet rs, int rowNum) throws SQLException {
		Kysymys kysymys = new Kysymys();
		kysymys.setKysymysId(rs.getInt("kysymysid"));//muutin tätä koska taulussa lukee kysymysid
		kysymys.setKysymys(rs.getString("kysymys"));
		kysymys.setKyselyId(rs.getInt("kyselyId"));
		
		return kysymys;
	}

}