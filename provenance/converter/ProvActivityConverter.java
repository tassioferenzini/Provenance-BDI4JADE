package converter;

import com.mongodb.DBObject;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.omg.CORBA.ACTIVITY_COMPLETED;

import PROV.DM.*;

/**
 *
 * @author tassio
 */
public class ProvActivityConverter {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Map converterToMap(ProvActivity Obj) {
		Map mapObj = new HashMap();
		mapObj.put("nameActivity", Obj.getNameActivity());
		mapObj.put("startTime", Obj.getStartTime());
		mapObj.put("endTime", Obj.getEndTime());
		return mapObj;
	}

	public ProvActivity converterToProvActivity(DBObject dbo) {
		ProvActivity Obj = new ProvActivity();
		Obj.setId(dbo.get("_id").toString());
		Obj.setNameActivity(dbo.get("nameActivity").toString());
		Obj.setStartTime((Date)dbo.get("startTime"));
		Obj.setEndTime((Date) dbo.get("endTime"));
		return Obj;
	}

}
