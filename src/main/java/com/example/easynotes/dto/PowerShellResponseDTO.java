package com.example.easynotes.dto;

public class PowerShellResponseDTO {
	private String message;
    private int status;

    public PowerShellResponseDTO(String message, int status) {
        this.message = message;
        this.status = status;
    }

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

    
}

