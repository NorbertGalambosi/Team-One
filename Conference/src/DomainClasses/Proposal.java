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

    @Override
    public void setid(Integer integer) {
        this.id=integer;
    }

    @Override
    public Integer getid() {
        return this.id;
    }

}
