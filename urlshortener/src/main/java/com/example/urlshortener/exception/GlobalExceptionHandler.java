package com.example.urlshortener.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.urlshortener.constant.Status;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	public static class ErrorRepsponse{		
		private final String status;
		private final String message;
		
		public ErrorRepsponse(String status, String message) {
			this.status = status;
			this.message = message;
		}

		public String getStatus() {
			return status;
		}

		public String getMessage() {
			return message;
		}
		
	}
	
	@ExceptionHandler(URLNotFoundException.class)
	public ResponseEntity<ErrorRepsponse> handleURLNotFoundException(URLNotFoundException ex){		
		System.err.println("Handling \"URL Not Found Exception\": " + ex.getMessage());
		ErrorRepsponse errorRepsponse = new ErrorRepsponse(Status.Fail.name(), ex.getMessage());
		return new ResponseEntity<>(errorRepsponse, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorRepsponse> unkownError(Exception ex){		
		System.err.println("Handling \"Uknown Exception\": " + ex.getMessage());
		ErrorRepsponse errorRepsponse = new ErrorRepsponse(Status.Fail.name(), ex.getMessage());
		return new ResponseEntity<>(errorRepsponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
