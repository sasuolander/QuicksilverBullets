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

import fi.hh.swd.projekti.kysely.bean.Vastaus;

@Repository
public class VastausDAO {

	@Inject
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

public void vastausSave(Vastaus vastaus) {
		final String sql = "INSERT INTO vastaus (vastaus, kysymysId) values(?,?)";
		final String vastauss = vastaus.getVastaus();
		final int kysymysId = vastaus.getKysymysId();
		KeyHolder idHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(new PreparedStatementCreator() {
			public PreparedStatement createPreparedStatement(
					Connection connection) throws SQLException {
				PreparedStatement ps = connection.prepareStatement(sql,
						new String[] { "vastausId" });
				ps.setString(1, vastauss);
				ps.setInt(2, kysymysId);
				return ps;
			}
		}, idHolder);
		vastaus.setVastausId(idHolder.getKey().intValue());
	}

	//Tätä muutan(poistin id parametrin, muutin sql lausetta)
	public List<Vastaus> vastausGetAll() {
		String sql = "SELECT vastausId, vastaus, kysymysId FROM vastaus";// WHERE kysymysId = ?";
		RowMapper<Vastaus> mapper = new VastausRowMapper();
		List<Vastaus> vastaukset = jdbcTemplate.query(sql, mapper);
		return vastaukset;
	}
	
	public Vastaus vastausGetOne( int vastausId ) {
		String sql = "SELECT vastausId, vastaus, kysymysId FROM vastaus WHERE vastausId = ?";
		Object[] parametrit = new Object[] { vastausId };
		RowMapper<Vastaus> mapper = new VastausRowMapper();
		Vastaus vastaus = jdbcTemplate.queryForObject(sql, parametrit, mapper);
		return vastaus;
	}

}
