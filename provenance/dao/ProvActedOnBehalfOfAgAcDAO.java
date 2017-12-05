package dao;

import com.mongodb.DBObject;
import converter.ProvActedOnBehalfOfAgAcConverter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import PROV.DM.*;

/**
 *
 * @author tassio
 */
public class ProvActedOnBehalfOfAgAcDAO extends EntityIDao {

	public ProvActedOnBehalfOfAgAcDAO() {
		super(ProvActedOnBehalfOfAgAc.class);
	}

	@SuppressWarnings("rawtypes")
	public void save(ProvActedOnBehalfOfAgAc obj) {
		Map mapProvActedOnBehalfOfAgAc = new ProvActedOnBehalfOfAgAcConverter().converterToMap(obj);
		save(mapProvActedOnBehalfOfAgAc);
	}

	@SuppressWarnings("rawtypes")
	public void update(ProvActedOnBehalfOfAgAc oldObj, ProvActedOnBehalfOfAgAc newObj) {
		Map query = new ProvActedOnBehalfOfAgAcConverter().converterToMap(oldObj);
		Map map = new ProvActedOnBehalfOfAgAcConverter().converterToMap(newObj);
		update(query, map);
	}

	@SuppressWarnings("rawtypes")
	public void delete(ProvActedOnBehalfOfAgAc obj) {
		Map map = new ProvActedOnBehalfOfAgAcConverter().converterToMap(obj);
		delete(map);
	}

	@SuppressWarnings("rawtypes")
	public ProvActedOnBehalfOfAgAc findobj(Map mapKeyValue) {
		DBObject dbObject = findOne(mapKeyValue);
		if (dbObject == null) {
			return null;
		}
		ProvActedOnBehalfOfAgAc ProvActedOnBehalfOfAgAc = new ProvActedOnBehalfOfAgAcConverter().converterToProvActedOnBehalfOfAgAc(dbObject);
		return ProvActedOnBehalfOfAgAc;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List findProvActedOnBehalfOfAgAc() {
		List dbObject = findAll();
		List ProvActedOnBehalfOfAgAc = new ArrayList();
		for (Object dbo : dbObject) {
			ProvActedOnBehalfOfAgAc obj = new ProvActedOnBehalfOfAgAcConverter().converterToProvActedOnBehalfOfAgAc((DBObject) dbo);
			ProvActedOnBehalfOfAgAc.add(obj);
		}
		return ProvActedOnBehalfOfAgAc;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List findProvActedOnBehalfOfAgAc(Map mapKeyValue) {
		List dbObject = findKeyValue(mapKeyValue);
		List ProvActedOnBehalfOfAgAc = new ArrayList();
		for (Object dbo : dbObject) {
			ProvActedOnBehalfOfAgAc obj = new ProvActedOnBehalfOfAgAcConverter().converterToProvActedOnBehalfOfAgAc((DBObject) dbo);
			ProvActedOnBehalfOfAgAc.add(obj);
		}
		return ProvActedOnBehalfOfAgAc;
	}

}