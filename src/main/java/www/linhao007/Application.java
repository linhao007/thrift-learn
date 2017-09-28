package www.linhao007;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import www.linhao007.event.service.UserService;
import www.linhao007.pojo.User;

/**
 * Created by linhu on 17/9/28.
 */
public class Application {
    private static UserService userService;
    protected static Logger LOGGER = LoggerFactory.getLogger(Application.class);

    static {
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("spring-context.xml");
        userService = (UserService) beanFactory.getBean("userService");
    }

    public static void main(String[] args) throws InterruptedException {
        User user = new User();
        user.setAge(18);
        user.setName("linhao007");
        user.setIdentityId(1234567899L);
        user.setSex("man");
        userService.SyncCreateUser(user);
        LOGGER.info("end");
    }
}
