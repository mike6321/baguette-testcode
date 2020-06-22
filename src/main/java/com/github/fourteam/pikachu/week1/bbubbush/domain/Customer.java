package com.github.fourteam.pikachu.week1.bbubbush.domain;

import com.github.fourteam.pikachu.week1.bbubbush.exception.RequiredValueException;
import com.github.fourteam.pikachu.week1.bbubbush.type.CustomerType;

/**
* Name: 회원 객체
* Date: 2020/05/29
* Info:
*/
public class Customer {

    private String userId;		        // ID
    private String userName;		    // name
    private CustomerType userType;			        // 0: 임직원, 1: 일반고객
    private long point;			        // 보유포인트
    private boolean blackConsumerFlg;	// 블랙컨슈머 여부
    
    public static class Builder {
        // 필수값
        private final String userId;
        private final String userName;
        private final CustomerType userType;

        // 옵션
        private long hasPoint = 0;
        private boolean isBlackConsumer = false;

        public Builder (final String userid, final String userName, final CustomerType userType) {
            this.userId = userid;
            this.userName = userName;
            this.userType = userType;
        }

        public Builder hasPoint(final long hasPoint) {
            this.hasPoint = hasPoint;
            return this;
        }

        public Builder isBlackConsumer(boolean isBlackConsumer){
            this.isBlackConsumer = isBlackConsumer;
            return this;
        }

        public Customer builder() {
            if ( this.userId == null || this.userId.length() == 0 ) throw new RequiredValueException("고객 아이디는 필수값 입니다.");
            if ( this.userName == null || this.userName.length() == 0 ) throw new RequiredValueException("이름은 필수값 입니다.");
            if ( this.userType == null ) throw new RequiredValueException("고객유형은 필수값 입니다.");
            return new Customer(this);
        }
    }

    public Customer(Builder builder) {
        this.userId = builder.userId;
        this.userName = builder.userName;
        this.userType = builder.userType;
        this.point = builder.hasPoint;
        this.blackConsumerFlg = builder.isBlackConsumer;
    }

    public String getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public CustomerType getUserType() {
        return userType;
    }

    public long getPoint() {
        return point;
    }

    public boolean isBlackConsumerFlg() {
        return blackConsumerFlg;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", userType=" + userType +
                ", point=" + point +
                ", blackConsumerFlg=" + blackConsumerFlg +
                '}';
    }
    /**
     * Name: 고객의 주문가능상태 확인
     * Date: 2020/05/29
     * Info:
     *  직원 - 포인트가 없으면 주문불가
     *  일반고객 - 블랙컨슈머이면 주문불가
     *  거래거절고객 - 그냥 주문불가
     */
    public boolean checkCustomerStatus() {
        if ( this.userType.equals(CustomerType.Employees) ) {
            if ( this.point == 0L ) return false;
        }
        else if ( this.userType.equals(CustomerType.Normal) ) {
            if ( this.isBlackConsumerFlg() ) return false;
        }
        else if ( this.userType.equals(CustomerType.CanNotOrder) ) {
            return false;
        }
        return true;
    }

    /**
     * Name: 포인트를 사용할 수 있는지 확인
     * Date: 2020/05/29
     * Info:
     *  3000점 이상 되어야 포인트 사용
     */
    public boolean canUsePoint(){
        return this.point >= 3000L;
    }

    /**
     * Name: 포인트 사용하기
     * Date: 2020/05/29
     * Info:
     *  고객이 가진 포인트를 사용
     */
    public void usePoint (long spendPoint) {
        this.point -= spendPoint;
    }

}