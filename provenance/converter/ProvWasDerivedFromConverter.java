package converter;

import com.mongodb.DBObject;
import java.util.HashMap;
import java.util.Map;
import PROV.DM.*;

/**
 *
 * @author tassio
 */
public class ProvWasDerivedFromConverter {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Map converterToMap(ProvWasDerivedFrom Obj) {
		Map mapObj = new HashMap();
		mapObj.put("generation", Obj.getGeneration());
		mapObj.put("usage", Obj.getUsage());
		mapObj.put("activity", Obj.getActivity());
		mapObj.put("generatedEntity", Obj.getGeneratedEntity());
		mapObj.put("usedEntity", Obj.getUsedEntity());
		return mapObj;
	}

	public ProvWasDerivedFrom converterToProvWasDerivedFrom(DBObject dbo) {
		ProvWasDerivedFrom Obj = new ProvWasDerivedFrom();
		Obj.setId(dbo.get("_id").toString());
		Obj.setUsage(dbo.get("usage").toString());
		Obj.setGeneration(dbo.get("generation").toString());
		Obj.setActivity((ProvActivity) dbo.get("activity"));
		Obj.setGeneratedEntity((ProvEntity) dbo.get("generatedEntity"));
		Obj.setUsedEntity((ProvEntity) dbo.get("usedEntity"));
		return Obj;
	}

}
