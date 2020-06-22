package com.github.fourteam.pikachu.week1.imesung.domain.customer;

import com.github.fourteam.pikachu.week1.imesung.domain.product.Product;
import lombok.Builder;

import java.util.ArrayList;
import java.util.List;

public class PartnerCust extends Customer {

	private List<Product> products = new ArrayList<>();
	
	@Override
	public boolean chkCustomerGubun() {
		return products.size() >= 3;
	}
}
