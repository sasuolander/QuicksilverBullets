package fi.hh.swd.projekti.kysely.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;

import fi.hh.swd.projekti.kysely.bean.Kysely;
import fi.hh.swd.projekti.kysely.bean.Kysymys;


public class KysymysRowMapper implements RowMapper<Kysely> {

	public Kysely mapRow(ResultSet rs, int rowNum) throws SQLException {
		Kysymys kysymys = new Kysymys();
		List<Kysymys> kysymykset= new ArrayList<Kysymys>();
		kysymys.setKysymysId(rs.getInt("kysymysId"));
		kysymys.setKysymys(rs.getString("kysymys"));
		int kyselyID=rs.getInt("kyselyId");
		kysymykset.add(kysymys);
		Kysely kysely = new Kysely(kyselyID,kysymykset);
		return kysely;
	}

}