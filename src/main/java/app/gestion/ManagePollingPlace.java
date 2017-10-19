package app.gestion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import app.bean.PollingPlace;

/**
 * Polling place's DAO
 * @author alexm
 *
 */
@Service
public class ManagePollingPlace {
	
	/** Mongo connection */
	@Autowired
	MongoTemplate mongoTemplate;

    /**
     * Get a polling place by its Id
     * @param id polling place Id
     * @return the polling place
     */
    public PollingPlace getById(final String id) {
        return mongoTemplate.findById(id, PollingPlace.class);

    }

    /**
     * get polling place list
     * @return polling place list
     */
    public List<PollingPlace> getList() {
        return mongoTemplate.findAll(PollingPlace.class);
    }

    /**
     * add a new polling place to the database
     * @param pollingPlace the new polling place to add)
     * @return PollingPlace with generated Id
     */
    public PollingPlace add(final PollingPlace pollingPlace) {
        mongoTemplate.insert(pollingPlace);
        return pollingPlace;

    }

    /**
     * update a polling place
     * @param pollingPlace to update
     */
    public void update(final PollingPlace pollingPlace) {

        mongoTemplate.save(pollingPlace);
    }

    /**
     * Remove a polling place from the database
     * @param id pollingPlace Id
     */
    public void delete(final String id) {

        mongoTemplate.remove(new PollingPlace(id));
    }
}
