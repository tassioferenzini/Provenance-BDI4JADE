package dao;

import com.mongodb.DBObject;
import converter.ProvWasStartedByAAConverter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import PROV.DM.*;

/**
 *
 * @author tassio
 */
public class ProvWasStartedByAADAO extends EntityIDao {

	public ProvWasStartedByAADAO() {
		super(ProvWasStartedByAA.class);
	}

	@SuppressWarnings("rawtypes")
	public void save(ProvWasStartedByAA obj) {
		Map mapProvWasStartedByAA = new ProvWasStartedByAAConverter().converterToMap(obj);
		save(mapProvWasStartedByAA);
	}

	@SuppressWarnings("rawtypes")
	public void update(ProvWasStartedByAA oldObj, ProvWasStartedByAA newObj) {
		Map query = new ProvWasStartedByAAConverter().converterToMap(oldObj);
		Map map = new ProvWasStartedByAAConverter().converterToMap(newObj);
		update(query, map);
	}

	@SuppressWarnings("rawtypes")
	public void delete(ProvWasStartedByAA obj) {
		Map map = new ProvWasStartedByAAConverter().converterToMap(obj);
		delete(map);
	}

	@SuppressWarnings("rawtypes")
	public ProvWasStartedByAA findobj(Map mapKeyValue) {
		DBObject dbObject = findOne(mapKeyValue);
		if (dbObject == null) {
			return null;
		}
		ProvWasStartedByAA ProvWasStartedByAA = new ProvWasStartedByAAConverter().converterToProvWasStartedByAA(dbObject);
		return ProvWasStartedByAA;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List findProvWasStartedByAA() {
		List dbObject = findAll();
		List ProvWasStartedByAA = new ArrayList();
		for (Object dbo : dbObject) {
			ProvWasStartedByAA obj = new ProvWasStartedByAAConverter().converterToProvWasStartedByAA((DBObject) dbo);
			ProvWasStartedByAA.add(obj);
		}
		return ProvWasStartedByAA;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List findProvWasStartedByAA(Map mapKeyValue) {
		List dbObject = findKeyValue(mapKeyValue);
		List ProvWasStartedByAA = new ArrayList();
		for (Object dbo : dbObject) {
			ProvWasStartedByAA obj = new ProvWasStartedByAAConverter().converterToProvWasStartedByAA((DBObject) dbo);
			ProvWasStartedByAA.add(obj);
		}
		return ProvWasStartedByAA;
	}

}