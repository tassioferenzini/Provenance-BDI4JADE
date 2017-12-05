package dao;

import com.mongodb.DBObject;
import converter.ProvWasInformedByConverter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import PROV.DM.*;

/**
 *
 * @author tassio
 */
public class ProvWasInformedByDAO extends EntityIDao {

	public ProvWasInformedByDAO() {
		super(ProvWasInformedBy.class);
	}

	@SuppressWarnings("rawtypes")
	public void save(ProvWasInformedBy obj) {
		Map mapProvWasInformedBy = new ProvWasInformedByConverter().converterToMap(obj);
		save(mapProvWasInformedBy);
	}

	@SuppressWarnings("rawtypes")
	public void update(ProvWasInformedBy oldObj, ProvWasInformedBy newObj) {
		Map query = new ProvWasInformedByConverter().converterToMap(oldObj);
		Map map = new ProvWasInformedByConverter().converterToMap(newObj);
		update(query, map);
	}

	@SuppressWarnings("rawtypes")
	public void delete(ProvWasInformedBy obj) {
		Map map = new ProvWasInformedByConverter().converterToMap(obj);
		delete(map);
	}

	@SuppressWarnings("rawtypes")
	public ProvWasInformedBy findobj(Map mapKeyValue) {
		DBObject dbObject = findOne(mapKeyValue);
		if (dbObject == null) {
			return null;
		}
		ProvWasInformedBy ProvWasInformedBy = new ProvWasInformedByConverter().converterToProvWasInformedBy(dbObject);
		return ProvWasInformedBy;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List findProvWasInformedBy() {
		List dbObject = findAll();
		List ProvWasInformedBy = new ArrayList();
		for (Object dbo : dbObject) {
			ProvWasInformedBy obj = new ProvWasInformedByConverter().converterToProvWasInformedBy((DBObject) dbo);
			ProvWasInformedBy.add(obj);
		}
		return ProvWasInformedBy;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List findProvWasInformedBy(Map mapKeyValue) {
		List dbObject = findKeyValue(mapKeyValue);
		List ProvWasInformedBy = new ArrayList();
		for (Object dbo : dbObject) {
			ProvWasInformedBy obj = new ProvWasInformedByConverter().converterToProvWasInformedBy((DBObject) dbo);
			ProvWasInformedBy.add(obj);
		}
		return ProvWasInformedBy;
	}

}