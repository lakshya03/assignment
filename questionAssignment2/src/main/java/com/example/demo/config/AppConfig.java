package com.example.demo.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.model.Address;

@Configuration
public class AppConfig {

	Map<Integer,String> hmo =new HashMap<Integer,String>();

	public AppConfig() {
		super();
		// TODO Auto-generated constructor stub
		
		hmo.put(2,"HARYANA");
		hmo.put(3,"HISAR");
		hmo.put(4,"india");
	}
	
	@Bean
	public Address address()
	{
		Address am=new Address();
		am.setPassCode(125001);
		am.setCountry(hmo.get(4));
		am.setState(hmo.get(2));
		am.setCity(hmo.get(3));
		return am;
	}
	
	
	
}
