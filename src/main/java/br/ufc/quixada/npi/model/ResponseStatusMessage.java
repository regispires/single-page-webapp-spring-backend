package br.ufc.quixada.npi.model;

import br.ufc.quixada.npi.enumeration.ResponseStatus;

public class ResponseStatusMessage {

	private ResponseStatus status;
	
	private String message;

	public ResponseStatusMessage(ResponseStatus status, String message) {
		this.status = status;
		this.message = message;
	}

	public ResponseStatus getStatus() {
		return status;
	}

	public void setStatus(ResponseStatus status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
