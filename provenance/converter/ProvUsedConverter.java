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
public class ProvUsedConverter {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Map converterToMap(ProvUsed Obj) {
		Map mapObj = new HashMap();
		mapObj.put("timeUsed", Obj.getTimeUsed());
		mapObj.put("activity", Obj.getActivity());
		mapObj.put("entity", Obj.getEntity());
		return mapObj;
	}

	public ProvUsed converterToProvUsed(DBObject dbo) {
		ProvUsed Obj = new ProvUsed();
		Obj.setId(dbo.get("_id").toString());
		Obj.setTimeUsed((Date) dbo.get("timeUsed"));
		Obj.setActivity((ProvActivity) dbo.get("activity"));
		Obj.setEntity((ProvEntity) dbo.get("entity"));
		return Obj;
	}

}
