package org.zerock.domain;

import lombok.Getter;

public class Criteria {

	@Getter
	private int page;
	
	public Criteria() {
		this.page = 1;
	}
	
	public Criteria(int page) {
		this.page = page;
	}
	
	public int getSkip() {
 		return (this.page -1 ) * 10; 
	}
}
