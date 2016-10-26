package net.franckbenault.microbench.object;

import java.util.Objects;

public class MyObjectWithObjectsToString extends MyObject {

	
	public MyObjectWithObjectsToString() {
	}
	
	public MyObjectWithObjectsToString(String att1, String att2, String att3) {
		this.att1 = att1;
		this.att2 = att2;
		this.att3 = att3;
	}

	
	@Override
	public String toString() {
		return "MyObject [att1=" + Objects.toString(att1) +
				", att2=" + Objects.toString(att2) +
				", att3=" + Objects.toString(att3) + "]";
	}

	
	
}
