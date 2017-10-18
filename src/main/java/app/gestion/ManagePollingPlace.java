package app.gestion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import app.bean.PollingPlace;

/**
 * DAO
 * @author alexm
 *
 */
@Service
public class ManagePollingPlace {
	
	/** Connection à la base mongo */
	@Autowired
	MongoTemplate mongoTemplate;

    /**
     * Récupérer un User donné par son id
     * @param idUser id de l'User
     * @return le User
     */
    public PollingPlace getById(final String idUser) {
        return mongoTemplate.findById(idUser, PollingPlace.class);

    }

    /**
     * Récupérer la liste des User
     * @return la liste des Users
     */
    public List<PollingPlace> getList() {
        return mongoTemplate.findAll(PollingPlace.class);
    }

    /**
     * Crée un nouvel Use
     * @param pollingPlace l'User à ajouter (sans l'id)
     * @return PollingPlace effectivement ajouté (avec id)
     */
    public PollingPlace add(final PollingPlace pollingPlace) {
        mongoTemplate.insert(pollingPlace);
        return pollingPlace;

    }

    /**
     * met à jour un User
     * @param pollingPlace User à modifier (avec id)
     */
    public void update(final PollingPlace pollingPlace) {

        mongoTemplate.save(pollingPlace);
    }

    /**
     * Supprime un User donné par son id
     * @param id pollingPlace
     */
    public void delete(final String id) {

        mongoTemplate.remove(new PollingPlace(id));
    }
}
