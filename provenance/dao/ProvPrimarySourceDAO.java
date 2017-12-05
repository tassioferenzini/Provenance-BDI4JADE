package dao;

import com.mongodb.DBObject;
import converter.ProvPrimarySourceConverter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import PROV.DM.*;

/**
 *
 * @author tassio
 */
public class ProvPrimarySourceDAO extends EntityIDao {

	public ProvPrimarySourceDAO() {
		super(ProvPrimarySource.class);
	}

	@SuppressWarnings("rawtypes")
	public void save(ProvPrimarySource obj) {
		Map mapProvPrimarySource = new ProvPrimarySourceConverter().converterToMap(obj);
		save(mapProvPrimarySource);
	}

	@SuppressWarnings("rawtypes")
	public void update(ProvPrimarySource oldObj, ProvPrimarySource newObj) {
		Map query = new ProvPrimarySourceConverter().converterToMap(oldObj);
		Map map = new ProvPrimarySourceConverter().converterToMap(newObj);
		update(query, map);
	}

	@SuppressWarnings("rawtypes")
	public void delete(ProvPrimarySource obj) {
		Map map = new ProvPrimarySourceConverter().converterToMap(obj);
		delete(map);
	}

	@SuppressWarnings("rawtypes")
	public ProvPrimarySource findobj(Map mapKeyValue) {
		DBObject dbObject = findOne(mapKeyValue);
		if (dbObject == null) {
			return null;
		}
		ProvPrimarySource ProvPrimarySource = new ProvPrimarySourceConverter().converterToProvPrimarySource(dbObject);
		return ProvPrimarySource;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List findProvPrimarySource() {
		List dbObject = findAll();
		List ProvPrimarySource = new ArrayList();
		for (Object dbo : dbObject) {
			ProvPrimarySource obj = new ProvPrimarySourceConverter().converterToProvPrimarySource((DBObject) dbo);
			ProvPrimarySource.add(obj);
		}
		return ProvPrimarySource;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List findProvPrimarySource(Map mapKeyValue) {
		List dbObject = findKeyValue(mapKeyValue);
		List ProvPrimarySource = new ArrayList();
		for (Object dbo : dbObject) {
			ProvPrimarySource obj = new ProvPrimarySourceConverter().converterToProvPrimarySource((DBObject) dbo);
			ProvPrimarySource.add(obj);
		}
		return ProvPrimarySource;
	}

}