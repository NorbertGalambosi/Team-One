package Validator;
import DomainClasses.Listeners;

public class Validator_Listeners implements  IValidator<Listeners> {
    @Override
    public void validate(Listeners listeners) throws Validator_Exception {
        //verificarea ID-ului entitatii se face in baza de date = > sql exception
        if (listeners.getName().equals("")){
            throw(new Validator_Exception("Listeners name cannot be empty"));
        }
        if (listeners.getUsername().equals("")){
            throw(new Validator_Exception("Listeners username cannot be empty"));
        }
        if (listeners.getPassword().equals("")){
            throw(new Validator_Exception("Listeners password cannot be empty"));
        }
        if (!listeners.getEmail().contains(".") || !listeners.getEmail().contains("@") || listeners.getEmail().equals("")){
            throw(new Validator_Exception("Wrong listeners email format"));
        }
    }
}
