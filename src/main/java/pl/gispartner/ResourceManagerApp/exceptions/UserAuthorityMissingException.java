package pl.gispartner.ResourceManagerApp.exceptions;

public class UserAuthorityMissingException extends RuntimeException {
    public UserAuthorityMissingException(String message) {
        super(message);
    }
}
