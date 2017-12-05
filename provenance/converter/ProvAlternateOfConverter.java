package converter;

import com.mongodb.DBObject;
import java.util.HashMap;
import java.util.Map;
import PROV.DM.*;

/**
 *
 * @author tassio
 */
public class ProvAlternateOfConverter {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Map converterToMap(ProvAlternateOf Obj) {
		Map mapObj = new HashMap();
		mapObj.put("entity1", Obj.getEntity());
		mapObj.put("entity2", Obj.getEntity1());
		return mapObj;
	}

	public ProvAlternateOf converterToProvAlternateOf(DBObject dbo) {
		ProvAlternateOf Obj = new ProvAlternateOf();
		Obj.setId(dbo.get("_id").toString());
		Obj.setEntity((ProvEntity) dbo.get("entity1"));
		Obj.setEntity1((ProvEntity) dbo.get("entity2"));
		return Obj;
	}

}
