package fi.hh.swd.projekti.kysely.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import fi.hh.swd.projekti.kysely.bean.Kysely;
import fi.hh.swd.projekti.kysely.bean.Kysymys;
import fi.hh.swd.projekti.kysely.bean.Vastaus;

public class KysymysResultSetExtractor implements ResultSetExtractor{

	public Object extractData(ResultSet rs) throws SQLException, DataAccessException {
		Map<Integer,Kysely> map = new HashMap<Integer,Kysely>();
		Kysely kysely = null;
		while(rs.next()){
			Integer id =rs.getInt("kyselyId");
			kysely = map.get(id);
			if(kysely==null){
				int id2 =rs.getInt("kyselyId");
				kysely.setKyselyId(id2);
				map.put(id,kysely);
			}
			Kysymys kysymys = new Kysymys(rs.getInt("kysymysId"),
							rs.getString("kysymys"), rs.getString("kysymysType"));
			kysely.lisaa(kysymys);
		}
		return new ArrayList<Kysely>(map.values());
	}
}
