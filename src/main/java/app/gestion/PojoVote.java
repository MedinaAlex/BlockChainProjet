
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

    public String getChoice() {
        return choice;
    }

    public String getDepartment() {
        return department;
    }

    public String getCity() {
        return city;
    }

    public String getPollingPlaceId() {
        return pollingPlaceId;
    }

    @Override
    public String toString() {
        return "Pojo{" + "voteId=" + voteId + ", ballotId=" + ballotId + ", choice=" + choice + ", department=" + department + ", city=" + city + ", pollingPlaceId=" + pollingPlaceId + '}';
    }
    
    
}