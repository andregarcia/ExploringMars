package andre.exploringmars;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import com.google.common.collect.Lists;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
		try {
			List<String> lines = readFile(args[0]);
			List<String> results = MarsExplorer.createProbesAndExploreMars(lines);
			printResults(results);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
    }
    
    
    private static List<String> readFile(String filename) throws IOException{
		//read file
		BufferedReader br = new BufferedReader(new FileReader(filename));
		String line;
		List<String> lines = Lists.newArrayList();
		while((line = br.readLine())!=null){
			if(!line.isEmpty()){
				lines.add(line);
			}
		}
		br.close();
		return lines;
    }
    
    
    public static void printResults(List<String> results){
    	for(String s : results){
    		System.out.println(s);
    	}
    }
    
}
