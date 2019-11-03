package bdi;

import java.util.Date;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Before;

import PROV.DM.ProvActivity;
import PROV.DM.ProvAgent;
import PROV.DM.ProvEntity;
import PROV.DM.ProvWasAttributedTo;
import bdi4jade.core.Capability;
import bdi4jade.core.Intention;
import bdi4jade.goal.Goal;
import dao.ProvActivityDAO;
import dao.ProvEntityDAO;

public aspect ProvenanceBDIAgent {

	private static ProvActivity ac;
	private static ProvEntity ent;
	private static ProvEntity ent2;
	private static ProvEntity ent3;

	@Before("execution(* bdi4jade.core.AbstractBDIAgent.BDIInterpreter.action(..))")
	public void BDIInterpreterActionS() {
		ac = new ProvActivity();
		Date startT = new Date();
		ac.setStartTime(startT);
	}

	@AfterReturning("execution(* bdi4jade.core.AbstractBDIAgent.BDIInterpreter.action(..))")
	public void BDIInterpreterActionE() {
		Date endT = new Date();
		ac.setEndTime(endT);
		ac.setNameActivity("BDI-interpreter cycle");
		new ProvActivityDAO().save(ac);
	}

	pointcut SetaddGoal(Goal arg1) : 
        execution(* bdi4jade.core.AbstractBDIAgent.addGoal(Goal))  && 
        args(arg1);

	after(Goal arg1) : SetaddGoal(arg1) {

		ent = new ProvEntity();
		ent.setNameEntity(arg1.toString());

		new Thread(t1).start();

	}

	private static Runnable t1 = new Runnable() {
		public void run() {
			try {
				new ProvEntityDAO().save(ent);
			} catch (Exception e) {
			}

		}
	};

	pointcut SetSingleCapabilityAgent(Capability arg1)
	 :
	 execution(* bdi4jade.core.SingleCapabilityAgent.setCapability(Capability)) &&
	 args(arg1);

	after(Capability arg1) :
		SetSingleCapabilityAgent(arg1) {

		ent2 = new ProvEntity();
		ent2.setNameEntity(arg1.getBeliefBase().toString());

		new Thread(t2).start();

	}

	private static Runnable t2 = new Runnable() {
		public void run() {
			try {
				new ProvEntityDAO().save(ent2);
			} catch (Exception e) {
			}

		}
	};

	pointcut SetaddIntention(Intention arg1)
	 :
	 execution(* bdi4jade.core.Capabilyty.addIntention(Intention)) &&
	 args(arg1);

	after(Intention arg1) :
		SetaddIntention(arg1) {

		ent2 = new ProvEntity();
		ent2.setNameEntity(arg1.toString());

		new Thread(t3).start();

	}

	private static Runnable t3 = new Runnable() {
		public void run() {
			try {
				new ProvEntityDAO().save(ent2);
			} catch (Exception e) {
			}

		}
	};
	
//	@Around("execution(* bdi4jade.core.AbstractBDIAgent.removeCapability(..))")
//  public void aroundTeste(ProceedingJoinPoint joinPoint) throws Throwable {
//      
//      
//          joinPoint.proceed();
//      
//      
//  }

}
