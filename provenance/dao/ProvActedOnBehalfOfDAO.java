package dao;

import com.mongodb.DBObject;
import converter.ProvActedOnBehalfOfConverter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import PROV.DM.*;

/**
 *
 * @author tassio
 */
public class ProvActedOnBehalfOfDAO extends EntityIDao {

	public ProvActedOnBehalfOfDAO() {
		super(ProvActedOnBehalfOf.class);
	}

	@SuppressWarnings("rawtypes")
	public void save(ProvActedOnBehalfOf obj) {
		Map mapProvActedOnBehalfOf = new ProvActedOnBehalfOfConverter().converterToMap(obj);
		save(mapProvActedOnBehalfOf);
	}

	@SuppressWarnings("rawtypes")
	public void update(ProvActedOnBehalfOf oldObj, ProvActedOnBehalfOf newObj) {
		Map query = new ProvActedOnBehalfOfConverter().converterToMap(oldObj);
		Map map = new ProvActedOnBehalfOfConverter().converterToMap(newObj);
		update(query, map);
	}

	@SuppressWarnings("rawtypes")
	public void delete(ProvActedOnBehalfOf obj) {
		Map map = new ProvActedOnBehalfOfConverter().converterToMap(obj);
		delete(map);
	}

	@SuppressWarnings("rawtypes")
	public ProvActedOnBehalfOf findobj(Map mapKeyValue) {
		DBObject dbObject = findOne(mapKeyValue);
		if (dbObject == null) {
			return null;
		}
		ProvActedOnBehalfOf ProvActedOnBehalfOf = new ProvActedOnBehalfOfConverter().converterToProvActedOnBehalfOf(dbObject);
		return ProvActedOnBehalfOf;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List findProvActedOnBehalfOf() {
		List dbObject = findAll();
		List ProvActedOnBehalfOf = new ArrayList();
		for (Object dbo : dbObject) {
			ProvActedOnBehalfOf obj = new ProvActedOnBehalfOfConverter().converterToProvActedOnBehalfOf((DBObject) dbo);
			ProvActedOnBehalfOf.add(obj);
		}
		return ProvActedOnBehalfOf;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List findProvActedOnBehalfOf(Map mapKeyValue) {
		List dbObject = findKeyValue(mapKeyValue);
		List ProvActedOnBehalfOf = new ArrayList();
		for (Object dbo : dbObject) {
			ProvActedOnBehalfOf obj = new ProvActedOnBehalfOfConverter().converterToProvActedOnBehalfOf((DBObject) dbo);
			ProvActedOnBehalfOf.add(obj);
		}
		return ProvActedOnBehalfOf;
	}

}