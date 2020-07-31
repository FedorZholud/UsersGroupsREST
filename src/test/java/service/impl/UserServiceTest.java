package service.impl;

import com.zholud.usersgroupsrest.service.UserService;
import config.UserServiceTestConfiguration;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ActiveProfiles("userServiceTest")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = UserServiceTestConfiguration.class)
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Before
    public void createUser() {

    }

    @Test
    public void findById() {

    }
}
