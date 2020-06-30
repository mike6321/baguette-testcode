package com.github.fourteam.pikachu.week1.imesung.domain.payment;

import com.github.fourteam.pikachu.week1.imesung.domain.customer.Customer;
import com.github.fourteam.pikachu.week1.imesung.domain.product.Product;
import lombok.Builder;
import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@Builder @Getter
public class PaymentImpl implements Payment {

    private String orderDtm;

    private static final Logger logger = LoggerFactory.getLogger(PaymentImpl.class);

    @Override
    public boolean payment(Customer customer, Product product) {
        return chkPayment(customer.getPoint(), product.checkPrice());
    }

    //주문 취소 가능 여부 체크
    @Override
    public boolean checkCancelOrder() {
        if(chkCancelDate()) {
            return cancelOrder();
        }
        return false;
    }

    @Override
    public boolean cancelOrder() {
        logger.info("주문 취소 완료");
        return true;
    }

    private boolean chkPayment(Long point, Long price) {
        if(point != 0 && (price - point) >= 1000L) {
            logger.info("포인트 " + point + "사용하였습니다.");
            logger.info("남은 금액 " + (price-point) + "원을 결제하였습니다.");
            return true;
        }
        return false;
    }

    private boolean chkCancelDate() {
        try {
            Calendar cal = Calendar.getInstance();
            cal.setTime(new Date());
            DateFormat format = new SimpleDateFormat("yyyyMMdd");
            logger.info("현재날짜 : " + format.format(cal.getTime()));
            logger.info("pay 날짜 : " + this.orderDtm);

            Date curDate = format.parse(format.format(cal.getTime()));
            Date payDate = format.parse(this.orderDtm);

            long resultDate = curDate.getTime() - payDate.getTime();
            resultDate = resultDate / (24*60*60*1000);

            logger.info("비교 : " + resultDate);

            if(resultDate <= 7) {
                return true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
