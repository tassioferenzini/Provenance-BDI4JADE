package system;

import java.util.Date;

import PROV.DM.ProvActedOnBehalfOf;
import PROV.DM.ProvActivity;
import PROV.DM.ProvAgent;
import dao.ProvActedOnBehalfOfDAO;
import jade.lang.acl.ACLMessage;

public aspect ProvenanceMessage {

	private static ProvActedOnBehalfOf act;
	private static ProvAgent agent;
	private static ProvAgent agent1;
	private static ProvActivity activity;
	
	pointcut Setsend(ACLMessage arg1) : 
        execution(* jade.core.Agent.send(ACLMessage))  && 
        args(arg1);

	after(ACLMessage arg1) : Setsend(arg1) {

		Date s = new Date();
		activity = new ProvActivity();
		activity.setNameActivity("Send Message " + arg1.getContent());
		activity.setStartTime(s);
		Date e = new Date();
		activity.setEndTime(e);
		
		agent = new ProvAgent();
		agent.setTypeAgent(arg1.getSender().getClass().getSimpleName());
		agent.setNameAgent(arg1.getSender().getName());
		
		agent1 = new ProvAgent();
		agent1.setTypeAgent(arg1.getOntology());
		agent1.setNameAgent(arg1.getConversationId());
		
		act = new ProvActedOnBehalfOf();
		act.setActivity(activity);
		act.setAgent(agent);
		act.setAgent1(agent1);
		
		new Thread(t1).start();

	}

	private static Runnable t1 = new Runnable() {
		public void run() {
			try {
				new ProvActedOnBehalfOfDAO().save(act);
			} catch (Exception e) {
			}

		}
	};
	
}
