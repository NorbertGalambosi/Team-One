package ConferencePersistence.Repository;

import java.sql.SQLException;

/**
 * Created by Waiting on 23-May-17.
 */
public interface IRepository<ID, T> {
    void save(T entity) throws SQLException;
    Iterable<T> findAll();
    T findOne(ID id);
}
