package dao;

import com.mongodb.DBObject;
import converter.ProvWasGeneratedByConverter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import PROV.DM.*;

/**
 *
 * @author tassio
 */
public class ProvWasGeneratedByDAO extends EntityIDao {

	public ProvWasGeneratedByDAO() {
		super(ProvWasGeneratedBy.class);
	}

	@SuppressWarnings("rawtypes")
	public void save(ProvWasGeneratedBy obj) {
		Map mapProvWasGeneratedBy = new ProvWasGeneratedByConverter().converterToMap(obj);
		save(mapProvWasGeneratedBy);
	}

	@SuppressWarnings("rawtypes")
	public void update(ProvWasGeneratedBy oldObj, ProvWasGeneratedBy newObj) {
		Map query = new ProvWasGeneratedByConverter().converterToMap(oldObj);
		Map map = new ProvWasGeneratedByConverter().converterToMap(newObj);
		update(query, map);
	}

	@SuppressWarnings("rawtypes")
	public void delete(ProvWasGeneratedBy obj) {
		Map map = new ProvWasGeneratedByConverter().converterToMap(obj);
		delete(map);
	}

	@SuppressWarnings("rawtypes")
	public ProvWasGeneratedBy findobj(Map mapKeyValue) {
		DBObject dbObject = findOne(mapKeyValue);
		if (dbObject == null) {
			return null;
		}
		ProvWasGeneratedBy ProvWasGeneratedBy = new ProvWasGeneratedByConverter().converterToProvWasGeneratedBy(dbObject);
		return ProvWasGeneratedBy;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List findProvWasGeneratedBy() {
		List dbObject = findAll();
		List ProvWasGeneratedBy = new ArrayList();
		for (Object dbo : dbObject) {
			ProvWasGeneratedBy obj = new ProvWasGeneratedByConverter().converterToProvWasGeneratedBy((DBObject) dbo);
			ProvWasGeneratedBy.add(obj);
		}
		return ProvWasGeneratedBy;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List findProvWasGeneratedBy(Map mapKeyValue) {
		List dbObject = findKeyValue(mapKeyValue);
		List ProvWasGeneratedBy = new ArrayList();
		for (Object dbo : dbObject) {
			ProvWasGeneratedBy obj = new ProvWasGeneratedByConverter().converterToProvWasGeneratedBy((DBObject) dbo);
			ProvWasGeneratedBy.add(obj);
		}
		return ProvWasGeneratedBy;
	}

}