package Day5.ClassRoster.DAO;
/*
    Now we'll create the application-specific exception for our project. As we discussed earlier,
    the purpose of this exception is to allow us to hide the underlying implementation exceptions so
    that we don't leak implementation details from our DAO.
    This is common practice when creating specific exceptions for your application. By extending Exception,
    we inherit all of the capabilities of Exception and then can add any special features that we wish to add.
    In our case, we won't add any new features — we want our exception to act just like Exception but extending Exception allows us to translate and/or wrap any implementation-specific exception that can get thrown, which is exactly the feature we're interested in. Remember that when we extend Exception, our new exception will be a checked exception.
 */

public class ClassRosterPersistenceException extends Exception{
    public ClassRosterPersistenceException(String message) {
        super(message);
    }

    public ClassRosterPersistenceException(String message, Throwable cause) {
        super(message, cause);
    }
}
