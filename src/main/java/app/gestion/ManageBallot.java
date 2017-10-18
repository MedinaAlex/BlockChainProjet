package app.gestion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import app.bean.Ballot;

/**
 * DAO des messages
 * @author alexm
 *
 */
@Service
public class ManageBallot {
	
	/** Connection à la base Mongo */
	@Autowired
	MongoTemplate mongoTemplate;
		
	/**
     * Récupère un Message de la base mongo à partir de son id.
     * @param id
     * @return le message correspondant
     */
    public Ballot get(final String id) {
    	return mongoTemplate.findById(id, Ballot.class);
    }

    /**
     * Récupérer la liste des Users
     * @return l'User actuellement connecté
     */
    public List<Ballot> getList() {
        return mongoTemplate.findAll(Ballot.class);
    }

    /**
     * Crée un nouvel User
     * @param user l'User à ajouter (sans l'id)
     * @return l'User effectivement ajouté (avec id)
     */
    public Ballot add(final Ballot ballot) {

        mongoTemplate.insert(ballot);
        return ballot;
    }

    /**
     * met à jour un Message
     * @param message Message à modifier (avec id)
     */
    public void update(final Ballot message) {

        mongoTemplate.save(message);
    }

    /**
     * Supprime un Message donné par son id
     * @param id du message
     */
    public void delete(final String id) {

        mongoTemplate.remove(new Ballot(id));
    }
}
