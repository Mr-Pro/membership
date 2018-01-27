package cn.lger.dao;

import cn.lger.domain.Member;
import cn.lger.domain.MemberGrade;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.*;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.util.List;

/**
 * Code that Changed the World
 * Pro said
 * Created by Pro on 2017-12-06.
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class TestMemberDao {

    @Resource
    private MemberDao memberDao;
    @Resource
    private MemberGradeDao memberGradeDao;

    /**
     * 测试会员保存
     */
    @Test
    public void test01(){
        Member member = new Member();
        member.setId("123123123");
        member.setBalance((float) 123.0);
        member.setSex("男");
        member.setBirthday(LocalDate.now().toString());
        member.setIconPath("/assets/icon/01.jpg");
        MemberGrade memberGrade = memberGradeDao.findMemberGradeById(1);
        member.setMemberGrade(memberGrade);
        member.setPassword("123");
        member.setPhone("122222222");
        member.setState("正常");
        member.setMemberName("sdhfhsdf");
        member.setMemberIntegral(123L);

        System.out.println(memberDao.save(member));
    }

    @Test
    public void test02(){
        Member member = memberDao.findMemberById("123123123");
        System.out.println(member);
    }

    /**
     * 查找一页内容
     */
    @Test
    public void test03(){
        Pageable pageable = new PageRequest(0, 3, Sort.Direction.ASC, "id");
        Page<Member> page = memberDao.findAll(pageable);
        System.out.println();
    }

    @Test
    public void test04(){
        Pageable pageable = new PageRequest(0, 3, Sort.Direction.ASC, "id");
        System.out.println(memberDao.findAllByMemberName("123", pageable));
    }

    /**
     * 测试删除功能
     */
    @Test
    public void test05(){
        memberDao.delete("201712151");
    }



    @Test
    public void test07(){
        Pageable pageable = new PageRequest(0, 1);
        Page<Member> page = memberDao.findAll(pageable);
        PageImpl page1 = (PageImpl) page;
        System.out.println(page1.getContent().get(0));
    }

    @Test
    public void test08(){
        List<Member> members = memberDao.findByBirthday(LocalDate.now());
        for (Member m: members
             ) {
            System.out.println(m);
        }
    }
}
