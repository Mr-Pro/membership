package cn.lger.dao;

import cn.lger.domain.Admin;
import cn.lger.domain.AdminRole;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.IOException;

/**
 * Code that Changed the World
 * Pro said
 * Created by Pro on 2017-12-13.
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class TestAdminDao {

    @Resource
    private AdminDao adminDao;

    /**
     * 测试保存会员
     */
    @Test
    @Transactional
    public void test01(){
        Admin admin = new Admin();
        admin.setId(123);
        admin.setUsername("123");
        admin.setPassword("123");
        admin.setRole(AdminRole.G_ADMIN);

        adminDao.save(admin);
    }

    /**
     * 测试保存超级会员
     */
    @Test
    public void test02(){
        Admin admin = new Admin();
        admin.setUsername("admin");
        admin.setPassword("admin");
        admin.setRole(AdminRole.S_ADMIN);

        adminDao.save(admin);
    }

    @Test
    public void test03() throws IOException {
        Admin admin = adminDao.findAdminByUsername("asds");
//        Runtime.getRuntime().exec( "cmd   cls ");
        System.out.println(admin == null);
    }
}
