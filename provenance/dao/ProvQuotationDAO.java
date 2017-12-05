package dao;

import com.mongodb.DBObject;
import converter.ProvQuotationConverter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import PROV.DM.*;

/**
 *
 * @author tassio
 */
public class ProvQuotationDAO extends EntityIDao {

	public ProvQuotationDAO() {
		super(ProvQuotation.class);
	}

	@SuppressWarnings("rawtypes")
	public void save(ProvQuotation obj) {
		Map mapProvQuotation = new ProvQuotationConverter().converterToMap(obj);
		save(mapProvQuotation);
	}

	@SuppressWarnings("rawtypes")
	public void update(ProvQuotation oldObj, ProvQuotation newObj) {
		Map query = new ProvQuotationConverter().converterToMap(oldObj);
		Map map = new ProvQuotationConverter().converterToMap(newObj);
		update(query, map);
	}

	@SuppressWarnings("rawtypes")
	public void delete(ProvQuotation obj) {
		Map map = new ProvQuotationConverter().converterToMap(obj);
		delete(map);
	}

	@SuppressWarnings("rawtypes")
	public ProvQuotation findobj(Map mapKeyValue) {
		DBObject dbObject = findOne(mapKeyValue);
		if (dbObject == null) {
			return null;
		}
		ProvQuotation ProvQuotation = new ProvQuotationConverter().converterToProvQuotation(dbObject);
		return ProvQuotation;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List findProvQuotation() {
		List dbObject = findAll();
		List ProvQuotation = new ArrayList();
		for (Object dbo : dbObject) {
			ProvQuotation obj = new ProvQuotationConverter().converterToProvQuotation((DBObject) dbo);
			ProvQuotation.add(obj);
		}
		return ProvQuotation;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List findProvQuotation(Map mapKeyValue) {
		List dbObject = findKeyValue(mapKeyValue);
		List ProvQuotation = new ArrayList();
		for (Object dbo : dbObject) {
			ProvQuotation obj = new ProvQuotationConverter().converterToProvQuotation((DBObject) dbo);
			ProvQuotation.add(obj);
		}
		return ProvQuotation;
	}

}