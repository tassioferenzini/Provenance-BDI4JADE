package dao;

import com.mongodb.DBObject;
import converter.ProvWasEndedByAAConverter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import PROV.DM.*;

/**
 *
 * @author tassio
 */
public class ProvWasEndedByAADAO extends EntityIDao {

	public ProvWasEndedByAADAO() {
		super(ProvWasEndedByAA.class);
	}

	@SuppressWarnings("rawtypes")
	public void save(ProvWasEndedByAA obj) {
		Map mapProvWasEndedByAA = new ProvWasEndedByAAConverter().converterToMap(obj);
		save(mapProvWasEndedByAA);
	}

	@SuppressWarnings("rawtypes")
	public void update(ProvWasEndedByAA oldObj, ProvWasEndedByAA newObj) {
		Map query = new ProvWasEndedByAAConverter().converterToMap(oldObj);
		Map map = new ProvWasEndedByAAConverter().converterToMap(newObj);
		update(query, map);
	}

	@SuppressWarnings("rawtypes")
	public void delete(ProvWasEndedByAA obj) {
		Map map = new ProvWasEndedByAAConverter().converterToMap(obj);
		delete(map);
	}

	@SuppressWarnings("rawtypes")
	public ProvWasEndedByAA findobj(Map mapKeyValue) {
		DBObject dbObject = findOne(mapKeyValue);
		if (dbObject == null) {
			return null;
		}
		ProvWasEndedByAA ProvWasEndedByAA = new ProvWasEndedByAAConverter().converterToProvWasEndedByAA(dbObject);
		return ProvWasEndedByAA;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List findProvWasEndedByAA() {
		List dbObject = findAll();
		List ProvWasEndedByAA = new ArrayList();
		for (Object dbo : dbObject) {
			ProvWasEndedByAA obj = new ProvWasEndedByAAConverter().converterToProvWasEndedByAA((DBObject) dbo);
			ProvWasEndedByAA.add(obj);
		}
		return ProvWasEndedByAA;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List findProvWasEndedByAA(Map mapKeyValue) {
		List dbObject = findKeyValue(mapKeyValue);
		List ProvWasEndedByAA = new ArrayList();
		for (Object dbo : dbObject) {
			ProvWasEndedByAA obj = new ProvWasEndedByAAConverter().converterToProvWasEndedByAA((DBObject) dbo);
			ProvWasEndedByAA.add(obj);
		}
		return ProvWasEndedByAA;
	}

}