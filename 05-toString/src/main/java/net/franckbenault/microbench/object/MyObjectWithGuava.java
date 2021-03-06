package net.franckbenault.microbench.object;

import com.google.common.base.MoreObjects;

public class MyObjectWithGuava extends MyObject {

	
	public MyObjectWithGuava() {
	}
	
	public MyObjectWithGuava(int i) {
		this.att1 = "att1-"+i;
		this.att2 = "att2-"+i;
		this.att3 = "att3-"+i;
	}

	

	public String toString2() {
		
	    final StringBuilder sb = new StringBuilder("MyObject[");
	    sb.append("att1='").append(att1);
	    sb.append(", att2='").append(att2);
	    sb.append(", att3='").append(att3).append(']');
	    return sb.toString();
	}

	@Override
	public String toString() {
	    return  MoreObjects.toStringHelper(this) 		
	    .add("att1", att1)
	    .add("att2", att2)
	    .add("att3", att3).toString();
	}
	
}
