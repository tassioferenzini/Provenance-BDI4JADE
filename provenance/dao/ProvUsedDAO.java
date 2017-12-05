package dao;

import com.mongodb.DBObject;
import converter.ProvUsedConverter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import PROV.DM.*;

/**
 *
 * @author tassio
 */
public class ProvUsedDAO extends EntityIDao {

	public ProvUsedDAO() {
		super(ProvUsed.class);
	}

	@SuppressWarnings("rawtypes")
	public void save(ProvUsed obj) {
		Map mapProvUsed = new ProvUsedConverter().converterToMap(obj);
		save(mapProvUsed);
	}

	@SuppressWarnings("rawtypes")
	public void update(ProvUsed oldObj, ProvUsed newObj) {
		Map query = new ProvUsedConverter().converterToMap(oldObj);
		Map map = new ProvUsedConverter().converterToMap(newObj);
		update(query, map);
	}

	@SuppressWarnings("rawtypes")
	public void delete(ProvUsed obj) {
		Map map = new ProvUsedConverter().converterToMap(obj);
		delete(map);
	}

	@SuppressWarnings("rawtypes")
	public ProvUsed findobj(Map mapKeyValue) {
		DBObject dbObject = findOne(mapKeyValue);
		if (dbObject == null) {
			return null;
		}
		ProvUsed ProvUsed = new ProvUsedConverter().converterToProvUsed(dbObject);
		return ProvUsed;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List findProvUsed() {
		List dbObject = findAll();
		List ProvUsed = new ArrayList();
		for (Object dbo : dbObject) {
			ProvUsed obj = new ProvUsedConverter().converterToProvUsed((DBObject) dbo);
			ProvUsed.add(obj);
		}
		return ProvUsed;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List findProvUsed(Map mapKeyValue) {
		List dbObject = findKeyValue(mapKeyValue);
		List ProvUsed = new ArrayList();
		for (Object dbo : dbObject) {
			ProvUsed obj = new ProvUsedConverter().converterToProvUsed((DBObject) dbo);
			ProvUsed.add(obj);
		}
		return ProvUsed;
	}

}