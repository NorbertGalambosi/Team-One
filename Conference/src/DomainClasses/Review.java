package DomainClasses;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Waiting on 20-May-17.
 */
public class Review implements Serializable,Identifiable<Integer> {
    protected Integer id;
    protected Integer idReviewer;
    protected Integer idPaper;
    protected String recommendation;
    protected String qualifier;

    public Review(Integer id, Integer idReviewer, Integer idPaper, String recommendation, String qualifier) {
        this.id = id;
        this.idReviewer = idReviewer;
        this.idPaper = idPaper;
        this.recommendation = recommendation;
        this.qualifier = qualifier;
    }
    public Review()
    {}

    public Review( Integer idReviewer, Integer idPaper, String recommendation, String qualifier) {
        this.idReviewer = idReviewer;
        this.idPaper = idPaper;
        this.recommendation = recommendation;
        this.qualifier = qualifier;
    }

    public Review() {

    }

    @Override
    public void setid(Integer integer) {
        this.id=integer;
    }

    @Override
    public Integer getid() {
        return this.id;
    }

    public Integer getIdReviewer() {
        return idReviewer;
    }

    public void setIdReviewer(Integer idReviewer) {
        this.idReviewer = idReviewer;
    }

    public Integer getIdPaper() {
        return idPaper;
    }

    public void setIdPaper(Integer idPaper) {
        this.idPaper = idPaper;
    }

    public String getRecommendation() {
        return recommendation;
    }

    public void setRecommendation(String recommendation) {
        this.recommendation = recommendation;
    }

    public String getQualifier() {
        return qualifier;
    }

    public void setQualifier(String qualifier) {
        this.qualifier = qualifier;
    }

    @Override
    public String toString() {
        return "Review{" +
                "id=" + id +
                ", idReviewer=" + idReviewer +
                ", idPaper=" + idPaper +
                ", recommendation='" + recommendation + '\'' +
                ", qualifier='" + qualifier + '\'' +
                '}';
    }
}
