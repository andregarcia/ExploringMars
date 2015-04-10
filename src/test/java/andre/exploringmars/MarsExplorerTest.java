package andre.exploringmars;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.google.common.collect.Lists;

public class MarsExplorerTest {

	@Test
	public void testCreateProbesAndExploreMars() {
		
		List<String> inputLines = Lists.newArrayList();
				
		inputLines.add("5 5");
		inputLines.add("1 2 N");
		inputLines.add("LMLMLMLMM");
		inputLines.add("3 3 E");
		inputLines.add("MMRMMRMRRM");
		
		List<String> results = MarsExplorer.createProbesAndExploreMars(inputLines);
		
		Assert.assertEquals(2, results.size());
		Assert.assertEquals("1 3 N", results.get(0));
		Assert.assertEquals("5 1 E", results.get(1));
		
	}

}
