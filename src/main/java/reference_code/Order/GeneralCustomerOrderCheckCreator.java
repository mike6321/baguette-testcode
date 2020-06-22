package reference_code.Order;


import reference_code.Customer.Customer;

/**
 * Project : croissant
 *
 * @author : jwdeveloper
 * @comment :
 * Time : 1:10 오전
 */
public class GeneralCustomerOrderCheckCreator extends OrderCheckCreator{
    @Override
    protected CustomerOrderCheck createOrderCheck() {
        return new GeneralCustomerOrderCheck();
    }

    @Override
    protected boolean authorizationCheck(String userId) {
        Customer customer = Customer.getInstance();

        // TODO: [블랙 컨슈머 고객인지 체크] junwoochoi 2020/05/06 1:51 오전
        // 일반고객일 경우 블랙컨슈머 여부를 체크하며 블랙컨슈머이면 주문 불가
       return customer.blackConSumerCheck(userId);
    }

}
