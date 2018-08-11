package com.ulises.appsserver.constants;

public class Constants {
    public static final String RESPONSE_ERROR_APP_EXISTS = "There is already an App with this name.";
    public static final String RESPONSE_ERROR_NO_APPS = "No Apps found.";
    public static final String RESPONSE_OK_APP_CREATED = "App created successfully.";
    public static final String REQUEST_ERROR_INTERNAL_SERVER_ERROR = "There has been a server error and your request " +
            "couldn't be processed.";
    public static final String REQUEST_ERROR_NOT_FOUND = "This endpoint doesn't exist.";
    public static final String REQUEST_ERROR_NULL_BODY = "Request's body must not be null.";

}
