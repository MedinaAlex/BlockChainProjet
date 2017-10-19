package app.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.mongodb.Mongo;

import app.gestion.ManageBallot;
import app.gestion.ManagePollingPlace;

/** Beans configuration */
@Configuration
public class ConfigBean {
	
	/** MongoTemplate for tests */
	@Bean
	public MongoTemplate mongoTemplate(){
		return new MongoTemplate(new Mongo(), "blockchain");
	}

	/** Polling place mananger */
	@Bean
	public ManagePollingPlace managePollingPlace() {
		return new ManagePollingPlace();
	}
	
	/** Ballot mananger */
	@Bean
	public ManageBallot manageBallot() {
		return new ManageBallot();
	}

}
