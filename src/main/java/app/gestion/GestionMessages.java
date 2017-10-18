package app.gestion;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import app.bean.Vote;

/**
 * DAO des messages
 * @author alexm
 *
 */
@Service
public class GestionMessages {
	
	/** Connection à la base Mongo */
	@Autowired
	MongoTemplate mongoTemplate;
		
	/**
     * Récupère un Message de la base mongo à partir de son id.
     * @param id
     * @return le message correspondant
     */
    public Vote get(final String id) {
    	return mongoTemplate.findById(id, Vote.class);
        
    }

    /**
     * Récupérer un Message donné par l'id du user
     * @param idUser id de l'User
     * @return le message
     */
    public Vote getByIdUser(final String idUser) {
    	
    	Vote mess = mongoTemplate.findOne(new Query(Criteria.where("idUser").is(idUser.toLowerCase(Locale.FRANCE))),
                Vote.class);
    	
    	if(mess == null) {
    		mess = add(new Vote(null, idUser));
    	}
    	
    	return mess;
               
    }

    /**
     * Récupérer la liste des Users
     * @return l'User actuellement connecté
     */
    public List<Vote> getList() {
        return mongoTemplate.findAll(Vote.class);
    }

    /**
     * Crée un nouvel User
     * @param user l'User à ajouter (sans l'id)
     * @return l'User effectivement ajouté (avec id)
     */
    public Vote add(final Vote message) {

        mongoTemplate.insert(message);
        return message;
    }

    /**
     * met à jour un Message
     * @param message Message à modifier (avec id)
     */
    public void update(final Vote message) {

        mongoTemplate.save(message);
    }

    /**
     * Supprime un Message donné par son id <br>
     * @param id du message
     */
    public void delete(final String id) {

        mongoTemplate.remove(new Vote(id));

    }
	
}
