package com.kit.controllledwithesp.device;

public class Status {
	
	private long status;
	
	public Status() {
		this.status = 0;
	}

	public  long getStatus() {
		return this.status;
	}
	
	public  void setStatic(long s) {
		this.status = s;
	}

}
