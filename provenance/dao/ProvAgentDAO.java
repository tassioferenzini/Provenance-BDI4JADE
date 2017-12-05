package dao;

import com.mongodb.DBObject;
import converter.ProvAgentConverter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import PROV.DM.*;

/**
 *
 * @author tassio
 */
public class ProvAgentDAO extends EntityIDao {

	public ProvAgentDAO() {
		super(ProvAgent.class);
	}

	@SuppressWarnings("rawtypes")
	public void save(ProvAgent obj) {
		Map mapProvAgent = new ProvAgentConverter().converterToMap(obj);
		save(mapProvAgent);
	}

	@SuppressWarnings("rawtypes")
	public void update(ProvAgent oldObj, ProvAgent newObj) {
		Map query = new ProvAgentConverter().converterToMap(oldObj);
		Map map = new ProvAgentConverter().converterToMap(newObj);
		update(query, map);
	}

	@SuppressWarnings("rawtypes")
	public void delete(ProvAgent obj) {
		Map map = new ProvAgentConverter().converterToMap(obj);
		delete(map);
	}

	@SuppressWarnings("rawtypes")
	public ProvAgent findobj(Map mapKeyValue) {
		DBObject dbObject = findOne(mapKeyValue);
		if (dbObject == null) {
			return null;
		}
		ProvAgent ProvAgent = new ProvAgentConverter().converterToProvAgent(dbObject);
		return ProvAgent;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List findProvAgent() {
		List dbObject = findAll();
		List ProvAgent = new ArrayList();
		for (Object dbo : dbObject) {
			ProvAgent obj = new ProvAgentConverter().converterToProvAgent((DBObject) dbo);
			ProvAgent.add(obj);
		}
		return ProvAgent;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List findProvAgent(Map mapKeyValue) {
		List dbObject = findKeyValue(mapKeyValue);
		List ProvAgent = new ArrayList();
		for (Object dbo : dbObject) {
			ProvAgent obj = new ProvAgentConverter().converterToProvAgent((DBObject) dbo);
			ProvAgent.add(obj);
		}
		return ProvAgent;
	}

}