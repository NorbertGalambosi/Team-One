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
    protected Date proposalsDeadline;
    protected Date abstractDeadline;
    protected Date biddingDeadline;
    protected Date reviewsDedline;
    protected Integer nrParticipants;
    protected boolean activ;

    public Conference(){

    }

    public Conference(Integer id, String name, Integer edition, String interval, String callForPapers, Date proposalsDeadline, Date abstractDeadline, Date biddingDeadline, Date reviewsDedline, Integer nrParticipants, boolean activ) {
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

    public Date getProposalsDeadline() {
        return proposalsDeadline;
    }

    public void setProposalsDeadline(Date proposalsDeadline) {
        this.proposalsDeadline = proposalsDeadline;
    }

    public Date getAbstractDeadline() {
        return abstractDeadline;
    }

    public void setAbstractDeadline(Date abstractDeadline) {
        this.abstractDeadline = abstractDeadline;
    }

    public Date getBiddingDeadline() {
        return biddingDeadline;
    }

    public void setBiddingDeadline(Date biddingDeadline) {
        this.biddingDeadline = biddingDeadline;
    }

    public Date getReviewsDedline() {
        return reviewsDedline;
    }

    public void setReviewsDedline(Date reviewsDedline) {
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
}
