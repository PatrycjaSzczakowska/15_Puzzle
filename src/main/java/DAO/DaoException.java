package DAO;

public class DaoException extends Exception {

    public DaoException(final String message) {
        super(message);
    }

    public DaoException(final String message, final Throwable cause) {
        super(message, cause);
    }
}
