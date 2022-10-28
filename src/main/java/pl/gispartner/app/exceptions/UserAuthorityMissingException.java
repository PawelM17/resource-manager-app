package pl.gispartner.app.exceptions;

public class UserAuthorityMissingException extends RuntimeException {
    public UserAuthorityMissingException(String message) {
        super(message);
    }
}
