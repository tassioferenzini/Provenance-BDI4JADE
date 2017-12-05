package dao;

import com.mongodb.DBObject;
import converter.ProvHadMemberConverter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import PROV.DM.*;

/**
 *
 * @author tassio
 */
public class ProvHadMemberDAO extends EntityIDao {

	public ProvHadMemberDAO() {
		super(ProvHadMember.class);
	}

	@SuppressWarnings("rawtypes")
	public void save(ProvHadMember obj) {
		Map mapProvHadMember = new ProvHadMemberConverter().converterToMap(obj);
		save(mapProvHadMember);
	}

	@SuppressWarnings("rawtypes")
	public void update(ProvHadMember oldObj, ProvHadMember newObj) {
		Map query = new ProvHadMemberConverter().converterToMap(oldObj);
		Map map = new ProvHadMemberConverter().converterToMap(newObj);
		update(query, map);
	}

	@SuppressWarnings("rawtypes")
	public void delete(ProvHadMember obj) {
		Map map = new ProvHadMemberConverter().converterToMap(obj);
		delete(map);
	}

	@SuppressWarnings("rawtypes")
	public ProvHadMember findobj(Map mapKeyValue) {
		DBObject dbObject = findOne(mapKeyValue);
		if (dbObject == null) {
			return null;
		}
		ProvHadMember ProvHadMember = new ProvHadMemberConverter().converterToProvHadMember(dbObject);
		return ProvHadMember;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List findProvHadMember() {
		List dbObject = findAll();
		List ProvHadMember = new ArrayList();
		for (Object dbo : dbObject) {
			ProvHadMember obj = new ProvHadMemberConverter().converterToProvHadMember((DBObject) dbo);
			ProvHadMember.add(obj);
		}
		return ProvHadMember;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List findProvHadMember(Map mapKeyValue) {
		List dbObject = findKeyValue(mapKeyValue);
		List ProvHadMember = new ArrayList();
		for (Object dbo : dbObject) {
			ProvHadMember obj = new ProvHadMemberConverter().converterToProvHadMember((DBObject) dbo);
			ProvHadMember.add(obj);
		}
		return ProvHadMember;
	}

}