package com.rabo.exception;

/**
 * Exception class.
 *
 * @author Maheswaran Venkatraman
 * @date 18 June 2018
 */
public class CustomerStatementProcessException extends Exception {
    private static final long serialVersionUID = 1L;
    public CustomerStatementProcessException(String message) {
        super(message);
    }
}
