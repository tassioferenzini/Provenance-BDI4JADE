package dao;

import com.mongodb.DBObject;
import converter.ProvWasEndedByConverter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import PROV.DM.*;

/**
 *
 * @author tassio
 */
public class ProvWasEndedByDAO extends EntityIDao {

	public ProvWasEndedByDAO() {
		super(ProvWasEndedBy.class);
	}

	@SuppressWarnings("rawtypes")
	public void save(ProvWasEndedBy obj) {
		Map mapProvWasEndedBy = new ProvWasEndedByConverter().converterToMap(obj);
		save(mapProvWasEndedBy);
	}

	@SuppressWarnings("rawtypes")
	public void update(ProvWasEndedBy oldObj, ProvWasEndedBy newObj) {
		Map query = new ProvWasEndedByConverter().converterToMap(oldObj);
		Map map = new ProvWasEndedByConverter().converterToMap(newObj);
		update(query, map);
	}

	@SuppressWarnings("rawtypes")
	public void delete(ProvWasEndedBy obj) {
		Map map = new ProvWasEndedByConverter().converterToMap(obj);
		delete(map);
	}

	@SuppressWarnings("rawtypes")
	public ProvWasEndedBy findobj(Map mapKeyValue) {
		DBObject dbObject = findOne(mapKeyValue);
		if (dbObject == null) {
			return null;
		}
		ProvWasEndedBy ProvWasEndedBy = new ProvWasEndedByConverter().converterToProvWasEndedBy(dbObject);
		return ProvWasEndedBy;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List findProvWasEndedBy() {
		List dbObject = findAll();
		List ProvWasEndedBy = new ArrayList();
		for (Object dbo : dbObject) {
			ProvWasEndedBy obj = new ProvWasEndedByConverter().converterToProvWasEndedBy((DBObject) dbo);
			ProvWasEndedBy.add(obj);
		}
		return ProvWasEndedBy;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List findProvWasEndedBy(Map mapKeyValue) {
		List dbObject = findKeyValue(mapKeyValue);
		List ProvWasEndedBy = new ArrayList();
		for (Object dbo : dbObject) {
			ProvWasEndedBy obj = new ProvWasEndedByConverter().converterToProvWasEndedBy((DBObject) dbo);
			ProvWasEndedBy.add(obj);
		}
		return ProvWasEndedBy;
	}

}