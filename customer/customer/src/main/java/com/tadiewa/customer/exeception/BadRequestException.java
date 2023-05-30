/**
 * @author : tadiewa
 * date: 5/12/2023
 */


package com.tadiewa.customer.exeception;

public class BadRequestException extends BaseException {
    public BadRequestException(String errorCode, String errorMessage, Object... parameters) {
        super(errorCode, String.format(errorMessage, parameters));
    }
}
