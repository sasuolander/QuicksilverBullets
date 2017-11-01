package fi.hh.swd.projekti.kysely.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import fi.hh.swd.projekti.kysely.bean.Kysely;


public class KyselyRowMapper implements RowMapper<Kysely> {

	public Kysely mapRow(ResultSet rs, int rowNum) throws SQLException {
		Kysely kysely = new Kysely();
		kysely.setKyselyId(rs.getInt("kyselyId"));
		kysely.setKyselyName(rs.getString("kyselyName"));
		kysely.setKyselyDesc(rs.getString("kyselyDesc"));
		
		return kysely;
	}

}