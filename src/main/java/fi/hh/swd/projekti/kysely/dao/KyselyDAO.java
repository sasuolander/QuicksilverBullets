package fi.hh.swd.projekti.kysely.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.inject.Inject;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import fi.hh.swd.projekti.kysely.bean.Kysely;

@Repository
public class KyselyDAO {

	@Inject
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

public void kyselySave(Kysely kysely) {
		final String sql = "INSERT INTO kysely (kyselyName, kyselyDesc) values(?,?)";
		final String kyselyName = kysely.getKyselyName();
		final String kyselyDesc = kysely.getKyselyDesc();
		KeyHolder idHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(new PreparedStatementCreator() {
			public PreparedStatement createPreparedStatement(
					Connection connection) throws SQLException {
				PreparedStatement ps = connection.prepareStatement(sql,
						new String[] { "kyselyId" });
				ps.setString(1, kyselyName);
				ps.setString(2, kyselyDesc);
				return ps;
			}
		}, idHolder);
		kysely.setKyselyId(idHolder.getKey().intValue());
	}

	public List<Kysely> kyselyGetAll() {
		String sql = "SELECT kyselyId, kyselyName, kyselyDesc FROM kysely";
		RowMapper<Kysely> mapper = new KyselyRowMapper();
		List<Kysely> kyselyt = jdbcTemplate.query(sql, mapper);
		return kyselyt;
	}
}

