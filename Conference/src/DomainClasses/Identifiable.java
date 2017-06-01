package DomainClasses;

/**
 * Created by Waiting on 20-May-17.
 */
public interface Identifiable<ID> {
    void setid(ID id);
    ID getid();
}
