package com.possoul.SpringBootRestCrud.exceptions;

import java.util.Date;

public class ErrorDetails {
    private Date timestamp;
    private String message;
    private String details;
    private StackTraceElement[] stackTrace;
    private Throwable cause;

    public ErrorDetails(Date timestamp, String message, String details, Throwable throwable, StackTraceElement[] stackTraceElements) {
        super();
        this.timestamp = timestamp;
        this.message = message;
        this.details = details;
        this.cause = throwable;
        this.stackTrace = stackTraceElements;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public String getMessage() {
        return message;
   }

    public String getDetails() {
       return details;
   }

	public StackTraceElement[] getStackTrace() {
		return stackTrace;
	}

	public Throwable getCause() {
		return cause;
	}
    
}