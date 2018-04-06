
import com.myssm.model.User;
import com.myssm.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author hly
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/spring-mybatis.xml"})
public class test {
    @Resource
    private UserService userService;

    @Test
    public void test() {
        /*User user = userService.selectUserByUserid("admin");
        System.out.println("用户信息:" + user.toString());
        //userService.delete("admin");
        user.setPassword("666");
        userService.update(user);
        System.out.println("用户信息:" + user.toString());
        User us = new User("hly", "233", "y", 1, 1, "111", "111", "111", "111", 1);
        userService.insert(us);*/
        List<User> users = userService.selectAll();
        for (User user3 : users)
            System.out.println(user3.toString());


    }
}
