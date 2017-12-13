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
import fi.hh.swd.projekti.kysely.bean.Valinta;

public class ValintaResultSetExtractor implements ResultSetExtractor {
	public Object extractData(ResultSet rs) throws SQLException, DataAccessException {
		Map<Integer,Kysymys> map = new HashMap<Integer,Kysymys>();
		Kysymys kysymys = null;
		List<Valinta> valinnat = new ArrayList<Valinta>();
		while(rs.next()){
			Integer id =rs.getInt("kysymysId");
			kysymys = map.get(id);
			if(kysymys==null){
				kysymys = new Kysymys();
				kysymys.setKysymysId(rs.getInt("kysymysId"));
				map.put(id, kysymys);
			}
			kysymys.setValinnat(valinnat);
			Valinta valinta = new Valinta(rs.getInt("valintaId"), rs.getString("valintaName"));

			 kysymys.lisaa(valinta);
		}
		return new ArrayList<Kysymys>(map.values());
	}
}