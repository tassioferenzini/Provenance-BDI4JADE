package converter;

import com.mongodb.DBObject;
import java.util.HashMap;
import java.util.Map;
import PROV.DM.*;

/**
 *
 * @author tassio
 */
public class ProvWasDerivedFromEAConverter {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Map converterToMap(ProvWasDerivedFromEA Obj) {
		Map mapObj = new HashMap();
		mapObj.put("activity", Obj.getActivity());
		mapObj.put("entity", Obj.getEntity());
		return mapObj;
	}

	public ProvWasDerivedFromEA converterToProvWasDerivedFromEA(DBObject dbo) {
		ProvWasDerivedFromEA Obj = new ProvWasDerivedFromEA();
		Obj.setId(dbo.get("_id").toString());
		Obj.setActivity((ProvActivity) dbo.get("activity"));
		Obj.setEntity((ProvEntity) dbo.get("entity"));
		return Obj;
	}

}
