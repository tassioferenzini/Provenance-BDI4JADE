package converter;

import com.mongodb.DBObject;
import java.util.HashMap;
import java.util.Map;
import PROV.DM.*;

/**
 *
 * @author tassio
 */
public class ProvEntityConverter {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Map converterToMap(ProvEntity Obj) {
		Map mapObj = new HashMap();
		mapObj.put("nameEntity", Obj.getNameEntity());
		return mapObj;
	}

	public ProvEntity converterToProvEntity(DBObject dbo) {
		ProvEntity Obj = new ProvEntity();
		Obj.setId(dbo.get("_id").toString());
		Obj.setNameEntity(dbo.get("nameEntity").toString());
		return Obj;
	}

}
