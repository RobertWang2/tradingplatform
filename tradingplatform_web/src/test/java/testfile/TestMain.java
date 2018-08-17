package testfile;

import com.xyz.biz.UserService;
import com.xyz.dao.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * @program: tradingplatform
 * @description:
 * @author: Robert_Wang
 * @create: 2018-08-17 08:18
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class TestMain {

    @Resource(name = "userService")
    private UserService userService;

    @Test
    public void test(){
        User user = userService.queryById(1);
        System.out.println("username :" + user.getUsername());
//       System.out.println(userService.queryByUsername("Robert_Wang").getUsername());

    }
}

