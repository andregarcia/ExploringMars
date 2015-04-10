package andre.exploringmars.exception;

public class NoMoreProbeCommandsException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8599904256123844743L;

	
	
	public NoMoreProbeCommandsException(){
		super("The probe has no more probe commands to process");
	}
	
	
}
