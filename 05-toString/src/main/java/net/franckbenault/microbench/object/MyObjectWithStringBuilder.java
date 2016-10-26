package net.franckbenault.microbench.object;


public class MyObjectWithStringBuilder extends MyObject {

	
	public MyObjectWithStringBuilder() {
	}
	
	public MyObjectWithStringBuilder(String att1, String att2, String att3) {
		this.att1 = att1;
		this.att2 = att2;
		this.att3 = att3;
	}

	
	@Override
	public String toString() {
		
	    final StringBuilder sb = new StringBuilder("MyObject[");
	    sb.append("att1='").append(att1);
	    sb.append(", att2='").append(att2);
	    sb.append(", att3='").append(att3).append(']');
	    return sb.toString();
	}

	
	
}
