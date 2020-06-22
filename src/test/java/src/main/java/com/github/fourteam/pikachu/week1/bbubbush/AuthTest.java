package src.main.java.com.github.fourteam.pikachu.week1.bbubbush;

import com.github.fourteam.pikachu.week1.bbubbush.domain.Customer;
import com.github.fourteam.pikachu.week1.bbubbush.domain.OrderSheet;
import com.github.fourteam.pikachu.week1.bbubbush.domain.Product;
import com.github.fourteam.pikachu.week1.bbubbush.exception.RequiredValueException;
import com.github.fourteam.pikachu.week1.bbubbush.type.CustomerType;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.hamcrest.core.Is;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Type;

import static com.github.fourteam.pikachu.week1.bbubbush.type.CustomerType.Employees;
import static com.github.fourteam.pikachu.week1.bbubbush.type.CustomerType.Normal;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.AllOf.allOf;
import static org.hamcrest.core.Is.*;

public class AuthTest {
    //고객타입
    /*CustomerType (int customerTypeValue) {
        this.customerTypeValue = customerTypeValue;
    }*/

    /*Employees(0)
    , Normal(1)*/
    //고객정보
    /*private String userId;		        // ID
    private String userName;		    // name
    private CustomerType userType;			        // 0: 임직원, 1: 일반고객
    private long point;			        // 보유포인트
    private boolean blackConsumerFlg;	// 블랙컨슈머 여부

    public static class Builder {
        // 필수값
        private final String userId;
        private final String userName;
        private final CustomerType userType;

        // 옵션
        private long hasPoint = 0;
        private boolean isBlackConsumer = false;

        public Builder (final String userid, final String userName, final CustomerType userType) {
            this.userId = userid;
            this.userName = userName;
            this.userType = userType;
        }

        public Customer.Builder hasPoint(final long hasPoint) {
            this.hasPoint = hasPoint;
            return this;
        }

        public Customer.Builder isBlackConsumer(boolean isBlackConsumer){
            this.isBlackConsumer = isBlackConsumer;
            return this;
        }

        public Customer builder() {
            if ( this.userId == null || this.userId.length() == 0 ) throw new RequiredValueException("고객 아이디는 필수값 입니다.");
            if ( this.userName == null || this.userName.length() == 0 ) throw new RequiredValueException("이름은 필수값 입니다.");
            if ( this.userType == null ) throw new RequiredValueException("고객유형은 필수값 입니다.");
            return new Customer(this);
        }
    }

    public Customer(Customer.Builder builder) {
        this.userId = builder.userId;
        this.userName = builder.userName;
        this.userType = builder.userType;
        this.point = builder.hasPoint;
        this.blackConsumerFlg = builder.isBlackConsumer;
    }

    public String getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public CustomerType getUserType() {
        return userType;
    }

    public long getPoint() {
        return point;
    }

    public boolean isBlackConsumerFlg() {
        return blackConsumerFlg;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", userType=" + userType +
                ", point=" + point +
                ", blackConsumerFlg=" + blackConsumerFlg +
                '}';
    }*/
    private Customer[] customers;
    private Product product;

    @Before
    public void init () {
        this.customers = new Customer[5];
        //일반1, 임직원1, 포인트없는임직원1, 블랙1, 임직원 중 블랙?
        this.customers[0] = new Customer.Builder("test1", "normal1", CustomerType.Normal).builder();
        this.customers[1] = new Customer.Builder("test2", "employee1", CustomerType.Employees)
                .hasPoint(1000L).builder();
        this.customers[2] = new Customer.Builder("test3", "noPointEmployee1", CustomerType.Employees).builder();
        this.customers[3] = new Customer.Builder("test4", "blackNormal1", CustomerType.Normal)
                .isBlackConsumer(true).builder();
        this.customers[4] = new Customer.Builder("test5", "blackEmployee1", CustomerType.Employees)
                .hasPoint(10000L)
                .isBlackConsumer(true)
                .builder();
    }
    /*private Customer checkedCustomer = null;
    public InitMatcher(Customer customer) {

        if (customer.getUserId().isEmpty()){
            throw new IllegalAccessException("고객정보가 없습니다");
        }
        this.checkedCustomer = customer;

        public void describeTo(Description description) {}
        public void describeMisMatchSafely(Customer customer, Description mismatchDescription ){

        }
    }*/
    //일반1, 임직원1, 포인트없는임직원1, 블랙1, 임직원 중 블랙?
    public Matcher<Customer> customerTest() {
        return new TypeSafeMatcher<Customer>() {
            Customer checkedCustomer;

            @Override
            protected boolean matchesSafely(Customer customer) {
                if (customer.getUserType() != Normal || customer.getUserType() != Employees){
                    checkedCustomer = customer;
                    return false;
                } else {
                    checkedCustomer = customer;
                    return true;
                }
            }

            @Override
            public void describeTo(Description description) {
                description.appendValue(checkedCustomer.getUserId() + " - 고객유형 확인");
            }
        };
    }
    public Matcher<Customer> noPointEmployeeTest() {
        return new TypeSafeMatcher<Customer>() {
            Customer checkedCustomer;

            @Override
            protected boolean matchesSafely(Customer customer) {
                if (customer.getUserType() == Employees && customer.getPoint() <= 0L) {
                    return false;
                } else {
                    checkedCustomer = customer;
                    return true;
                }
            }

            @Override
            public void describeTo(Description description) {
                description.appendValue(checkedCustomer.getUserId() + " - 임직원 포인트 확인");
            }
        };
    }
    public Matcher<Customer> blackCustomerTest() {
        return new TypeSafeMatcher<Customer>() {
            Customer checkedCustomer;

            @Override
            protected boolean matchesSafely(Customer customer) {
                if (!customer.isBlackConsumerFlg()){
                    return false;
                } else {
                    checkedCustomer = customer;
                    return true;
                }
            }

            @Override
            public void describeTo(Description description) {
                description.appendValue(checkedCustomer.getUserId() + " - 블랙리스트 확인");
            }
        };
    }

    @Test
    public void initTest() {
        assertThat(customers[0], is(customerTest()));
        assertThat(customers[1], allOf());
        assertThat(customers[2], allOf());
        assertThat(customers[3], allOf());
        assertThat(customers[4], is(blackCustomerTest()));

    }

}
