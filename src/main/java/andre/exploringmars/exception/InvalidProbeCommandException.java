package andre.exploringmars.exception;

public class InvalidProbeCommandException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8718120974684090440L;

	
	public InvalidProbeCommandException(String probeCommand){
		super(String.format("The specified probe command '%s' is invalid.", probeCommand));
	}
	
	
}
