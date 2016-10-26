package net.franckbenault.microbench.object;

public class MyObject {

	protected String att1;
	protected String att2;
	protected String att3;
	
	public MyObject() {
	}
	
	public MyObject(String att1, String att2, String att3) {
		this.att1 = att1;
		this.att2 = att2;
		this.att3 = att3;
	}
	
	@Override
	public String toString() {
		return "MyObject [att1=" + att1 + ", att2=" + att2 + ", att3=" + att3 + "]";
	}

	
	
}
