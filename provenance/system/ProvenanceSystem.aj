package system;

import java.time.Instant;
import java.util.Date;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import PROV.DM.ProvAgent;
import dao.ExceptionErrorDAO;
import dao.ProvAgentDAO;
import jade.core.Agent;
import model.ExceptionError;

@Aspect
public aspect ProvenanceSystem {
	
	// Start of SMA
	@Before("execution(* jade.core.Runtime.instance(..))") 
	public void startMain(){
		Instant now = Instant.now();
		System.out.println("Starting System in " + now);
	}
	
	@After("execution(* jade.core.Runtime.instance(..))") 
	public void endMain(){
		Instant now = Instant.now();
		System.out.println("System Started in " + now);
	}
	
	//Create a new container
	@Before("execution(* jade.core.Runtime.createMainContainer(..))")
	public void newContainerS(){
		Instant now = Instant.now();
		System.out.println("Creating a new container in " + now);
	}
	
	@After("execution(* jade.core.Runtime.createMainContainer(..))")
	public void newContainerE(){
		Instant now = Instant.now();
		System.out.println("Created a new container in " + now);
	}
	
	// Add a new Agent
	pointcut SetNewAgent(String arg1, Agent arg2) : 
        execution(* jade.wrapper.ContainerController.acceptNewAgent(String, Agent))  && 
        args(arg1, arg2);

	after(String arg1, Agent arg2) : SetNewAgent(arg1, arg2) {
		//System.out.println("The Agent " + thisJoinPoint.getTarget().toString() + " received " + arg1 +" of type " + arg2);
		
		ProvAgent provag = new ProvAgent();
		provag.setNameAgent(thisJoinPoint.getTarget().toString());
		provag.setTypeAgent(arg2.toString());
		new ProvAgentDAO().save(provag);
	}
	
	//Start the agent
	@Before("execution(*  jade.wrapper.AgentController.start(..))")
	public void endAgent(){
		Instant now = Instant.now();
		System.out.println("Starting agent in " + now);
	}
	
	@AfterReturning("execution(*  jade.wrapper.AgentController.start(..))")
	public void startAgent(){
		Instant now = Instant.now();
		System.out.println("Agent started in " + now);
	}

}
