package reference_code.Payment;

/**
 * Project : EffectiveStudy
 * Created by InteliJ IDE
 * Developer : junwoochoi
 * Date : 2020/05/06
 * Time : 9:51 오후
 */
public class Payment {
    private StrategyPayment payment;


    public void setPayment(StrategyPayment payment) {
        this.payment = payment;
    }

    public void pay() {
        payment.Payment();
    }

}
