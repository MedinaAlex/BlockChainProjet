
package app.gestion;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.StringWriter;
import org.json.JSONObject;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

/**
 *
 * DESCRIPTION FICHIER
 */
public class HyperledgerApi {

    String baseurl = "http://148.100.5.91:3000/api/";

    public void get(String object, JSONObject parameters) throws IOException {

        String url = this.baseurl+"epsi.app."+object;

        if (parameters != null) {
            StringWriter out = new StringWriter();
            parameters.getString(url);
            url += "/"+out;
        }

        System.out.println(url);

        HttpURLConnection con = this.getConnection(url, "GET");

        BufferedReader br = new BufferedReader(new InputStreamReader((con.getInputStream())));

        String output;
        System.out.println("Output from Server .... \n");
        while ((output = br.readLine()) != null) {
            System.out.println(output);
        }

        con.disconnect();
    }

    public void post(String object, JSONObject json) throws IOException {

        String url = this.baseurl+"epsi.app."+object;

        HttpURLConnection con = this.getConnection(url, "POST");

        String input = json.toString();
        System.out.println("post.INPUT"+object+": "+input);
        
        OutputStream os = con.getOutputStream();
        os.write(input.getBytes());
        os.flush();

        if (con.getResponseCode() != HttpURLConnection.HTTP_OK) {
            throw new RuntimeException("Failed : "
                    + con.getResponseCode()+" "+con.getResponseMessage());
        }

        BufferedReader br = new BufferedReader(new InputStreamReader((con.getInputStream())));

        String output;
        System.out.println("Output from Server .... \n");
        while ((output = br.readLine()) != null) {
                System.out.println(output);
        }

        con.disconnect();

    }

    public void selectElectorByElectorNum(String electorNum) throws IOException {

        String url = this.baseurl+"queries/selectElectorByElectorNum?electorNum="+electorNum;

        HttpURLConnection con = this.getConnection(url, "GET");

        BufferedReader br = new BufferedReader(new InputStreamReader((con.getInputStream())));

        String output = br.readLine();

        System.out.println(output);

        con.disconnect();
    }

    public String getNextVoteId() throws IOException {

        String url = this.baseurl+"queries/selectVote";

        HttpURLConnection con = this.getConnection(url, "GET");

        BufferedReader br = new BufferedReader(new InputStreamReader((con.getInputStream())));

        String output = br.readLine();

        ObjectMapper mapper = new ObjectMapper();
        List<PojoVote> liste = (mapper.readValue(output, new TypeReference<List<PojoVote>>(){}));
        System.out.println(liste);
        int id = 0;
        for(PojoVote vote : liste) {

            int idCourant = Integer.parseInt(vote.getVoteId());
            if(idCourant > id) {
                id = idCourant;
            }
        }

        con.disconnect();
        
        return String.valueOf(++id);
    }

    public String getNextVoteCastId() throws IOException {

        String url = this.baseurl+"epsi.app.VoteCast";

        HttpURLConnection con = this.getConnection(url, "GET");

        BufferedReader br = new BufferedReader(new InputStreamReader((con.getInputStream())));

        String output = br.readLine();

        ObjectMapper mapper = new ObjectMapper();
        List<PojoVoteCast> liste = (mapper.readValue(output, new TypeReference<List<PojoVoteCast>>(){}));
        System.out.println(liste);
        int id = 0;
        for(PojoVoteCast vote : liste) {

            int idCourant = Integer.parseInt(vote.getVoteCastId());
            if(idCourant > id) {
                id = idCourant;
            }
        }

        con.disconnect();
        
        return String.valueOf(++id);
    }

    private HttpURLConnection getConnection(String url, String type) throws MalformedURLException, IOException {

        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        con.setRequestMethod(type);
        con.setRequestProperty("Accept", "application/json");

        if (type.equals("POST")) {
            con.setDoOutput(true);
            con.setRequestProperty("Content-Type", "application/json");
        } else if (type.equals("GET")) {
            if (con.getResponseCode() != HttpURLConnection.HTTP_OK) {
                throw new RuntimeException("Failed : "
                        + con.getResponseCode()+" "+con.getResponseMessage());
            }
        }

        return con;
    }
}
