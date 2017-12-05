package dao;

import com.mongodb.DBObject;
import converter.ProvEntityConverter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import PROV.DM.*;

/**
 *
 * @author tassio
 */
public class ProvEntityDAO extends EntityIDao {

	public ProvEntityDAO() {
		super(ProvEntity.class);
	}

	@SuppressWarnings("rawtypes")
	public void save(ProvEntity obj) {
		Map mapProvEntity = new ProvEntityConverter().converterToMap(obj);
		save(mapProvEntity);
	}

	@SuppressWarnings("rawtypes")
	public void update(ProvEntity oldObj, ProvEntity newObj) {
		Map query = new ProvEntityConverter().converterToMap(oldObj);
		Map map = new ProvEntityConverter().converterToMap(newObj);
		update(query, map);
	}

	@SuppressWarnings("rawtypes")
	public void delete(ProvEntity obj) {
		Map map = new ProvEntityConverter().converterToMap(obj);
		delete(map);
	}

	@SuppressWarnings("rawtypes")
	public ProvEntity findobj(Map mapKeyValue) {
		DBObject dbObject = findOne(mapKeyValue);
		if (dbObject == null) {
			return null;
		}
		ProvEntity ProvEntity = new ProvEntityConverter().converterToProvEntity(dbObject);
		return ProvEntity;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List findProvEntity() {
		List dbObject = findAll();
		List ProvEntity = new ArrayList();
		for (Object dbo : dbObject) {
			ProvEntity obj = new ProvEntityConverter().converterToProvEntity((DBObject) dbo);
			ProvEntity.add(obj);
		}
		return ProvEntity;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List findProvEntity(Map mapKeyValue) {
		List dbObject = findKeyValue(mapKeyValue);
		List ProvEntity = new ArrayList();
		for (Object dbo : dbObject) {
			ProvEntity obj = new ProvEntityConverter().converterToProvEntity((DBObject) dbo);
			ProvEntity.add(obj);
		}
		return ProvEntity;
	}

}