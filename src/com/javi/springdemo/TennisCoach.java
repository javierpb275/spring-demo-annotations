package com.javi.springdemo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//@Component("thatSillyCoach")
@Component //this uses the default bean id "tennisCoach"
//@Scope("prototype")// prototype is gonna create new instance every time. Whenever they make a request for TennisCoach, from the spring container, it's gonna create a new instance every time 
public class TennisCoach implements Coach {
	
	@Autowired //no need for settter method
	@Qualifier("randomFortuneService")//bean id. be specific
	private FortuneService fortuneService;
	
	//define a default constructor
	public TennisCoach() {
		System.out.println(">> TennisCoach: inside default constructor");
	}
	
	// define my init method
	@PostConstruct
	public void doMyStartupStuff() {
		System.out.println(">> TennisCoach: inside of doMyStartupStuff()");
	}
	
	// define my destroy method
	@PreDestroy
	public void doMyCleanupStuff() {
		System.out.println(">> TennisCoach: inside of doMyCleanupStuff()");
	}
	
	//define a setter method
	/*
	@Autowired
	public void setFortuneService(FortuneService theFortuneService) {
		System.out.println(">> TennisCoach: inside setFortuneService() method");
		this.fortuneService = theFortuneService;
	}
	*/
	
	/*
	@Autowired
	public TennisCoach(FortuneService theFortuneService) {
		fortuneService = theFortuneService;
	}
	*/
	

	
	@Override
	public String getDailyWorkout() {
		return "Practice your backhand volley";
	}

	

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
