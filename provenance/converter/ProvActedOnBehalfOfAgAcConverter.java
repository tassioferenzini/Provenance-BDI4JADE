package converter;

import com.mongodb.DBObject;
import java.util.HashMap;
import java.util.Map;

import PROV.DM.*;

/**
 *
 * @author tassio
 */
public class ProvActedOnBehalfOfAgAcConverter {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Map converterToMap(ProvActedOnBehalfOfAgAc Obj) {
		Map mapObj = new HashMap();
		mapObj.put("Activity", Obj.getActivity());
		mapObj.put("Agent", Obj.getAgent());
		return mapObj;
	}

	public ProvActedOnBehalfOfAgAc converterToProvActedOnBehalfOfAgAc(DBObject dbo) {
		ProvActedOnBehalfOfAgAc Obj = new ProvActedOnBehalfOfAgAc();
		Obj.setId(dbo.get("_id").toString());
		Obj.setActivity((ProvActivity) dbo.get("Activity"));
		Obj.setAgent((ProvAgent)(dbo.get("Agent")));
		return Obj;
	}

}
