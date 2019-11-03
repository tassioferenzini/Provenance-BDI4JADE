package system;

import java.util.Date;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import PROV.DM.ProvActivity;
import dao.ProvActivityDAO;

@Aspect
public aspect ProvenanceSystem {

	private ProvActivity act;
	
	@After("execution(* jade.core.Runtime.shutDown(..))")
	public void shutDown() {
		Date endTime = new Date();
		act.setEndTime(endTime);
		act.setNameActivity("Stops the JADE container running in the Single-container modality.");
		new ProvActivityDAO().save(act);
	}
	
	@Before("execution(* jade.core.Runtime.shutDown(..))")
	public void shutDownE() {
		Date startTime = new Date();
		act.setStartTime(startTime);;
	}
	
	@After("execution(* jade.core.Runtime.setCloseVM(..))")
	public void setCloseVM() {
		Date endTime = new Date();
		act.setEndTime(endTime);
		act.setNameActivity("JADE is closing down now.");
		new ProvActivityDAO().save(act);
	}
	
	@Before("execution(* jade.core.Runtime.setCloseVM(..))")
	public void setCloseVME() {
		Date startTime = new Date();
		act.setStartTime(startTime);;
	}
	

	@Before("execution(* jade.core.Runtime.instance(..))")
	public void startMain() {
		act = new ProvActivity();
		Date startTime = new Date();
		act.setStartTime(startTime);
	}

	@After("execution(* jade.core.Runtime.instance(..))")
	public void endMain() {
		Date endTime = new Date();
		act.setEndTime(endTime);
		act.setNameActivity("System Started");
		new ProvActivityDAO().save(act);
	}

}
