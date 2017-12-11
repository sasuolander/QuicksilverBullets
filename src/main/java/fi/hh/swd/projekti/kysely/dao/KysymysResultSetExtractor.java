package fi.hh.swd.projekti.kysely.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
		List<Kysymys> kysymykset = new ArrayList<Kysymys>();
		while(rs.next()){
			Integer id =rs.getInt("kyselyId");
			kysely = map.get(id);
			if(kysely==null){
				kysely = new Kysely();
				int id2 =rs.getInt("kyselyId");
				String name2 = rs.getString("kyselyName");
				String desc2 = rs.getString("kyselyDesc");
				kysely.setKyselyId(id2);
				kysely.setKyselyName(name2);
				kysely.setKyselyDesc(desc2);
				map.put(id,kysely);
			}
			kysely.setKysymykset(kysymykset);
			Kysymys kysymys = new Kysymys(rs.getInt("kysymysId"),
							rs.getString("kysymys"), rs.getString("kysymysType"));
			kysely.lisaa(kysymys);
		}
		return new ArrayList<Kysely>(map.values());
	}
}
