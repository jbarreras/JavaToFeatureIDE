package code;

import annotation.*;

@Feature
public class TestClass {

	int i;
	String s;
	Object o;

	@Feature(featureName = "TestClass")
	public TestClass() {
	}

	@Feature(featureName = "TestClass")
	private void foo() {
		this.i++;
	}
}
