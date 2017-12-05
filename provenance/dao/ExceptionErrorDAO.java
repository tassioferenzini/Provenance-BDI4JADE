package dao;

import com.mongodb.DBObject;
import converter.ExceptionErrorConverter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import model.ExceptionError;

/**
 *
 * @author tassio
 */
public class ExceptionErrorDAO extends EntityIDao {

	public ExceptionErrorDAO() {
		super(ExceptionError.class);
	}

	@SuppressWarnings("rawtypes")
	public void save(ExceptionError obj) {
		Map mapExceptionError = new ExceptionErrorConverter().converterToMap(obj);
		save(mapExceptionError);
	}

	@SuppressWarnings("rawtypes")
	public void update(ExceptionError oldObj, ExceptionError newObj) {
		Map query = new ExceptionErrorConverter().converterToMap(oldObj);
		Map map = new ExceptionErrorConverter().converterToMap(newObj);
		update(query, map);
	}

	@SuppressWarnings("rawtypes")
	public void delete(ExceptionError obj) {
		Map map = new ExceptionErrorConverter().converterToMap(obj);
		delete(map);
	}

	@SuppressWarnings("rawtypes")
	public ExceptionError findobj(Map mapKeyValue) {
		DBObject dbObject = findOne(mapKeyValue);
		if (dbObject == null) {
			return null;
		}
		ExceptionError ExceptionError = new ExceptionErrorConverter().converterToExceptionError(dbObject);
		return ExceptionError;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List findExceptionError() {
		List dbObject = findAll();
		List ExceptionError = new ArrayList();
		for (Object dbo : dbObject) {
			ExceptionError obj = new ExceptionErrorConverter().converterToExceptionError((DBObject) dbo);
			ExceptionError.add(obj);
		}
		return ExceptionError;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List findExceptionError(Map mapKeyValue) {
		List dbObject = findKeyValue(mapKeyValue);
		List ExceptionError = new ArrayList();
		for (Object dbo : dbObject) {
			ExceptionError obj = new ExceptionErrorConverter().converterToExceptionError((DBObject) dbo);
			ExceptionError.add(obj);
		}
		return ExceptionError;
	}

}