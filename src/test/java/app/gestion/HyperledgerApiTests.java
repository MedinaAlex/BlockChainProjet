
package app.gestion;

import org.junit.Test;
import org.json.JSONObject;
import org.springframework.boot.test.context.SpringBootTest;

/**
 *
 * DESCRIPTION FICHIER
 */
@SpringBootTest
public class HyperledgerApiTests {

    @Test
    public void test() throws Exception {
        HyperledgerApi api = new HyperledgerApi();
        
        /*
            test POST
        
        
        JSONObject obj = new JSONObject();
        obj.put("voteId", "monVote");
        obj.put("ballotId", "string");
        obj.put("choice", "string");
        obj.put("department", "string");
        obj.put("city", "string");
        obj.put("pollingPlaceId", "string");
        api.postVote(obj);
        
        /*
            test GET avec filtres
        
        JSONObject values = new JSONObject();
        values.put("ballotId", "string");

        JSONArray where = new JSONArray();
        where.put(values);
        JSONObject obj = new JSONObject();
        obj.put("where", where);
        System.out.println(obj);
        api.getVote(obj);
        // */
        
        /*
            test queries
        */
        //api.selectElectorByElectorNum("1");
        //api.addVote();
        // */
        
        JSONObject json = new JSONObject();
        json.put("ballotId", "1");
        json.put("choice", "1");
        json.put("department", "1");
        json.put("city", "1");
        json.put("pollingPlaceId", "0001");
        api.post("Vote", json);
        
        JSONObject json2 = new JSONObject();
        json2.put("voteCastId", "1");
        json2.put("electorNum", "1245101425");
        json2.put("firstName", "First");
        json2.put("lastName", "Last");
        json2.put("ballotId", "1");
        api.post("VoteCast", json2);
        
        api.get("Vote", null);
        api.get("VoteCast", null);
    }
}
