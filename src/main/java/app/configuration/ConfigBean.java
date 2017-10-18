package app.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.mongodb.Mongo;

import app.gestion.ManageBallot;
import app.gestion.ManagePollingPlace;

/** Config des beans */
@Configuration
public class ConfigBean {
	
	/** MongoTemplate a déclarer pour les tests */
	@Bean
	public MongoTemplate mongoTemplate(){
		return new MongoTemplate(new Mongo(), "blockchain");
	}

	@Bean
	public ManagePollingPlace gestionUser() {
		return new ManagePollingPlace();
	}
	
	@Bean
	public ManageBallot gestionMessages() {
		return new ManageBallot();
	}

}
