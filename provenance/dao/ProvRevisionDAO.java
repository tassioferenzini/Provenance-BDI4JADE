package dao;

import com.mongodb.DBObject;
import converter.ProvRevisionConverter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import PROV.DM.*;

/**
 *
 * @author tassio
 */
public class ProvRevisionDAO extends EntityIDao {

	public ProvRevisionDAO() {
		super(ProvRevision.class);
	}

	@SuppressWarnings("rawtypes")
	public void save(ProvRevision obj) {
		Map mapProvRevision = new ProvRevisionConverter().converterToMap(obj);
		save(mapProvRevision);
	}

	@SuppressWarnings("rawtypes")
	public void update(ProvRevision oldObj, ProvRevision newObj) {
		Map query = new ProvRevisionConverter().converterToMap(oldObj);
		Map map = new ProvRevisionConverter().converterToMap(newObj);
		update(query, map);
	}

	@SuppressWarnings("rawtypes")
	public void delete(ProvRevision obj) {
		Map map = new ProvRevisionConverter().converterToMap(obj);
		delete(map);
	}

	@SuppressWarnings("rawtypes")
	public ProvRevision findobj(Map mapKeyValue) {
		DBObject dbObject = findOne(mapKeyValue);
		if (dbObject == null) {
			return null;
		}
		ProvRevision ProvRevision = new ProvRevisionConverter().converterToProvRevision(dbObject);
		return ProvRevision;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List findProvRevision() {
		List dbObject = findAll();
		List ProvRevision = new ArrayList();
		for (Object dbo : dbObject) {
			ProvRevision obj = new ProvRevisionConverter().converterToProvRevision((DBObject) dbo);
			ProvRevision.add(obj);
		}
		return ProvRevision;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List findProvRevision(Map mapKeyValue) {
		List dbObject = findKeyValue(mapKeyValue);
		List ProvRevision = new ArrayList();
		for (Object dbo : dbObject) {
			ProvRevision obj = new ProvRevisionConverter().converterToProvRevision((DBObject) dbo);
			ProvRevision.add(obj);
		}
		return ProvRevision;
	}

}