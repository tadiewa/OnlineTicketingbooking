/**
 * @author : tadiewa
 * date: 5/12/2023
 */


package com.tadiewa.customer.exeception;


public enum Error {

    USER_NOT_FOUND("userNotFound", "User is not found in the database."),
    USER_ALREADY_EXISTS("userAlreadyExists", "There is a user with these credentials, please login.");

    private final String errorCode;
    private final String errorMessage;

    Error(String errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

}
