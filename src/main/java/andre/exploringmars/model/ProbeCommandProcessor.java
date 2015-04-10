package andre.exploringmars.model;




public class ProbeCommandProcessor {
	
	
	public static void processProbeCommand(Probe probe, ProbeCommand probeCommand){
		
		//when move command
		if(probeCommand.equals(ProbeCommand.MOVE)){
			processProbeMoveCommand(probe);
		}
		
		//when turn command
		else if(probeCommand.equals(ProbeCommand.LEFT) || probeCommand.equals(ProbeCommand.RIGHT)){
			processProbeTurnCommand(probe, probeCommand);
		}
	}
	
	
	private static void processProbeMoveCommand(Probe probe){
		if(probe.getCurrentDirection().equals(Direction.NORTH)){
			probe.setCurrentY(probe.getCurrentY() + 1);
		}
		else if(probe.getCurrentDirection().equals(Direction.SOUTH)){
			probe.setCurrentY(probe.getCurrentY() -1) ;
		}
		else if(probe.getCurrentDirection().equals(Direction.EAST)){
			probe.setCurrentX(probe.getCurrentX() + 1);
		}
		else if(probe.getCurrentDirection().equals(Direction.WEST)){
			probe.setCurrentX(probe.getCurrentX() - 1);
		}
	}
	
	
	
	private static void processProbeTurnCommand(Probe probe, ProbeCommand probeCommand){
		
		//when pointing north
		if(probe.getCurrentDirection().equals(Direction.NORTH) && probeCommand.equals(ProbeCommand.RIGHT)){
			probe.setCurrentDirection(Direction.EAST);
		}
		else if(probe.getCurrentDirection().equals(Direction.NORTH) && probeCommand.equals(ProbeCommand.LEFT)){
			probe.setCurrentDirection(Direction.WEST);
		}
		
		//when pointing east
		else if(probe.getCurrentDirection().equals(Direction.EAST) && probeCommand.equals(ProbeCommand.RIGHT)){
			probe.setCurrentDirection(Direction.SOUTH);
		}
		else if(probe.getCurrentDirection().equals(Direction.EAST) && probeCommand.equals(ProbeCommand.LEFT)){
			probe.setCurrentDirection(Direction.NORTH);
		}
		
		//when pointing south
		else if(probe.getCurrentDirection().equals(Direction.SOUTH) && probeCommand.equals(ProbeCommand.RIGHT)){
			probe.setCurrentDirection(Direction.WEST);
		}
		else if(probe.getCurrentDirection().equals(Direction.SOUTH) && probeCommand.equals(ProbeCommand.LEFT)){
			probe.setCurrentDirection(Direction.EAST);
		}
		
		//when pointing west
		else if(probe.getCurrentDirection().equals(Direction.WEST) && probeCommand.equals(ProbeCommand.RIGHT)){
			probe.setCurrentDirection(Direction.NORTH);
		}
		else if(probe.getCurrentDirection().equals(Direction.WEST) && probeCommand.equals(ProbeCommand.LEFT)){
			probe.setCurrentDirection(Direction.SOUTH);
		}
	}

}
