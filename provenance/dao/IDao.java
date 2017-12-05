package dao;

import com.mongodb.DBObject;
import java.util.List;
import java.util.Map;

/**
 *
 * @author tassio
 */
public interface IDao {

	void save(Map mapEntity);

	void update(Map mapQuery, Map mapEntity);

	void delete(Map mapEntity);

	DBObject findOne(Map mapEntity);

	List findAll();

	List findKeyValue(Map keyValue);

}
