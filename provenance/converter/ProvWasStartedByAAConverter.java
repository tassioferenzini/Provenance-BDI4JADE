package converter;

import com.mongodb.DBObject;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import PROV.DM.*;

/**
 *
 * @author tassio
 */
public class ProvWasStartedByAAConverter {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Map converterToMap(ProvWasStartedByAA Obj) {
		Map mapObj = new HashMap();
		mapObj.put("time", Obj.getTime());
		mapObj.put("activity1", Obj.getActivity().toString());
		mapObj.put("activity2", Obj.getActivity1().toString());
		mapObj.put("entity", Obj.getEntity().toString());
		return mapObj;
	}

	public ProvWasStartedByAA converterToProvWasStartedByAA(DBObject dbo) {
		ProvWasStartedByAA Obj = new ProvWasStartedByAA();
		Obj.setId(dbo.get("_id").toString());
		Obj.setTime((Date)dbo.get("time"));
		Obj.setActivity((ProvActivity) dbo.get("activity1"));
		Obj.setActivity1((ProvActivity)dbo.get("activity2"));
		Obj.setEntity((ProvEntity)dbo.get("entity2"));
		return Obj;
	}

}
