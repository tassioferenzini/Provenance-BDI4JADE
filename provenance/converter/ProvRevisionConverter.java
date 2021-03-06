package converter;

import com.mongodb.DBObject;
import java.util.HashMap;
import java.util.Map;
import PROV.DM.*;

/**
 *
 * @author tassio
 */
public class ProvRevisionConverter {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Map converterToMap(ProvRevision Obj) {
		Map mapObj = new HashMap();
		mapObj.put("type", Obj.getType());
		mapObj.put("entity1", Obj.getEntity());
		mapObj.put("entity2", Obj.getEntity1());
		return mapObj;
	}

	public ProvRevision converterToProvRevision(DBObject dbo) {
		ProvRevision Obj = new ProvRevision();
		Obj.setId(dbo.get("_id").toString());
		Obj.setType(dbo.get("type").toString());
		Obj.setEntity((ProvEntity) dbo.get("entity1"));
		Obj.setEntity1((ProvEntity) dbo.get("entity2"));
		return Obj;
	}

}
