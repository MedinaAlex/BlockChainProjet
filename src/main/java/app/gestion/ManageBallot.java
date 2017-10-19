package app.gestion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import app.bean.Ballot;

/**
 * Ballot's DAO
 * @author alexm
 *
 */
@Service
public class ManageBallot {
	
	/** Mongo connection */
	@Autowired
	MongoTemplate mongoTemplate;
		
	/**
     * Get a ballot by its Id
     * @param id ballot id
     * @return the ballot
     */
    public Ballot get(final String id) {
    	return mongoTemplate.findById(id, Ballot.class);
    }

    /**
     * get ballot list
     * @return ballot list
     */
    public List<Ballot> getList() {
        return mongoTemplate.findAll(Ballot.class);
    }

    /**
     * insert a new Ballot
     * @param ballot the new ballot
     * @return the new ballot with a generated id
     */
    public Ballot add(final Ballot ballot) {

        mongoTemplate.insert(ballot);
        return ballot;
    }

    /**
     * update a ballot
     * @param ballot ballot to update
     */
    public void update(final Ballot ballot) {

        mongoTemplate.save(ballot);
    }

    /**
     * Remove a ballot
     * @param id ballot's Id
     */
    public void delete(final String id) {

        mongoTemplate.remove(new Ballot(id));
    }
}
