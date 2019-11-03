package db;

import com.mongodb.DB;
import com.mongodb.Mongo;

/**
 *
 * @author tassio
 */
public class MongoConnection {

	private static final String HOST = "localhost";
	private static final int PORT = 27017;
	private static final String DB_NAME = "Prov-BDI4JADE";

	private static MongoConnection uniqInstance;
	private static int mongoInstance = 1;

	private Mongo mongo;
	private DB db;

	private MongoConnection() {
	}

	public static synchronized MongoConnection getInstance() {
		if (uniqInstance == null) {
			uniqInstance = new MongoConnection();
		}
		return uniqInstance;
	}

	@SuppressWarnings("deprecation")
	public DB getDB() {
		if (mongo == null) {
			try {
				mongo = new Mongo(HOST, PORT);
				db = mongo.getDB(DB_NAME);
				// System.out.println("Mongo instance equals :> " + mongoInstance++);
			} catch (Exception e) {
				System.out.printf("Unexpected error", e);
			}
		}
		return db;
	}
}