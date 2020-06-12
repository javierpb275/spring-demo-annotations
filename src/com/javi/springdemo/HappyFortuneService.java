package com.javi.springdemo;

import org.springframework.stereotype.Component;

@Component //so spring can register it
public class HappyFortuneService implements FortuneService {

	@Override
	public String getFortune() {
		
		return "Today is your lucky day";
	}

}
