package net.franckbenault.microbench.object;

import lombok.ToString;

@ToString(callSuper=false, includeFieldNames=true)
public class MyObjectWithLombok extends MyObject {

	
	public MyObjectWithLombok() {
	}
	
	public MyObjectWithLombok(String att1, String att2, String att3) {
		this.att1 = att1;
		this.att2 = att2;
		this.att3 = att3;
	}

	


	
	
}
