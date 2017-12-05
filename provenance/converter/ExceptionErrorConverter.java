package converter;

import com.mongodb.DBObject;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import model.ExceptionError;

/**
 *
 * @author tassio
 */
public class ExceptionErrorConverter {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Map converterToMap(ExceptionError Obj) {
		Map mapObj = new HashMap();
		mapObj.put("exception", Obj.getException());
		mapObj.put("instant", Obj.getInstant());
		return mapObj;
	}

	public ExceptionError converterToExceptionError(DBObject dbo) {
		ExceptionError Obj = new ExceptionError();
		Obj.setId(dbo.get("_id").toString());
		Obj.setException(dbo.get("exception").toString());
		Obj.setInstant((Date) dbo.get("instant"));
		return Obj;
	}

}
