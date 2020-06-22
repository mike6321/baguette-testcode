package com.github.fourteam.pikachu.week1.imesung.domain.customer;

import com.github.fourteam.pikachu.week1.bbubbush.type.CustomerType;
import com.github.fourteam.pikachu.week1.imesung.domain.product.Product;
import lombok.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;


@Builder @Getter @NoArgsConstructor @AllArgsConstructor @EqualsAndHashCode(of = {"userId"})
public class Customer {
	private static final Logger logger = LoggerFactory.getLogger(Customer.class);


	private String userId;		        // ID
	private String userName;		    // name
	private CustomerType userType;		// 0: 임직원, 1: 일반고객
	private long point;			        // 보유포인트
	private boolean blackConsumerFlg;	// 블랙컨슈머 여부
	private CustType custType;
	private String supId;

	public boolean chkCustomerGubun() {
		return true;
	}

	public boolean chkSupCustGubun(String supId, Long stock) {
		return this.supId != null && this.supId.equals(supId) && stock >= 3L;
	}

	public Boolean chkOrderFlgFromGift(Long stock) {
		if(this.custType == CustType.GENERAL) {
			return stock > 0L;
		} else if(this.custType == CustType.EXCUTIVES) {
			return stock == 0;
		} else if(this.custType == CustType.SUPPLIER) {
			return stock >= 10L;
		} else {
			return false;
		}
	}

	public Boolean chkPoint() {
		return this.point > 0L;
	}

	public int chkPrdListInfo(List<Product> products) {
		int chkCount = 0;
		for(int i = 0; i < products.size(); i++) {
			if(products.get(i).checkPrice() < this.point)
				chkCount++;
		}
		return chkCount;
	}
}
