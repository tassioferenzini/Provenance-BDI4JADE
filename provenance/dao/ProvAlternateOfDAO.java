package dao;

import com.mongodb.DBObject;
import converter.ProvAlternateOfConverter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import PROV.DM.*;

/**
 *
 * @author tassio
 */
public class ProvAlternateOfDAO extends EntityIDao {

	public ProvAlternateOfDAO() {
		super(ProvAlternateOf.class);
	}

	@SuppressWarnings("rawtypes")
	public void save(ProvAlternateOf obj) {
		Map mapProvAlternateOf = new ProvAlternateOfConverter().converterToMap(obj);
		save(mapProvAlternateOf);
	}

	@SuppressWarnings("rawtypes")
	public void update(ProvAlternateOf oldObj, ProvAlternateOf newObj) {
		Map query = new ProvAlternateOfConverter().converterToMap(oldObj);
		Map map = new ProvAlternateOfConverter().converterToMap(newObj);
		update(query, map);
	}

	@SuppressWarnings("rawtypes")
	public void delete(ProvAlternateOf obj) {
		Map map = new ProvAlternateOfConverter().converterToMap(obj);
		delete(map);
	}

	@SuppressWarnings("rawtypes")
	public ProvAlternateOf findobj(Map mapKeyValue) {
		DBObject dbObject = findOne(mapKeyValue);
		if (dbObject == null) {
			return null;
		}
		ProvAlternateOf ProvAlternateOf = new ProvAlternateOfConverter().converterToProvAlternateOf(dbObject);
		return ProvAlternateOf;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List findProvAlternateOf() {
		List dbObject = findAll();
		List ProvAlternateOf = new ArrayList();
		for (Object dbo : dbObject) {
			ProvAlternateOf obj = new ProvAlternateOfConverter().converterToProvAlternateOf((DBObject) dbo);
			ProvAlternateOf.add(obj);
		}
		return ProvAlternateOf;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List findProvAlternateOf(Map mapKeyValue) {
		List dbObject = findKeyValue(mapKeyValue);
		List ProvAlternateOf = new ArrayList();
		for (Object dbo : dbObject) {
			ProvAlternateOf obj = new ProvAlternateOfConverter().converterToProvAlternateOf((DBObject) dbo);
			ProvAlternateOf.add(obj);
		}
		return ProvAlternateOf;
	}

}