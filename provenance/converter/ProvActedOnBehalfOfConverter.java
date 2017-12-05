package converter;

import com.mongodb.DBObject;
import java.util.HashMap;
import java.util.Map;

import PROV.DM.*;

/**
 *
 * @author tassio
 */
public class ProvActedOnBehalfOfConverter {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Map converterToMap(ProvActedOnBehalfOf Obj) {
		Map mapObj = new HashMap();
		mapObj.put("Activity", Obj.getActivity());
		mapObj.put("Agent1", Obj.getAgent());
		mapObj.put("Agent2", Obj.getAgent1());
		return mapObj;
	}

	public ProvActedOnBehalfOf converterToProvActedOnBehalfOf(DBObject dbo) {
		ProvActedOnBehalfOf Obj = new ProvActedOnBehalfOf();
		Obj.setId(dbo.get("_id").toString());
		Obj.setActivity((ProvActivity)(dbo.get("Activity")));
		Obj.setAgent((ProvAgent)(dbo.get("Agent1")));
		Obj.setAgent1((ProvAgent)(dbo.get("Agent2")));
		return Obj;
	}

}
