
package app.gestion;

import com.fasterxml.jackson.annotation.JsonProperty;

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

    public String getVoteId() {
        return voteId;
    }

    public String getBallotId() {
        return ballotId;
    }

    @Override
    public String toString() {
        return "Pojo{" + "voteId=" + voteId + ", ballotId=" + ballotId + ", choice=" + choice + ", department=" + department + ", city=" + city + ", pollingPlaceId=" + pollingPlaceId + '}';
    }
    
    
}