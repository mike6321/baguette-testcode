package com.github.fourteam.pikachu.week1.imesung.domain.product;

import com.github.fourteam.pikachu.week1.imesung.domain.customer.CustType;
import lombok.Builder;
import lombok.Getter;

@Builder @Getter
public class GiftProduct implements Gift {

	private Long stock;
	
	@Override
	public boolean checkGift() {
		return stock > 0L;
	}

}
