package DomainClasses;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by Waiting on 20-May-17.
 */
public class Conference implements Identifiable<Integer>,Serializable {
    protected Integer id;
    protected String name;
    protected Integer edition;
    protected String interval;
    protected String callForPapers;
    protected String proposalsDeadline;
    protected String abstractDeadline;
    protected String biddingDeadline;
    protected String reviewsDedline;
    protected Integer nrParticipants;
    protected boolean activ;

    public Conference(){

    }

    public Conference(Integer id, String name, Integer edition, String interval, String callForPapers, String proposalsDeadline, String abstractDeadline, String biddingDeadline, String reviewsDedline, Integer nrParticipants, boolean activ) {
        this.id = id;
        this.name = name;
        this.edition = edition;
        this.interval = interval;
        this.callForPapers = callForPapers;
        this.proposalsDeadline = proposalsDeadline;
        this.abstractDeadline = abstractDeadline;
        this.biddingDeadline = biddingDeadline;
        this.reviewsDedline = reviewsDedline;
        this.nrParticipants = nrParticipants;
        this.activ = activ;
    }

    @Override
    public void setid(Integer integer) {
        this.id=integer;
    }

    @Override
    public Integer getid() {
        return this.id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getEdition() {
        return edition;
    }

    public void setEdition(Integer edition) {
        this.edition = edition;
    }

    public String getInterval() {
        return interval;
    }

    public void setInterval(String interval) {
        this.interval = interval;
    }

    public String getCallForPapers() {
        return callForPapers;
    }

    public void setCallForPapers(String callForPapers) {
        this.callForPapers = callForPapers;
    }

    public String getProposalsDeadline() {
        return proposalsDeadline;
    }

    public void setProposalsDeadline(String proposalsDeadline) {
        this.proposalsDeadline = proposalsDeadline;
    }

    public String getAbstractDeadline() {
        return abstractDeadline;
    }

    public void setAbstractDeadline(String abstractDeadline) {
        this.abstractDeadline = abstractDeadline;
    }

    public String getBiddingDeadline() {
        return biddingDeadline;
    }

    public void setBiddingDeadline(String biddingDeadline) {
        this.biddingDeadline = biddingDeadline;
    }

    public String getReviewsDedline() {
        return reviewsDedline;
    }

    public void setReviewsDedline(String reviewsDedline) {
        this.reviewsDedline = reviewsDedline;
    }

    public Integer getNrParticipants() {
        return nrParticipants;
    }

    public void setNrParticipants(Integer nrParticipants) {
        this.nrParticipants = nrParticipants;
    }

    public boolean isActiv() {
        return activ;
    }

    public void setActiv(boolean activ) {
        this.activ = activ;
    }

    @Override
    public String toString() {
        return "Conference{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", edition=" + edition +
                ", interval='" + interval + '\'' +
                ", callForPapers='" + callForPapers + '\'' +
                ", proposalsDeadline=" + proposalsDeadline +
                ", abstractDeadline=" + abstractDeadline +
                ", biddingDeadline=" + biddingDeadline +
                ", reviewsDedline=" + reviewsDedline +
                ", nrParticipants=" + nrParticipants +
                ", activ=" + activ +
                '}';
    }

    public String getFullDeadline() {
        return "NU AVEM FULL DEADLINE IN CONFERENCE";
    }
}
