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
public class ProvWasEndedByConverter {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Map converterToMap(ProvWasEndedBy Obj) {
		Map mapObj = new HashMap();
		mapObj.put("time", Obj.getTime());
		mapObj.put("activity", Obj.getActivity());
		mapObj.put("entity1", Obj.getEntity());
		mapObj.put("entity2", Obj.getEntity1());
		return mapObj;
	}

	public ProvWasEndedBy converterToProvWasEndedBy(DBObject dbo) {
		ProvWasEndedBy Obj = new ProvWasEndedBy();
		Obj.setId(dbo.get("_id").toString());
		Obj.setTime((Date)dbo.get("time"));
		Obj.setActivity((ProvActivity) dbo.get("activity"));
		Obj.setEntity((ProvEntity) dbo.get("entity1"));
		Obj.setEntity1((ProvEntity) dbo.get("entity2"));
		return Obj;
	}

}
