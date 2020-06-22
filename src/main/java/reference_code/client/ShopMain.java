package reference_code.client;


import org.apache.log4j.Logger;
import reference_code.Customer.Customer;
import reference_code.Login.LoginCheck;
import reference_code.Order.EmployeeCustomerOrderCheckCreator;
import reference_code.Order.OrderCheckCreator;
import reference_code.Payment.Kakaopay;
import reference_code.Payment.Payment;
import reference_code.Product.Product;

/**
 * Project : EffectiveStudy
 * Created by InteliJ IDE
 * Developer : junwoochoi
 * Date : 2020/05/02
 * Time : 11:57 오후
 */
public class ShopMain {

    private static final Logger LOGGER = Logger.getLogger(ShopMain.class);
    public static String sessionId;


    public static void main(String[] args) {

        String userId = "mike6321";
        ShopMain.sessionId = userId;

        Customer customer = Customer.getInstance();
        boolean checkCustomer = customer.checkCustomer(customer);

        LoginCheck.checkLogin(userId, checkCustomer);
        System.out.println(LoginCheck.loginState);

        // TODO: [주문가능한 상태인지를 체크 블랙컨슈머 / 일반고객 ] junwoochoi 2020/05/06 8:48 오후
        // 팩토리 메서드 구현 예정
        //OrderCheck orderCheck = new EmployeeCustomerOrderCheck();
        //CustomerOrderCheck customerOrderCheck = new EmployeeCustomerOrderCheckCreator();

        OrderCheckCreator orderCheckCreator = new EmployeeCustomerOrderCheckCreator();



        // TODO: [상품에 대한 재고 체크] junwoochoi 2020/05/06 9:08 오후
        LOGGER.info("****************************상품을 선택하세요****************************");
        Product.ProductInfo();
        LOGGER.info("****************************상품을 선택하세요****************************");



        // TODO: [상품의 재고 체크] junwoochoi 2020/05/06 9:25 오후
        Product product = new Product(111111);
        checkStock(product);
        checkGiftStock(product);


        // TODO: [결제방식 선택] junwoochoi 2020/05/06 9:54 오후
        // 전략패턴 사용
        Payment payment = new Payment();
        payment.setPayment(new Kakaopay());
        payment.pay();

    }


    private static void checkGiftStock(Product product) {
        boolean checkGiftProduct = product.checkGiftProduct(product);
        if (checkGiftProduct) {
            LOGGER.info("해당 사은품의 재고가 없습니다.");
        } else {
            LOGGER.info("해당 사은품의 재고가 존재합니다.");
        }
    }


    private static void checkStock(Product product) {
        boolean checkStockProduct = product.checkStockProduct(product);

        if (!checkStockProduct) {
            LOGGER.info("해당 상품의 재고가 존재하지 않습니다...");
        }else {
            LOGGER.info("해당 상품의 재고가 존재합니다!");
        }
    }


}

