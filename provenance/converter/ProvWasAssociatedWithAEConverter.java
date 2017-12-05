package converter;

import com.mongodb.DBObject;
import java.util.HashMap;
import java.util.Map;
import PROV.DM.*;

/**
 *
 * @author tassio
 */
public class ProvWasAssociatedWithAEConverter {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Map converterToMap(ProvWasAssociatedWithAE Obj) {
		Map mapObj = new HashMap();
		mapObj.put("activity", Obj.getActivity());
		mapObj.put("entity", Obj.getEntity());
		return mapObj;
	}

	public ProvWasAssociatedWithAE converterToProvWasAssociatedWithAE(DBObject dbo) {
		ProvWasAssociatedWithAE Obj = new ProvWasAssociatedWithAE();
		Obj.setId(dbo.get("_id").toString());
		Obj.setActivity((ProvActivity) dbo.get("activity"));
		Obj.setEntity((ProvEntity) dbo.get("entity"));
		return Obj;
	}

}
