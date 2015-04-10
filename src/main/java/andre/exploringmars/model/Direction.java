package andre.exploringmars.model;

import andre.exploringmars.exception.InvalidDirectionException;

public enum Direction {

	NORTH,
	EAST,
	SOUTH,
	WEST;
	
	
	public static Direction fromCharacter(Character c) throws InvalidDirectionException{
		if(c=='N') return NORTH;
		if(c=='E') return EAST;
		if(c=='S') return SOUTH;
		if(c=='W') return WEST;
		throw new InvalidDirectionException(c.toString());
	}
	
	
	public static Character toCharacter(Direction d){
		if(d.equals(NORTH)) return 'N';
		if(d.equals(EAST)) return 'E';
		if(d.equals(SOUTH)) return 'S';
		if(d.equals(WEST)) return 'W';
		return null;
	}
}


