
package app.adaptateur;

import app.bean.Vote;
import app.gestion.HyperledgerApi;
import java.io.IOException;
import java.util.Random;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

/**
 * Entry Point of REST services for ballot
 *
 */
@Component
@Path("/vote")
@Produces(MediaType.APPLICATION_JSON)
public class AdaptateurVote {

    HyperledgerApi api = new HyperledgerApi();

    /**
     * add a vote to the database
     * @param vote the ballot to add
     * @return an Ok Response with message
     * @throws java.io.IOException
     * @throws JSONException 
     */
    @POST
    public Response addVote(Vote vote) throws IOException, JSONException {

        System.out.println("addVote.VOTE: "+vote);
        JSONObject jsonVote = new JSONObject();
        jsonVote.put("ballotId", vote.getBallotId());
        jsonVote.put("choice", vote.getChoice());
        jsonVote.put("department", vote.getDepartment());
        jsonVote.put("city", vote.getCity());
        jsonVote.put("pollingPlaceId", vote.getPollingPlaceId());
        String voteId = api.getNextVoteId();
        jsonVote.put("voteId", voteId);

        JSONObject jsonVoteCast = new JSONObject();
        Random rand = new Random();
        jsonVoteCast.put("voteCastId", api.getNextVoteCastId());
        jsonVoteCast.put("electorNum", String.valueOf(rand.nextInt(50000) + 1));
        jsonVoteCast.put("firstName", "firstname");
        jsonVoteCast.put("lastName", "lastname");
        jsonVoteCast.put("ballotId", vote.getBallotId());
        jsonVoteCast.put("pollingPlaceId", vote.getPollingPlaceId());

        api.post("Vote", jsonVote);
        api.post("VoteCast", jsonVoteCast);

        return Response.ok("added vote", MediaType.APPLICATION_JSON).build();
    }
    
}
