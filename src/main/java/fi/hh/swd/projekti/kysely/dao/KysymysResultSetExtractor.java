package fi.hh.swd.projekti.kysely.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import fi.hh.swd.projekti.kysely.bean.Kysely;
import fi.hh.swd.projekti.kysely.bean.Kysymys;
import fi.hh.swd.projekti.kysely.bean.Vastaus;

public class KysymysResultSetExtractor implements ResultSetExtractor{

	public Object extractData(ResultSet rs, int rowNumber) throws SQLException, DataAccessException {
		Map<Integer,Kysely> map = new HashMap<Integer,Kysely>();
		Kysely kysely = new Kysely();
		while(rs.next()){
			Integer id =rs.getInt("kyselyId");
			kysely = map.get(id);
			if(kysely==null){
				
				int kysymysId =rs.getInt("kysymysId");
				String kysymys = rs.getString("kysymys");
				String kysymysType = rs.getString("kysymysType");
				Kysymys kysymys = new Kysymys(kysymysId, kysymysType);
			}
			
		}
		
		
		return null;
	}

}
