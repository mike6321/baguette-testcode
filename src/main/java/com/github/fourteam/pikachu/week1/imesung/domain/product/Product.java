package com.github.fourteam.pikachu.week1.imesung.domain.product;

import lombok.Getter;

@Getter
public abstract class Product {
	private Gift gift;
	
	public boolean checkGift() {
		return gift.checkGift();
	}
	public abstract boolean checkProduct();
	public abstract Long checkPrdStock();
	public abstract String checkSupId();
	public abstract Long checkPrice();

}