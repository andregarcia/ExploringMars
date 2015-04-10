package andre.exploringmars.model;

import andre.exploringmars.exception.InvalidProbeCommandException;

public enum ProbeCommand {
	
	LEFT,
	RIGHT,
	MOVE;
	
	public static ProbeCommand fromCharacter(Character c){
		if(c=='L') return LEFT;
		if(c=='R') return RIGHT;
		if(c=='M') return MOVE;
		throw new InvalidProbeCommandException(c.toString());
	}
	
}
