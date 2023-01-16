package it.epicode.exercise;

public class BancaException extends Exception{
	
	private final String message;
	
	public BancaException(String msg) {
		super(msg);
		this.message=msg;
	}
	
	@Override
	public String toString() {
		return this.message;
	}

}
