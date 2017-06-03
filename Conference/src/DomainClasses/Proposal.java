package DomainClasses;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Waiting on 20-May-17.
 */
public class Proposal implements Identifiable<Integer> {
    protected Integer id;
    protected String name;
    protected Paper fullPaper;
    protected Paper abstractPaper;
    protected String keywords;
    protected String topics;
    protected boolean accepted;
    protected PcMember autor;
    protected List<PcMember> reviewers = new ArrayList<>();
    protected List<PcMember> bidders = new ArrayList<>();

    public Proposal(Integer id, String name, Paper fullPaper, Paper abstractPaper, String keywords, String topics, boolean accepted, PcMember autor, List<PcMember> reviewers, List<PcMember> bidders) {
        this.id = id;
        this.name = name;
        this.fullPaper = fullPaper;
        this.abstractPaper = abstractPaper;
        this.keywords = keywords;
        this.topics = topics;
        this.accepted = accepted;
        this.autor = autor;
        this.reviewers = reviewers;
        this.bidders = bidders;
    }

    public Proposal() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Paper getFullPaper() {
        return fullPaper;
    }

    public void setFullPaper(Paper fullPaper) {
        this.fullPaper = fullPaper;
    }

    public Paper getAbstractPaper() {
        return abstractPaper;
    }

    public void setAbstractPaper(Paper abstractPaper) {
        this.abstractPaper = abstractPaper;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getTopics() {
        return topics;
    }

    public void setTopics(String topics) {
        this.topics = topics;
    }

    public boolean isAccepted() {
        return accepted;
    }

    public void setAccepted(boolean accepted) {
        this.accepted = accepted;
    }

    public List<PcMember> getBidders() {
        return bidders;
    }

    public void setBidders(List<PcMember> bidders) {
        this.bidders = bidders;
    }

    public PcMember getAutor() {
        return autor;
    }

    public void setAutor(PcMember autor) {
        this.autor = autor;
    }

    public List<PcMember> getReviewers() {
        return reviewers;
    }

    public void setReviewers(List<PcMember> reviewers) {
        this.reviewers = reviewers;
    }

    public void addBidder(PcMember bidder){
        bidders.add(bidder);
    }

    public void addReviewer(PcMember reviewer){
        if (reviewer != null)
            reviewers.add(reviewer);
    }

    @Override
    public void setid(Integer integer) {
        this.id=integer;
    }

    @Override
    public Integer getid() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Proposal{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", fullPaper=" + fullPaper +
                ", abstractPaper=" + abstractPaper +
                ", keywords='" + keywords + '\'' +
                ", topics='" + topics + '\'' +
                ", accepted=" + accepted +
                ", autor=" + autor +
                ", reviewers=" + reviewers +
                ", bidders=" + bidders +
                '}';
    }
    public String toStringJS(){
        return id+";"+name+";"+keywords+";"+topics+";"+accepted+";"+autor.getName();
    }
}
