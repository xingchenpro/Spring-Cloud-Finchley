
import com.myssm.model.User;
import com.myssm.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * @author hly
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/spring-mybatis.xml"})
public class test {
    @Resource
    private UserService userService;
    @Test
    public void test(){
        System.out.println(userService);
        User user = userService.selectUserByUserid("admin");
       System.out.println("用户信息:"+user.toString());
    }
}
