package andre.exploringmars;

import java.util.List;

import andre.exploringmars.input.InputTransformer;
import andre.exploringmars.model.Grid;
import andre.exploringmars.model.Probe;

import com.google.common.collect.Lists;

public class MarsExplorer {
    
	
	
    public static List<String> createProbesAndExploreMars(List<String> inputLines){
    	List<Probe> probes = createProbes(inputLines);
		return exploreMars(probes);
    }
    
    
    private static List<Probe> createProbes(List<String> inputLines){
		
		//create grid and probes
		Grid grid = InputTransformer.gridInputLineToGrid(inputLines.remove(0));
		List<Probe> probes = Lists.newArrayList();
		
		int probeNumber = 1;
		for(int i=0; i<inputLines.size(); ){
			String positionLine = inputLines.get(i);
			i += 1;
			String commandsLine = inputLines.get(i);
			i += 1;
			Probe probe = InputTransformer.probeInputLinesToProbe(grid, positionLine, commandsLine, probeNumber);
			probes.add(probe);
			probeNumber += 1;
		}
		return probes;
    }
    
    
    
    public static List<String> exploreMars(List<Probe> probes){
		//execute commands for each probe
		for(Probe p : probes){
			p.processAllProbeCommands();
		}
		
		//get output
		List<String> outputs = Lists.newArrayList();
		for(Probe p : probes){
			outputs.add(p.getAsStringForOutput());
		}
		return outputs;
    }
    
    
}
