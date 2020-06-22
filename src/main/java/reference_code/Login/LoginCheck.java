package reference_code.Login;


import org.apache.log4j.Logger;
import reference_code.client.ShopMain;

/**
 * Project : EffectiveStudy
 * Created by InteliJ IDE
 * Developer : junwoochoi
 * Date : 2020/05/03
 * Time : 1:26 오전
 */
public class LoginCheck {
    private static final Logger LOGGER = Logger.getLogger(LoginCheck.class);
    public static boolean loginState = false;


    // TODO: [로그인 여부 체크] junwoochoi 2020/05/06 2:10 오전
    public static void isTrueLogin() {
        LoginCheck.loginState = true;
    }

    // TODO: [로그인 체킹] junwoochoi 2020/05/06 2:11 오전
    public static void checkLogin(String userId, boolean checkCustomer) {
        if (checkCustomer) {
            LOGGER.info(userId + " 님  환영합니다!");
        } else {
            LOGGER.info("회원이 아니십니다!");
            ShopMain.sessionId = "";
            LOGGER.info("expire session Id");
        }
    }
}
