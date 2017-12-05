package dao;

import com.mongodb.DBObject;
import converter.ProvActivityConverter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import PROV.DM.*;

/**
 *
 * @author tassio
 */
public class ProvActivityDAO extends EntityIDao {

	public ProvActivityDAO() {
		super(ProvActivity.class);
	}

	@SuppressWarnings("rawtypes")
	public void save(ProvActivity obj) {
		Map mapProvActivity = new ProvActivityConverter().converterToMap(obj);
		save(mapProvActivity);
	}

	@SuppressWarnings("rawtypes")
	public void update(ProvActivity oldObj, ProvActivity newObj) {
		Map query = new ProvActivityConverter().converterToMap(oldObj);
		Map map = new ProvActivityConverter().converterToMap(newObj);
		update(query, map);
	}

	@SuppressWarnings("rawtypes")
	public void delete(ProvActivity obj) {
		Map map = new ProvActivityConverter().converterToMap(obj);
		delete(map);
	}

	@SuppressWarnings("rawtypes")
	public ProvActivity findobj(Map mapKeyValue) {
		DBObject dbObject = findOne(mapKeyValue);
		if (dbObject == null) {
			return null;
		}
		ProvActivity ProvActivity = new ProvActivityConverter().converterToProvActivity(dbObject);
		return ProvActivity;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List findProvActivity() {
		List dbObject = findAll();
		List ProvActivity = new ArrayList();
		for (Object dbo : dbObject) {
			ProvActivity obj = new ProvActivityConverter().converterToProvActivity((DBObject) dbo);
			ProvActivity.add(obj);
		}
		return ProvActivity;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List findProvActivity(Map mapKeyValue) {
		List dbObject = findKeyValue(mapKeyValue);
		List ProvActivity = new ArrayList();
		for (Object dbo : dbObject) {
			ProvActivity obj = new ProvActivityConverter().converterToProvActivity((DBObject) dbo);
			ProvActivity.add(obj);
		}
		return ProvActivity;
	}

}