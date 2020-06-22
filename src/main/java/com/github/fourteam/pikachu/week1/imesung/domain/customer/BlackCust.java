package com.github.fourteam.pikachu.week1.imesung.domain.customer;

import lombok.*;

public class BlackCust extends Customer {

	@Override
	public boolean chkCustomerGubun() {
		return false;
	}

}
