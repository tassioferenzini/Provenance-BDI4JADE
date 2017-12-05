package converter;

import com.mongodb.DBObject;
import java.util.HashMap;
import java.util.Map;
import PROV.DM.*;

/**
 *
 * @author tassio
 */
public class ProvHadMemberConverter {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Map converterToMap(ProvHadMember Obj) {
		Map mapObj = new HashMap();
		mapObj.put("collection", Obj.getCollection());
		mapObj.put("entity", Obj.getEntity());
		return mapObj;
	}

	public ProvHadMember converterToProvHadMember(DBObject dbo) {
		ProvHadMember Obj = new ProvHadMember();
		Obj.setId(dbo.get("_id").toString());
		Obj.setCollection(dbo.get("collection").toString());
		Obj.setEntity((ProvEntity)dbo.get("entity"));
		return Obj;
	}

}
