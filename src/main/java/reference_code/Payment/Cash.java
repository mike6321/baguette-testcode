package reference_code.Payment;

import org.apache.log4j.Logger;

/**
 * Project : EffectiveStudy
 * Created by InteliJ IDE
 * Developer : junwoochoi
 * Date : 2020/05/06
 * Time : 9:56 오후
 */
public class Cash implements StrategyPayment{
    private static final Logger LOGGER = Logger.getLogger(Cash.class);

    @Override
    public void Payment() {
        LOGGER.info("현금 결제");
    }
}
