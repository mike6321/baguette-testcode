package com.github.fourteam.pikachu.week1.imesung.domain.product;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class GeneralProduct extends Product{

	private Long stock;
	private String supId;
	private Long price;
	private int prdCd;
	
	@Override
	public boolean checkProduct() {
		return stock > 0L;
	}

	@Override
	public Long checkPrdStock() {
		return this.stock;
	}

	@Override
	public String checkSupId() {
		return this.supId;
	}

	@Override
	public Long checkPrice() {
		return this.price;
	}

	public boolean checkGift() {
		return super.getGift().checkGift();
	}
}
