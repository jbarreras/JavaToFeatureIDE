package uniandes.processorJTF;

import spoon.Launcher;

public class Spoon {

	public void Analyze(String source, String processor) {

		String[] spoonArgs = new String[6];
		spoonArgs[0] = "-i";
		spoonArgs[1] = source;
		spoonArgs[2] = "-p";
		spoonArgs[3] = processor;
		spoonArgs[4] = "--compliance";
		spoonArgs[5] = "7";
		// spoonArgs[6] = "-o";
		// spoonArgs[7] = "./src/main/java";
		try {
			Launcher.main(spoonArgs);
		} catch (Exception e) {
			System.err.println("Error while executing spoon launcher "
					+ e.getMessage());
			e.printStackTrace();
			System.exit(1);
		}
	}

}
