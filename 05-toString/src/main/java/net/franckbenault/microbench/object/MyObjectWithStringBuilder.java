package net.franckbenault.microbench.object;


public class MyObjectWithStringBuilder extends MyObject {

	
	public MyObjectWithStringBuilder() {
	}
	
	public MyObjectWithStringBuilder(int i) {
		this.att1 = "att1-"+i;
		this.att2 = "att2-"+i;
		this.att3 = "att3-"+i;
	}
	
	@Override
	public String toString() {
		
	    final StringBuilder sb = new StringBuilder("MyObjectWithStringBuilder{");
	    sb.append("att1=").append(att1);
	    sb.append(", att2=").append(att2);
	    sb.append(", att3=").append(att3).append('}');
	    return sb.toString();
	}

	
	
}
