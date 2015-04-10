package andre.exploringmars.input;

import java.util.ArrayList;
import java.util.List;

import andre.exploringmars.model.Direction;
import andre.exploringmars.model.Grid;
import andre.exploringmars.model.Probe;
import andre.exploringmars.model.ProbeCommand;

public class InputTransformer {
	
	
	//converts a grid size line to a Grid instance
	public static Grid gridInputLineToGrid(String gridInputLine){
		gridInputLine = gridInputLine.trim();
		String[] splitted = gridInputLine.split("\\s+");
		Grid grid = new Grid(Integer.valueOf(splitted[0]), Integer.valueOf(splitted[1]));
		return grid;
	}
	
	
	//converts a probe position line to a Probe instance
	public static Probe probeInputLinesToProbe(Grid grid, String probePositionInputLine, String probeCommandsInputLine){
		probePositionInputLine = probePositionInputLine.trim();
		String[] splited = probePositionInputLine.split("\\s+");
		Probe probe = new Probe(Integer.valueOf(splited[0]), 
				Integer.valueOf(splited[1]), 
				Direction.fromCharacter(splited[2].charAt(0)),
				commandInputLineToProbeCommandList(probeCommandsInputLine),
				grid);
		
		return probe;
	}
	
	
	//converts a probe commands input line to a list of ProbeCommand
	public static List<ProbeCommand> commandInputLineToProbeCommandList(String probeCommandsInputLine){
		probeCommandsInputLine = probeCommandsInputLine.trim();
		List<ProbeCommand> commands = new ArrayList<ProbeCommand>();
		for(char c : probeCommandsInputLine.toCharArray()){
			commands.add(ProbeCommand.fromCharacter(c));
		}
		return commands;
	}
	
	
	
}
