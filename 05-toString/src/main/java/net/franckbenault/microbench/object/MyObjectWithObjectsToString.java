package net.franckbenault.microbench.object;

import java.util.Objects;

public class MyObjectWithObjectsToString extends MyObject {

	
	public MyObjectWithObjectsToString() {
	}
	
	public MyObjectWithObjectsToString(int i) {
		this.att1 = "att1-"+i;
		this.att2 = "att2-"+i;
		this.att3 = "att3-"+i;
	}

	
	@Override
	public String toString() {
		return "MyObjectWithObjectsToString{att1=" + Objects.toString(att1) +
				", att2=" + Objects.toString(att2) +
				", att3=" + Objects.toString(att3) + "}";
	}

	
	
}
