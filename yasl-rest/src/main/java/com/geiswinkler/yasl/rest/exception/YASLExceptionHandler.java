package com.geiswinkler.yasl.rest.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * Created by mike on 07.02.2015.
 */
@Provider
public class YASLExceptionHandler implements ExceptionMapper<YASLException> {
    @Override
    public Response toResponse( YASLException exception ) {
        return Response.status( Response.Status.INTERNAL_SERVER_ERROR ).entity( exception.getMessage() ).build();
    }
}
