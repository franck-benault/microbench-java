package net.franckbenault.microbench.object;

public class MyObject {

	protected String att1;
	protected String att2;
	protected String att3;
	
	public MyObject() {
	}
	
	public MyObject(int i) {
		this.att1 = "att1-"+i;
		this.att2 = "att2-"+i;
		this.att3 = "att3-"+i;
	}
	
	@Override
	public String toString() {
		return "MyObject{att1=" + att1 + ", att2=" + att2 + ", att3=" + att3 + "}";
	}

	
	
}
