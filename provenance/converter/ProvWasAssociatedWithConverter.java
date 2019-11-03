package converter;

import com.mongodb.DBObject;
import java.util.HashMap;
import java.util.Map;
import PROV.DM.*;

/**
 *
 * @author tassio
 */
public class ProvWasAssociatedWithConverter {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Map converterToMap(ProvWasAssociatedWith Obj) {
		Map mapObj = new HashMap();
		mapObj.put("plan", Obj.getPlan());
		mapObj.put("activity", Obj.getActivity().toString());
		mapObj.put("agent", Obj.getAgent().toString());
		return mapObj;
	}

	public ProvWasAssociatedWith converterToProvWasAssociatedWith(DBObject dbo) {
		ProvWasAssociatedWith Obj = new ProvWasAssociatedWith();
		Obj.setId(dbo.get("_id").toString());
		Obj.setPlan(dbo.get("plan").toString());
		Obj.setActivity((ProvActivity) dbo.get("activity"));
		Obj.setAgent((ProvAgent) dbo.get("agent"));
		return Obj;
	}

}
