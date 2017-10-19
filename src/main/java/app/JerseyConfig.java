package app;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import app.adaptateur.AdaptatorBallot;
import app.adaptateur.AdaptatorPollingPlace;

/**
 * JerseyConfig for Rest services.
 * @author alexm
 *
 */
@Component
public class JerseyConfig extends ResourceConfig {

	/**
	 * Configuration
	 */
    public JerseyConfig() {
        register(AdaptatorPollingPlace.class);
        register(AdaptatorBallot.class);
    }

}