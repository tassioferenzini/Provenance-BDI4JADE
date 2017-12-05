package dao;

import com.mongodb.DBObject;
import converter.ProvWasAssociatedWithConverter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import PROV.DM.*;

/**
 *
 * @author tassio
 */
public class ProvWasAssociatedWithDAO extends EntityIDao {

	public ProvWasAssociatedWithDAO() {
		super(ProvWasAssociatedWith.class);
	}

	@SuppressWarnings("rawtypes")
	public void save(ProvWasAssociatedWith obj) {
		Map mapProvWasAssociatedWith = new ProvWasAssociatedWithConverter().converterToMap(obj);
		save(mapProvWasAssociatedWith);
	}

	@SuppressWarnings("rawtypes")
	public void update(ProvWasAssociatedWith oldObj, ProvWasAssociatedWith newObj) {
		Map query = new ProvWasAssociatedWithConverter().converterToMap(oldObj);
		Map map = new ProvWasAssociatedWithConverter().converterToMap(newObj);
		update(query, map);
	}

	@SuppressWarnings("rawtypes")
	public void delete(ProvWasAssociatedWith obj) {
		Map map = new ProvWasAssociatedWithConverter().converterToMap(obj);
		delete(map);
	}

	@SuppressWarnings("rawtypes")
	public ProvWasAssociatedWith findobj(Map mapKeyValue) {
		DBObject dbObject = findOne(mapKeyValue);
		if (dbObject == null) {
			return null;
		}
		ProvWasAssociatedWith ProvWasAssociatedWith = new ProvWasAssociatedWithConverter().converterToProvWasAssociatedWith(dbObject);
		return ProvWasAssociatedWith;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List findProvWasAssociatedWith() {
		List dbObject = findAll();
		List ProvWasAssociatedWith = new ArrayList();
		for (Object dbo : dbObject) {
			ProvWasAssociatedWith obj = new ProvWasAssociatedWithConverter().converterToProvWasAssociatedWith((DBObject) dbo);
			ProvWasAssociatedWith.add(obj);
		}
		return ProvWasAssociatedWith;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List findProvWasAssociatedWith(Map mapKeyValue) {
		List dbObject = findKeyValue(mapKeyValue);
		List ProvWasAssociatedWith = new ArrayList();
		for (Object dbo : dbObject) {
			ProvWasAssociatedWith obj = new ProvWasAssociatedWithConverter().converterToProvWasAssociatedWith((DBObject) dbo);
			ProvWasAssociatedWith.add(obj);
		}
		return ProvWasAssociatedWith;
	}

}