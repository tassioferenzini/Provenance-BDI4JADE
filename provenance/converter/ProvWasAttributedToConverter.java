package converter;

import com.mongodb.DBObject;
import java.util.HashMap;
import java.util.Map;
import PROV.DM.*;

/**
 *
 * @author tassio
 */
public class ProvWasAttributedToConverter {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Map converterToMap(ProvWasAttributedTo Obj) {
		Map mapObj = new HashMap();
		mapObj.put("entity", Obj.getEntity().toString());
		mapObj.put("agent", Obj.getAgent().toString());
		return mapObj;
	}

	public ProvWasAttributedTo converterToProvWasAttributedTo(DBObject dbo) {
		ProvWasAttributedTo Obj = new ProvWasAttributedTo();
		Obj.setId(dbo.get("_id").toString());
		Obj.setEntity((ProvEntity) dbo.get("entity"));
		Obj.setAgent((ProvAgent) dbo.get("agent"));
		return Obj;
	}

}
