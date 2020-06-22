package reference_code.Payment;


import org.apache.log4j.Logger;

/**
 * Project : EffectiveStudy
 * Created by InteliJ IDE
 * Developer : junwoochoi
 * Date : 2020/05/06
 * Time : 9:55 오후
 */
public class CreditCard implements StrategyPayment{
    private static final Logger LOGGER = Logger.getLogger(CreditCard.class);

    @Override
    public void Payment() {
        LOGGER.info("신용카드 결제");
    }
}
