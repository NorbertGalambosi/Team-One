package ConferencePersistence.Repository;

/**
 * Created by Waiting on 23-May-17.
 */
public interface IRepository<ID, T> {
    void save(T entity);
    Iterable<T> findAll();
    T findOne(ID id);
}
