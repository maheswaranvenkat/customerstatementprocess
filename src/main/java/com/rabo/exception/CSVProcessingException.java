package com.rabo.exception;

/**
 * Exception class.
 *
 * @author Maheswaran Venkatraman
 * @date 18 June 2018
 */

public class CSVProcessingException extends Exception {
    private static final long serialVersionUID = 1L;
    public CSVProcessingException(String message) {
        super(message);
    }

}
