package dao;

import com.mongodb.DBObject;
import converter.ProvWasAttributedToConverter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import PROV.DM.*;

/**
 *
 * @author tassio
 */
public class ProvWasAttributedToDAO extends EntityIDao {

	public ProvWasAttributedToDAO() {
		super(ProvWasAttributedTo.class);
	}

	@SuppressWarnings("rawtypes")
	public void save(ProvWasAttributedTo obj) {
		Map mapProvWasAttributedTo = new ProvWasAttributedToConverter().converterToMap(obj);
		save(mapProvWasAttributedTo);
	}

	@SuppressWarnings("rawtypes")
	public void update(ProvWasAttributedTo oldObj, ProvWasAttributedTo newObj) {
		Map query = new ProvWasAttributedToConverter().converterToMap(oldObj);
		Map map = new ProvWasAttributedToConverter().converterToMap(newObj);
		update(query, map);
	}

	@SuppressWarnings("rawtypes")
	public void delete(ProvWasAttributedTo obj) {
		Map map = new ProvWasAttributedToConverter().converterToMap(obj);
		delete(map);
	}

	@SuppressWarnings("rawtypes")
	public ProvWasAttributedTo findobj(Map mapKeyValue) {
		DBObject dbObject = findOne(mapKeyValue);
		if (dbObject == null) {
			return null;
		}
		ProvWasAttributedTo ProvWasAttributedTo = new ProvWasAttributedToConverter().converterToProvWasAttributedTo(dbObject);
		return ProvWasAttributedTo;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List findProvWasAttributedTo() {
		List dbObject = findAll();
		List ProvWasAttributedTo = new ArrayList();
		for (Object dbo : dbObject) {
			ProvWasAttributedTo obj = new ProvWasAttributedToConverter().converterToProvWasAttributedTo((DBObject) dbo);
			ProvWasAttributedTo.add(obj);
		}
		return ProvWasAttributedTo;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List findProvWasAttributedTo(Map mapKeyValue) {
		List dbObject = findKeyValue(mapKeyValue);
		List ProvWasAttributedTo = new ArrayList();
		for (Object dbo : dbObject) {
			ProvWasAttributedTo obj = new ProvWasAttributedToConverter().converterToProvWasAttributedTo((DBObject) dbo);
			ProvWasAttributedTo.add(obj);
		}
		return ProvWasAttributedTo;
	}

}