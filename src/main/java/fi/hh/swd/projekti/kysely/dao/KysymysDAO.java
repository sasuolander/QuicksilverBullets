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

@Repository
public class KysymysDAO {

	@Inject
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

public void kysymysSave(Kysymys kysymys) {
		final String sql = "INSERT INTO kysymys (kysymys, kyselyId) values(?,?)";
		final String kysymyss = kysymys.getKysymys();
		final int kyselyId = kysymys.getKyselyId();
		KeyHolder idHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(new PreparedStatementCreator() {
			public PreparedStatement createPreparedStatement(
					Connection connection) throws SQLException {
				PreparedStatement ps = connection.prepareStatement(sql,
						new String[] { "kysymysId" });
				ps.setString(1, kysymyss);
				ps.setInt(2, kyselyId);
				return ps;
			}
		}, idHolder);
		kysymys.setKysymysId(idHolder.getKey().intValue());
	}

	//Tätä muokkaan (poistin id parametrin, muutin sql lausetta)
	public List<Kysymys> kysymysGetAll() {
		String sql = "SELECT kysymysid, kysymys, kyselyId FROM kysymys";// WHERE kyselyId = ?;
		RowMapper<Kysymys> mapper = new KysymysRowMapper();
		List<Kysymys> kysymykset = jdbcTemplate.query(sql, mapper);
		return kysymykset;
	}
	
	public Kysymys kysymysGetOne( int kysymysId ) {
		String sql = "SELECT kysymysId, kysymys, kyselyId FROM kysymys WHERE kysymysId = ?";
		Object[] parametrit = new Object[] { kysymysId };
		RowMapper<Kysymys> mapper = new KysymysRowMapper();
		Kysymys kysymys = jdbcTemplate.queryForObject(sql, parametrit, mapper);
		return kysymys;
	}

}