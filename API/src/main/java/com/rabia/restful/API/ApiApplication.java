package com.rabia.restful.API;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;

@EnableScheduling
@SpringBootApplication
public class ApiApplication {
	private final static String ACCOUNT_SID = "<your-account-sid>";
	private final static String AUTH_ID = "<your-auth-id>";
	static {
		Twilio.init(ACCOUNT_SID, AUTH_ID);
	}
	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);
	}

	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}


	public void run(ApplicationArguments arg0) throws Exception{
		Message.creator(new PhoneNumber("to-number"), new PhoneNumber("from-number"),"Message from spring boot").create();
	}
}
