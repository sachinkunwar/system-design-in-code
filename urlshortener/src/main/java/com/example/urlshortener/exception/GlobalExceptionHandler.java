package com.example.urlshortener.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	public static class ErrorRepsponse{		
		private final int status;
		private final String message;
		
		public ErrorRepsponse(int status, String message) {
			this.status = status;
			this.message = message;
		}

		public int getStatus() {
			return status;
		}

		public String getMessage() {
			return message;
		}
		
	}
	
	@ExceptionHandler(URLNotFoundException.class)
	public ResponseEntity<ErrorRepsponse> handleURLNotFoundException(URLNotFoundException ex){		
		System.err.println("Handling URL Not Found Exception: " + ex.getMessage());
		ErrorRepsponse errorRepsponse = new ErrorRepsponse(HttpStatus.NOT_FOUND.value(), ex.getMessage());
		return new ResponseEntity<>(errorRepsponse, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorRepsponse> handleURLNotFoundException(Exception ex){		
		System.err.println("Handling URL Not Found Exception: " + ex.getMessage());
		ErrorRepsponse errorRepsponse = new ErrorRepsponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.getMessage());
		return new ResponseEntity<>(errorRepsponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
