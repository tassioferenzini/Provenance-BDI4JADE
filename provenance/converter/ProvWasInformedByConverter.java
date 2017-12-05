package converter;

import com.mongodb.DBObject;
import java.util.HashMap;
import java.util.Map;
import PROV.DM.*;

/**
 *
 * @author tassio
 */
public class ProvWasInformedByConverter {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Map converterToMap(ProvWasInformedBy Obj) {
		Map mapObj = new HashMap();
		mapObj.put("activity1", Obj.getActivity());
		mapObj.put("activity2", Obj.getActivity1());
		return mapObj;
	}

	public ProvWasInformedBy converterToProvWasInformedBy(DBObject dbo) {
		ProvWasInformedBy Obj = new ProvWasInformedBy();
		Obj.setId(dbo.get("_id").toString());
		Obj.setActivity((ProvActivity) dbo.get("activity1"));
		Obj.setActivity1((ProvActivity) dbo.get("activity2"));
		return Obj;
	}

}
