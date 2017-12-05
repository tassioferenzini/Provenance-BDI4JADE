package dao;

import com.mongodb.DBObject;
import converter.ProvSpecializationOfConverter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import PROV.DM.*;

/**
 *
 * @author tassio
 */
public class ProvSpecializationOfDAO extends EntityIDao {

	public ProvSpecializationOfDAO() {
		super(ProvSpecializationOf.class);
	}

	@SuppressWarnings("rawtypes")
	public void save(ProvSpecializationOf obj) {
		Map mapProvSpecializationOf = new ProvSpecializationOfConverter().converterToMap(obj);
		save(mapProvSpecializationOf);
	}

	@SuppressWarnings("rawtypes")
	public void update(ProvSpecializationOf oldObj, ProvSpecializationOf newObj) {
		Map query = new ProvSpecializationOfConverter().converterToMap(oldObj);
		Map map = new ProvSpecializationOfConverter().converterToMap(newObj);
		update(query, map);
	}

	@SuppressWarnings("rawtypes")
	public void delete(ProvSpecializationOf obj) {
		Map map = new ProvSpecializationOfConverter().converterToMap(obj);
		delete(map);
	}

	@SuppressWarnings("rawtypes")
	public ProvSpecializationOf findobj(Map mapKeyValue) {
		DBObject dbObject = findOne(mapKeyValue);
		if (dbObject == null) {
			return null;
		}
		ProvSpecializationOf ProvSpecializationOf = new ProvSpecializationOfConverter().converterToProvSpecializationOf(dbObject);
		return ProvSpecializationOf;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List findProvSpecializationOf() {
		List dbObject = findAll();
		List ProvSpecializationOf = new ArrayList();
		for (Object dbo : dbObject) {
			ProvSpecializationOf obj = new ProvSpecializationOfConverter().converterToProvSpecializationOf((DBObject) dbo);
			ProvSpecializationOf.add(obj);
		}
		return ProvSpecializationOf;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List findProvSpecializationOf(Map mapKeyValue) {
		List dbObject = findKeyValue(mapKeyValue);
		List ProvSpecializationOf = new ArrayList();
		for (Object dbo : dbObject) {
			ProvSpecializationOf obj = new ProvSpecializationOfConverter().converterToProvSpecializationOf((DBObject) dbo);
			ProvSpecializationOf.add(obj);
		}
		return ProvSpecializationOf;
	}

}