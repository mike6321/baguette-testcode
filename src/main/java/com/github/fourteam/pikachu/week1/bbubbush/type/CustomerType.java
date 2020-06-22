package com.github.fourteam.pikachu.week1.bbubbush.type;

public enum CustomerType {

    Employees(0)
    , Normal(1)
    , CanNotOrder(2)
    ;

    private int customerTypeValue;

    CustomerType (int customerTypeValue) {
        this.customerTypeValue = customerTypeValue;
    }

    /**
     * Name: 고객유형을 정해진 값으로 전달
     * Date: 2020/05/29
     * Info:
     *  임직원 - 0
     *  일반고객 - 1
     *  거래거절고객 - 2
     */
    public int getCustomerTypeValue() {
        return customerTypeValue;
    }
}
