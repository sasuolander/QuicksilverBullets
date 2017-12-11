package fi.hh.swd.projekti.kysely.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import fi.hh.swd.projekti.kysely.bean.Kysymys;
import fi.hh.swd.projekti.kysely.bean.Vastaus;

public class VastausResultSetExtractor implements ResultSetExtractor{
	public Object extractData(ResultSet rs) throws SQLException, DataAccessException {
		Map<Integer,Kysymys> map = new HashMap<Integer,Kysymys>();
		Kysymys kysymys = null;
		List<Vastaus> vastaukset = new ArrayList<Vastaus>();
		while(rs.next()){
			Integer id =rs.getInt("kysymysId");
			kysymys = map.get(id);
			if(kysymys==null){
				kysymys = new Kysymys();
				kysymys.setKysymysId(rs.getInt("kysymysId"));
				map.put(id, kysymys);
			}
			kysymys.setVastaukset(vastaukset);
			Vastaus vastaus = new Vastaus(rs.getInt("vastausId"), rs.getString("vastaus"));

			 kysymys.lisaa(vastaus);
		}
		return new ArrayList<Kysymys>(map.values());
	}
}