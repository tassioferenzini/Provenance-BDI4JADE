package dao;

import com.mongodb.DBObject;
import converter.ThrowableErrorConverter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import model.ThrowableError;

/**
 *
 * @author tassio
 */
public class ThrowableErrorDAO extends EntityIDao {

	public ThrowableErrorDAO() {
		super(ThrowableError.class);
	}

	@SuppressWarnings("rawtypes")
	public void save(ThrowableError obj) {
		Map mapThrowableError = new ThrowableErrorConverter().converterToMap(obj);
		save(mapThrowableError);
	}

	@SuppressWarnings("rawtypes")
	public void update(ThrowableError oldObj, ThrowableError newObj) {
		Map query = new ThrowableErrorConverter().converterToMap(oldObj);
		Map map = new ThrowableErrorConverter().converterToMap(newObj);
		update(query, map);
	}

	@SuppressWarnings("rawtypes")
	public void delete(ThrowableError obj) {
		Map map = new ThrowableErrorConverter().converterToMap(obj);
		delete(map);
	}

	@SuppressWarnings("rawtypes")
	public ThrowableError findobj(Map mapKeyValue) {
		DBObject dbObject = findOne(mapKeyValue);
		if (dbObject == null) {
			return null;
		}
		ThrowableError ThrowableError = new ThrowableErrorConverter().converterToThrowableError(dbObject);
		return ThrowableError;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List findThrowableError() {
		List dbObject = findAll();
		List ThrowableError = new ArrayList();
		for (Object dbo : dbObject) {
			ThrowableError obj = new ThrowableErrorConverter().converterToThrowableError((DBObject) dbo);
			ThrowableError.add(obj);
		}
		return ThrowableError;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List findThrowableError(Map mapKeyValue) {
		List dbObject = findKeyValue(mapKeyValue);
		List ThrowableError = new ArrayList();
		for (Object dbo : dbObject) {
			ThrowableError obj = new ThrowableErrorConverter().converterToThrowableError((DBObject) dbo);
			ThrowableError.add(obj);
		}
		return ThrowableError;
	}

}