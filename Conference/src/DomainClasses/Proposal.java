package DomainClasses;

import java.io.Serializable;

/**
 * Created by Waiting on 20-May-17.
 */
public class Proposal implements Serializable,Identifiable<Integer> {
    protected Integer id;
    protected String name;
    protected Paper fullPaper;
    protected Paper abstractPaper;
    protected String keywords;
    protected String topics;
    protected boolean accepted;
    protected PcMember autor;
    protected Iterable<PcMember> reviewers;
    protected Iterable<PcMember> bidders;

    public Proposal(Integer id, String name, Paper fullPaper, Paper abstractPaper, String keywords, String topics, boolean accepted, PcMember autor, Iterable<PcMember> reviewers, Iterable<PcMember> bidders) {
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

    public Iterable<PcMember> getBidders() {
        return bidders;
    }

    public void setBidders(Iterable<PcMember> bidders) {
        this.bidders = bidders;
    }

    public PcMember getAutor() {
        return autor;
    }

    public void setAutor(PcMember autor) {
        this.autor = autor;
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
                ", bidders=" + bidders +
                '}';
    }
}
