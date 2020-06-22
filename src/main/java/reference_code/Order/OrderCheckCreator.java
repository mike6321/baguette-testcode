package reference_code.Order;


import org.apache.log4j.Logger;
import reference_code.Login.LoginCheck;
import reference_code.client.ShopMain;

/**
 * Project : croissant
 *
 * @author : jwdeveloper
 * @comment :
 * Time : 1:20 오전
 */
public abstract class OrderCheckCreator {

    private static final Logger LOGGER = Logger.getLogger(OrderCheckCreator.class);
    protected abstract boolean authorizationCheck(String userId);


    public boolean checkOrder(String userId) {

        // TODO: [주문서에 진입 시 로그인 상태인지 체크] junwoochoi 2020/05/06 1:49 오전
        // 주문서에 진입 시 로그인 상태인지 체크한다. checkLoginStatus() : boolean
        // Cookie 값에 로그인 한 정보가 없으면 진입불가
        if (!checkLoginStatus())
            throw new Error("로그인 정보가 없습니다.");

        if (!authorizationCheck(ShopMain.sessionId)) {
            throw new Error("권한이 없습니다...");
        }

        return true;
    }

    private boolean checkLoginStatus() {
        return LoginCheck.loginState;
    }

    abstract protected CustomerOrderCheck createOrderCheck();
}
