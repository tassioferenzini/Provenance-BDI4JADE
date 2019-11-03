package jade;

import java.util.Date;

import PROV.DM.ProvActivity;
import PROV.DM.ProvAgent;
import PROV.DM.ProvWasAssociatedWith;
import dao.ProvActivityDAO;
import dao.ProvAgentDAO;
import dao.ProvWasAssociatedWithDAO;
import jade.core.Agent;

public aspect ProvenanceAgent {

	private static ProvActivity act;
	private static ProvAgent agt;
	private static ProvWasAssociatedWith inf;

	pointcut SetNewAgent(String arg1, Agent arg2) : 
	        execution(* jade.wrapper.ContainerController.acceptNewAgent(String, Agent))  && 
	        args(arg1, arg2);

	after(String arg1, Agent arg2) : SetNewAgent(arg1, arg2) {
		Date startTime = new Date();
		agt = new ProvAgent();
		agt.setNameAgent(arg1);
		agt.setTypeAgent(arg2.toString().replace("bdi4jade.core.", ""));
		act = new ProvActivity();
		act.setNameActivity("Create new Agent named " + agt.getNameAgent());
		act.setStartTime(startTime);
		Date endTime = new Date();
		act.setEndTime(endTime);
		inf = new ProvWasAssociatedWith();
		inf.setAgent(agt);
		inf.setActivity(act);
		inf.setPlan("Start Agent");
		new Thread(t1).start();
		new Thread(t2).start();
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
				new ProvAgentDAO().save(agt);
			} catch (Exception e) {
			}

		}
	};

	private static Runnable t3 = new Runnable() {
		public void run() {
			try {
				new ProvWasAssociatedWithDAO().save(inf);
			} catch (Exception e) {
			}

		}
	};

}
