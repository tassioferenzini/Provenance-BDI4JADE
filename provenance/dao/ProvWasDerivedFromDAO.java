package dao;

import com.mongodb.DBObject;
import converter.ProvWasDerivedFromConverter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import PROV.DM.*;

/**
 *
 * @author tassio
 */
public class ProvWasDerivedFromDAO extends EntityIDao {

	public ProvWasDerivedFromDAO() {
		super(ProvWasDerivedFrom.class);
	}

	@SuppressWarnings("rawtypes")
	public void save(ProvWasDerivedFrom obj) {
		Map mapProvWasDerivedFrom = new ProvWasDerivedFromConverter().converterToMap(obj);
		save(mapProvWasDerivedFrom);
	}

	@SuppressWarnings("rawtypes")
	public void update(ProvWasDerivedFrom oldObj, ProvWasDerivedFrom newObj) {
		Map query = new ProvWasDerivedFromConverter().converterToMap(oldObj);
		Map map = new ProvWasDerivedFromConverter().converterToMap(newObj);
		update(query, map);
	}

	@SuppressWarnings("rawtypes")
	public void delete(ProvWasDerivedFrom obj) {
		Map map = new ProvWasDerivedFromConverter().converterToMap(obj);
		delete(map);
	}

	@SuppressWarnings("rawtypes")
	public ProvWasDerivedFrom findobj(Map mapKeyValue) {
		DBObject dbObject = findOne(mapKeyValue);
		if (dbObject == null) {
			return null;
		}
		ProvWasDerivedFrom ProvWasDerivedFrom = new ProvWasDerivedFromConverter().converterToProvWasDerivedFrom(dbObject);
		return ProvWasDerivedFrom;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List findProvWasDerivedFrom() {
		List dbObject = findAll();
		List ProvWasDerivedFrom = new ArrayList();
		for (Object dbo : dbObject) {
			ProvWasDerivedFrom obj = new ProvWasDerivedFromConverter().converterToProvWasDerivedFrom((DBObject) dbo);
			ProvWasDerivedFrom.add(obj);
		}
		return ProvWasDerivedFrom;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List findProvWasDerivedFrom(Map mapKeyValue) {
		List dbObject = findKeyValue(mapKeyValue);
		List ProvWasDerivedFrom = new ArrayList();
		for (Object dbo : dbObject) {
			ProvWasDerivedFrom obj = new ProvWasDerivedFromConverter().converterToProvWasDerivedFrom((DBObject) dbo);
			ProvWasDerivedFrom.add(obj);
		}
		return ProvWasDerivedFrom;
	}

}