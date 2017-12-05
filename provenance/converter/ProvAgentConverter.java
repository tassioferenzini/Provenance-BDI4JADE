package converter;

import com.mongodb.DBObject;
import java.util.HashMap;
import java.util.Map;
import PROV.DM.*;

/**
 *
 * @author tassio
 */
public class ProvAgentConverter {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Map converterToMap(ProvAgent Obj) {
		Map mapObj = new HashMap();
		mapObj.put("typeAgent", Obj.getTypeAgent());
		mapObj.put("nameAgent", Obj.getNameAgent());
		return mapObj;
	}

	public ProvAgent converterToProvAgent(DBObject dbo) {
		ProvAgent Obj = new ProvAgent();
		Obj.setId(dbo.get("_id").toString());
		Obj.setTypeAgent(dbo.get("typeAgent").toString());
		Obj.setNameAgent(dbo.get("nameAgent").toString());
		return Obj;
	}

}
