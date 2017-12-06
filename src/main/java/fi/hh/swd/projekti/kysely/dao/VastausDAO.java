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

import fi.hh.swd.projekti.kysely.bean.Kysymys;
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

	public void vastausSave(final int kysymysId,Vastaus vastaus) {
		final String sql = "INSERT INTO vastaus (vastaus, kysymysId) values(?,?)";
		final String vastauss = vastaus.getVastaus();
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
	public List<Kysymys> vastausGetAll( int kysymysId) {
		String sql = "SELECT vastausId, vastaus, kysymysId FROM vastaus WHERE kysymysId = ?";
		Object [] parametrit = new Object [] {kysymysId};
		VastausResultSetExtractor mapper = new VastausResultSetExtractor();
		List<Kysymys> vastaukset = jdbcTemplate.query(sql, parametrit, mapper);
		return vastaukset;
	}
	
	
	public List<Vastaus> vastausGetAllObject( ) {
		String sql = "SELECT vastausId, vastaus FROM vastaus";
		VastausObjectRowMapper mapper = new VastausObjectRowMapper();
		List<Vastaus> vastaukset = jdbcTemplate.query(sql, mapper);
		return vastaukset;
	}
	
	
	
	public Kysymys vastausGetOne( int vastausId ) {
		String sql = "	SELECT vastausId, vastaus, kysymysId FROM vastaus WHERE vastausId = ?";
		Object[] parametrit = new Object[] { vastausId };
		RowMapper<Kysymys> mapper = new VastausRowMapper();
		Kysymys vastaus = jdbcTemplate.queryForObject(sql, parametrit, mapper);
		return vastaus;
	}
	
	
	
}