package dao;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import db.MongoConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author tassio
 */
public class EntityIDao implements IDao {

	private final Class persistentClass;
	private final DBCollection dbCollection;

	public EntityIDao(Class persistentClass) {
		this.persistentClass = persistentClass;
		this.dbCollection = MongoConnection.getInstance().getDB().getCollection(persistentClass.getSimpleName());
	}

	protected DBCollection getDbCollection() {
		return dbCollection;
	}

	@Override
	public void save(Map mapEntity) {
		BasicDBObject document = new BasicDBObject(mapEntity);
		dbCollection.save(document);
	}

	@Override
	public void update(Map mapQuery, Map mapEntity) {
		BasicDBObject query = new BasicDBObject(mapQuery);
		BasicDBObject entity = new BasicDBObject(mapEntity);
		dbCollection.update(query, entity);
	}

	@Override
	public void delete(Map mapEntity) {
		BasicDBObject entity = new BasicDBObject(mapEntity);
		dbCollection.remove(entity);
	}

	@Override
	public DBObject findOne(Map mapEntity) {
		BasicDBObject query = new BasicDBObject(mapEntity);
		return dbCollection.findOne(query);
	}

	@Override
	public List findAll() {
		List list = new ArrayList();
		DBCursor cursor = dbCollection.find();
		while (cursor.hasNext()) {
			list.add(cursor.next());
		}
		return list;
	}

	@Override
	public List findKeyValue(Map keyValue) {
		List list = new ArrayList();
		DBCursor cursor = dbCollection.find(new BasicDBObject(keyValue));
		while (cursor.hasNext()) {
			list.add(cursor.next());
		}
		return list;
	}

}
