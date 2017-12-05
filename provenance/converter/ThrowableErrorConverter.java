package converter;

import com.mongodb.DBObject;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import model.ThrowableError;

/**
 *
 * @author tassio
 */
public class ThrowableErrorConverter {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Map converterToMap(ThrowableError Obj) {
		Map mapObj = new HashMap();
		mapObj.put("exception", Obj.getThrowable());
		mapObj.put("instant", Obj.getInstant());
		return mapObj;
	}

	public ThrowableError converterToThrowableError(DBObject dbo) {
		ThrowableError Obj = new ThrowableError();
		Obj.setId(dbo.get("_id").toString());
		Obj.setThrowable(dbo.get("exception").toString());
		Obj.setInstant((Date) dbo.get("instant"));
		return Obj;
	}

}
