package dao;

import com.mongodb.DBObject;
import converter.ProvWasStartedByConverter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import PROV.DM.*;

/**
 *
 * @author tassio
 */
public class ProvWasStartedByDAO extends EntityIDao {

	public ProvWasStartedByDAO() {
		super(ProvWasStartedBy.class);
	}

	@SuppressWarnings("rawtypes")
	public void save(ProvWasStartedBy obj) {
		Map mapProvWasStartedBy = new ProvWasStartedByConverter().converterToMap(obj);
		save(mapProvWasStartedBy);
	}

	@SuppressWarnings("rawtypes")
	public void update(ProvWasStartedBy oldObj, ProvWasStartedBy newObj) {
		Map query = new ProvWasStartedByConverter().converterToMap(oldObj);
		Map map = new ProvWasStartedByConverter().converterToMap(newObj);
		update(query, map);
	}

	@SuppressWarnings("rawtypes")
	public void delete(ProvWasStartedBy obj) {
		Map map = new ProvWasStartedByConverter().converterToMap(obj);
		delete(map);
	}

	@SuppressWarnings("rawtypes")
	public ProvWasStartedBy findobj(Map mapKeyValue) {
		DBObject dbObject = findOne(mapKeyValue);
		if (dbObject == null) {
			return null;
		}
		ProvWasStartedBy ProvWasStartedBy = new ProvWasStartedByConverter().converterToProvWasStartedBy(dbObject);
		return ProvWasStartedBy;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List findProvWasStartedBy() {
		List dbObject = findAll();
		List ProvWasStartedBy = new ArrayList();
		for (Object dbo : dbObject) {
			ProvWasStartedBy obj = new ProvWasStartedByConverter().converterToProvWasStartedBy((DBObject) dbo);
			ProvWasStartedBy.add(obj);
		}
		return ProvWasStartedBy;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List findProvWasStartedBy(Map mapKeyValue) {
		List dbObject = findKeyValue(mapKeyValue);
		List ProvWasStartedBy = new ArrayList();
		for (Object dbo : dbObject) {
			ProvWasStartedBy obj = new ProvWasStartedByConverter().converterToProvWasStartedBy((DBObject) dbo);
			ProvWasStartedBy.add(obj);
		}
		return ProvWasStartedBy;
	}

}