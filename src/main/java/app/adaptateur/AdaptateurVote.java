
package app.adaptateur;

import app.bean.Vote;
import app.gestion.HyperledgerApi;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
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

    HyperledgerApi api;
    
    /**
     * add a vote to the database
     * @param vote the ballot to add
     * @return an Ok Response with message
     * @throws java.io.IOException
     */
    @POST
    public Response addVote(Vote vote) throws IOException {

        JSONObject json = new JSONObject();
        json.put("ballotId", vote.getBallotId());
        json.put("choice", vote.getChoice());
        json.put("department", vote.getDepartment());
        json.put("pollingPlaceId", vote.getPollingPlaceId());
        json.put("voteId", api.getNextVoteId());

        api.post("Vote", json);

        return Response.ok("added vote", MediaType.APPLICATION_JSON).build();
    }
}
