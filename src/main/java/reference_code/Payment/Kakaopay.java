package reference_code.Payment;


import org.apache.log4j.Logger;

/**
 * Project : EffectiveStudy
 * Created by InteliJ IDE
 * Developer : junwoochoi
 * Date : 2020/05/06
 * Time : 9:50 오후
 */
public class Kakaopay implements StrategyPayment{
    private static final Logger LOGGER = Logger.getLogger(Kakaopay.class);

    @Override
    public void Payment() {
        LOGGER.info("카카오페이 결제");
    }
}
