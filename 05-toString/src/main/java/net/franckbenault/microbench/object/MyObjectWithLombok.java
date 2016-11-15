package net.franckbenault.microbench.object;

import lombok.ToString;

@ToString(callSuper=false, includeFieldNames=true)
public class MyObjectWithLombok extends MyObject {

	
	public MyObjectWithLombok() {
	}
	
	public MyObjectWithLombok(int i) {
		this.att1 = "att1-"+i;
		this.att2 = "att2-"+i;
		this.att3 = "att3-"+i;
	}

	


	
	
}
