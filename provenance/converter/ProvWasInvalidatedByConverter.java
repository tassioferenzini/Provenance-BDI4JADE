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
public class ProvWasInvalidatedByConverter {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Map converterToMap(ProvWasInvalidatedBy Obj) {
		Map mapObj = new HashMap();
		mapObj.put("time", Obj.getTime());
		mapObj.put("activity", Obj.getActivity());
		mapObj.put("entity", Obj.getEntity());
		return mapObj;
	}

	public ProvWasInvalidatedBy converterToProvWasInvalidatedBy(DBObject dbo) {
		ProvWasInvalidatedBy Obj = new ProvWasInvalidatedBy();
		Obj.setId(dbo.get("_id").toString());
		Obj.setTime((Date) dbo.get("time"));
		Obj.setActivity((ProvActivity) dbo.get("activity"));
		Obj.setEntity((ProvEntity) dbo.get("entity"));
		return Obj;
	}

}
