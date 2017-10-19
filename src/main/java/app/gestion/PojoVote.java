
package app.gestion;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Allows JSONObject to List conversion for Vote object
 */
public class PojoVote {

    @JsonProperty
    private String $class;

    @JsonProperty
    private String voteId;

    @JsonProperty
    private String ballotId;

    @JsonProperty
    private String choice;

    @JsonProperty
    private String department;

    @JsonProperty
    private String city;

    @JsonProperty
    private String pollingPlaceId;

    /**
     * Get the vote id
     * 
     * @return the vote id
     */
    public String getVoteId() {
        return voteId;
    }

    /**
     * Get the ballot id
     * 
     * @return the ballot id
     */
    public String getBallotId() {
        return ballotId;
    }

    /**
     * Returns a {@code String} object representing the
     * specified integer.
     * 
     * @return a string representation of the object.
     */
    @Override
    public String toString() {
        return "Pojo{" + "voteId=" + voteId + ", ballotId=" + ballotId + ", choice=" + choice + ", department=" + department + ", city=" + city + ", pollingPlaceId=" + pollingPlaceId + '}';
    }
    
    
}