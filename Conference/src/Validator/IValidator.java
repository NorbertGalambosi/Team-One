package ConferencePersistence.Validator;

import ConferencePersistence.Repository.IRepository;

public interface IValidator<E>{
    void validate (E entity) throws ValidatorException;
}
