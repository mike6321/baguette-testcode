package com.github.fourteam.pikachu.week1.imesung.domain.customer;

import lombok.Builder;
import lombok.Getter;

public class ExecutivesCust extends Customer {

	private String retireDate;
	
	@Override
	public boolean chkCustomerGubun() {
		if(super.getPoint() == 0L || retireDate == null) {
			return false;
		}
		return true;
	}

}
