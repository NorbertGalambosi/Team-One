package Validator;
import DomainClasses.Listeners;

public class ListenersValidator implements  IValidator<Listeners> {
    @Override
    public void validate(Listeners listeners) throws ValidatorException {
        //verificarea ID-ului entitatii se face in baza de date = > sql exception
        if (listeners.getName().equals("")){
            throw(new ValidatorException("Listeners name cannot be empty"));
        }
        if (listeners.getUsername().equals("")){
            throw(new ValidatorException("Listeners username cannot be empty"));
        }
        if (listeners.getPassword().equals("")){
            throw(new ValidatorException("Listeners password cannot be empty"));
        }
        if (!listeners.getEmail().contains(".") || !listeners.getEmail().contains("@") || listeners.getEmail().equals("")){
            throw(new ValidatorException("Wrong listeners email format"));
        }
    }
}
