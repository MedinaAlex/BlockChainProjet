package app;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import app.adaptateur.AdaptateurBallot;
import app.adaptateur.AdaptateurPollingPlace;

/**
 * Classe ajoutant les services Rest à la config Jersey
 * @author alexm
 *
 */
@Component
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {
        register(AdaptateurPollingPlace.class);
        register(AdaptateurBallot.class);
    }

}