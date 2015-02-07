package com.geiswinkler.yasl.rest.exception;

/**
 * Created by mike on 07.02.2015.
 */
public class YASLException extends Exception {
    public YASLException() {
        super();
    }

    public YASLException( String message ) {
        super( message );
    }

    public YASLException( String message, Throwable cause ) {
        super( message, cause );
    }
}
