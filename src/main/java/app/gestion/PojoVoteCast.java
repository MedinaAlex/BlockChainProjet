
package app.gestion;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * DESCRIPTION FICHIER
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

    public String getVoteCastId() {
        return voteCastId;
    }

    public String getElectorNum() {
        return electorNum;
    }

    public String getBallotId() {
        return ballotId;
    }

}
