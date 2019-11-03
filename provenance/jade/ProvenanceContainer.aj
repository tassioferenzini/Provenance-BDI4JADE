package jade;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Before;

import PROV.DM.ProvActivity;
import PROV.DM.ProvEntity;
import PROV.DM.ProvWasEndedByAA;
import PROV.DM.ProvWasInformedBy;
import PROV.DM.ProvWasStartedByAA;
import dao.ProvActivityDAO;
import dao.ProvWasEndedByAADAO;
import dao.ProvWasInformedByDAO;
import dao.ProvWasStartedByAADAO;
import jade.core.Profile;

public aspect ProvenanceContainer {

	private static ProvActivity act;
	private static ProvActivity act2;
	private static ProvEntity ent;
	private static ProvWasInformedBy wib;
	private static ProvWasStartedByAA wsbaa;
	private static ProvWasEndedByAA webaa;

	pointcut SetcreateMainContainer(Profile arg1) : 
        execution(* jade.core.Runtime.createMainContainer(Profile))  && 
        args(arg1);

	@SuppressWarnings("unchecked")
	before(Profile arg1) : SetcreateMainContainer(arg1) {
		act = new ProvActivity();
		Date startTime = new Date();
		act.setStartTime(startTime);
		act.setNameActivity(
				"Creates a new main container in the current JVM, providing access through a proxy object.");
		Date endTime = new Date();
		act.setEndTime(endTime);

		@SuppressWarnings("rawtypes")
		Map keyValue = new HashMap();
		keyValue.put("nameActivity", "System Started");
		ProvActivity act2 = new ProvActivityDAO().findobj(keyValue);

		wib = new ProvWasInformedBy();
		wib.setActivity(act2);
		wib.setActivity1(act);
		new Thread(t1).start();
		new Thread(t2).start();

		wsbaa = new ProvWasStartedByAA();
		wsbaa.setActivity(act2);
		wsbaa.setActivity1(act);

		ent = new ProvEntity();
		ent.setNameEntity(arg1.toString());
		wsbaa.setEntity(ent);
		wsbaa.setTime(startTime);
		new Thread(t3).start();

	}

	private static Runnable t1 = new Runnable() {
		public void run() {
			try {
				new ProvActivityDAO().save(act);
			} catch (Exception e) {
			}

		}
	};

	private static Runnable t2 = new Runnable() {
		public void run() {
			try {
				new ProvWasInformedByDAO().save(wib);
			} catch (Exception e) {
			}

		}
	};

	private static Runnable t3 = new Runnable() {
		public void run() {
			try {
				new ProvWasStartedByAADAO().save(wsbaa);
			} catch (Exception e) {
			}

		}
	};

	@Before("execution(* jade.core.Runtime.beginContainer(..))")
	public void newContainerS() {
		act = new ProvActivity();
		Date startTime = new Date();
		act.setStartTime(startTime);
		act.setNameActivity("Called by a starting up container.");
	}

	@After("execution(* jade.core.Runtime.beginContainer(..))")
	public void newContainerE() {
		Date endTime = new Date();
		act.setEndTime(endTime);
		new ProvActivityDAO().save(act);
	}

	@Before("execution(* jade.core.Runtime.endContainer(..))")
	public void endContainerS() {
		act = new ProvActivity();
		Date startTime = new Date();
		act.setStartTime(startTime);
		act.setNameActivity("Called by a terminating container.");
	}

	@After("execution(* jade.core.Runtime.endContainer(..))")
	public void endContainerE() {
		Date endTime = new Date();
		act.setEndTime(endTime);
		new Thread(t4).start();

		act2 = new ProvActivity();
		Date startTime = new Date();
		act2.setStartTime(startTime);
		act2.setEndTime(endTime);
		act2.setNameActivity("System Finished");
		new Thread(t4).start();

//		@SuppressWarnings("rawtypes")
//		Map keyValue = new HashMap();
//		keyValue.put("nameActivity", "Called by a terminating container.");
//		ProvActivity act2 = new ProvActivityDAO().findobj(keyValue);

		webaa = new ProvWasEndedByAA();
		webaa.setActivity(act);
		webaa.setActivity1(act2);
		webaa.setTime(startTime);
		ProvEntity entity = new ProvEntity();
		entity.setNameEntity("null");
		webaa.setEntity(entity);
		new Thread(t5).start();

	}

	private static Runnable t4 = new Runnable() {
		public void run() {
			try {
				new ProvActivityDAO().save(act2);
			} catch (Exception e) {
			}

		}
	};

	private static Runnable t5 = new Runnable() {
		public void run() {
			try {
				new ProvWasEndedByAADAO().save(webaa);
			} catch (Exception e) {
			}

		}
	};

}
