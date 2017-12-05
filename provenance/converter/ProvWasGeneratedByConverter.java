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
public class ProvWasGeneratedByConverter {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Map converterToMap(ProvWasGeneratedBy Obj) {
		Map mapObj = new HashMap();
		mapObj.put("timeWasGeneratedBy", Obj.getTimeWasGeneratedBy());
		mapObj.put("activity", Obj.getActivity());
		mapObj.put("entity", Obj.getEntity());
		return mapObj;
	}

	public ProvWasGeneratedBy converterToProvWasGeneratedBy(DBObject dbo) {
		ProvWasGeneratedBy Obj = new ProvWasGeneratedBy();
		Obj.setId(dbo.get("_id").toString());
		Obj.setTimeWasGeneratedBy((Date) dbo.get("timeWasGeneratedBy"));
		Obj.setActivity((ProvActivity) dbo.get("activity"));
		Obj.setEntity((ProvEntity) dbo.get("entity"));
		return Obj;
	}

}
