package com.github.fourteam.pikachu.week1.bbubbush.domain;

import com.github.fourteam.pikachu.week1.bbubbush.exception.RequiredValueException;

public class Product implements Products {
    private final long prdCd;      // 상품코드
    private final long prdPrc;     // 상품가격
    private final GiftProduct gift;     // 사은품 코드 - 0 일 경우 사은품 없음!
    private final int stock;       // 재고

    public static class Builder {
        // 필수값
        private long productCode;
        private long productPrice;

        // 기본값이 존재하는 옵션
        private GiftProduct gift = new GiftProduct.Builder(0L, 0).build();
        private int stock = 0;

        public Builder () {
        }
        public Builder productCode(long productCode) {
            this.productCode = productCode;
            return this;
        }
        public Builder productPrice(long productPrice) {
            this.productPrice = productPrice;
            return this;
        }
        public Builder gift(GiftProduct gift) {
            this.gift = gift;
            return this;
        }
        public Builder stock(int stock) {
            this.stock = stock;
            return this;
        }

        public Product build() {
            if ( this.productCode == 0L ) throw new RequiredValueException("상품코드는 필수값 입니다.");
            if ( this.productPrice == 0L ) throw new RequiredValueException("상품가격은 필수값 입니다.");

            return new Product(this);
        }
    }

    private Product(Builder builder) {
        this.prdCd = builder.productCode;
        this.prdPrc = builder.productPrice;
        this.gift = builder.gift;
        this.stock = builder.stock;
    }

    public long getPrdCd() {
        return prdCd;
    }

    public long getPrdPrc() {
        return prdPrc;
    }

    public GiftProduct getGift() {
        return gift;
    }

    public int getStock() {
        return stock;
    }


    @Override
    public String toString() {
        return "Product{" +
                "prdCd=" + prdCd +
                ", prdPrc=" + prdPrc +
                ", gift=" + gift +
                ", stock=" + stock +
                '}';
    }

    /**
     * Name: 상품의 재고를 확인
     * Date: 2020/05/29
     * Info:
     *  상품 재고가 없으면 false, 있으면 true
     *  checkGift() 기능 구현
     */
    @Override
    public boolean checkHasStock() {
        return this.stock > 0;
    }
}
