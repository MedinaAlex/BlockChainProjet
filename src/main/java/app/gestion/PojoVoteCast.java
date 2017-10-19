
package app.gestion;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Allows JSONObject to List conversion for VoteCast object
 */
class PojoVoteCast {

    @JsonProperty
    private String $class;

    @JsonProperty
    private String voteCastId;

    @JsonProperty
    private String electorNum;

    @JsonProperty
    private String ballotId;

    @JsonProperty
    private String firstName;

    @JsonProperty
    private String lastName;

    @JsonProperty
    private String pollingPlaceId;

    /**
     * Get the voteCast id
     * 
     * @return the voteCast id
     */
    public String getVoteCastId() {
        return voteCastId;
    }

    /**
     * Get the elector's number
     * 
     * @return the elector's number
     */
    public String getElectorNum() {
        return electorNum;
    }

    /**
     * Get the ballot id
     * 
     * @return the ballot id
     */
    public String getBallotId() {
        return ballotId;
    }

}
