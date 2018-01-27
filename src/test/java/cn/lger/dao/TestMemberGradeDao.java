package cn.lger.dao;

import cn.lger.domain.MemberGrade;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * Code that Changed the World
 * Pro said
 * Created by Pro on 2017-12-16.
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class TestMemberGradeDao {

    @Resource
    private MemberGradeDao memberGradeDao;

    /**
     * 测试取出数据改变后数据库中的数据是否改变
     */
    @Test
    public void test01(){
        MemberGrade memberGrade = memberGradeDao.findMemberGradeById(1);
        System.out.println(memberGrade);
        memberGrade.setComment("测试数据存取");
        memberGradeDao.save(memberGrade);
    }
}
