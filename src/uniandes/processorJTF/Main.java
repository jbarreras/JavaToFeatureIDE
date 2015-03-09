package uniandes.processorJTF;

public class Main {

	public static void main(String[] args) {
		Spoon spoon = new Spoon();
		spoon.Analyze("./src/uniandes/cupi2",
				"uniandes.processorJTF.SpoonProcessor");
	}
}
