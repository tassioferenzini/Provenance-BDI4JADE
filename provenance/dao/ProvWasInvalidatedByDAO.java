package dao;

import com.mongodb.DBObject;
import converter.ProvWasInvalidatedByConverter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import PROV.DM.*;

/**
 *
 * @author tassio
 */
public class ProvWasInvalidatedByDAO extends EntityIDao {

	public ProvWasInvalidatedByDAO() {
		super(ProvWasInvalidatedBy.class);
	}

	@SuppressWarnings("rawtypes")
	public void save(ProvWasInvalidatedBy obj) {
		Map mapProvWasInvalidatedBy = new ProvWasInvalidatedByConverter().converterToMap(obj);
		save(mapProvWasInvalidatedBy);
	}

	@SuppressWarnings("rawtypes")
	public void update(ProvWasInvalidatedBy oldObj, ProvWasInvalidatedBy newObj) {
		Map query = new ProvWasInvalidatedByConverter().converterToMap(oldObj);
		Map map = new ProvWasInvalidatedByConverter().converterToMap(newObj);
		update(query, map);
	}

	@SuppressWarnings("rawtypes")
	public void delete(ProvWasInvalidatedBy obj) {
		Map map = new ProvWasInvalidatedByConverter().converterToMap(obj);
		delete(map);
	}

	@SuppressWarnings("rawtypes")
	public ProvWasInvalidatedBy findobj(Map mapKeyValue) {
		DBObject dbObject = findOne(mapKeyValue);
		if (dbObject == null) {
			return null;
		}
		ProvWasInvalidatedBy ProvWasInvalidatedBy = new ProvWasInvalidatedByConverter().converterToProvWasInvalidatedBy(dbObject);
		return ProvWasInvalidatedBy;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List findProvWasInvalidatedBy() {
		List dbObject = findAll();
		List ProvWasInvalidatedBy = new ArrayList();
		for (Object dbo : dbObject) {
			ProvWasInvalidatedBy obj = new ProvWasInvalidatedByConverter().converterToProvWasInvalidatedBy((DBObject) dbo);
			ProvWasInvalidatedBy.add(obj);
		}
		return ProvWasInvalidatedBy;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List findProvWasInvalidatedBy(Map mapKeyValue) {
		List dbObject = findKeyValue(mapKeyValue);
		List ProvWasInvalidatedBy = new ArrayList();
		for (Object dbo : dbObject) {
			ProvWasInvalidatedBy obj = new ProvWasInvalidatedByConverter().converterToProvWasInvalidatedBy((DBObject) dbo);
			ProvWasInvalidatedBy.add(obj);
		}
		return ProvWasInvalidatedBy;
	}

}